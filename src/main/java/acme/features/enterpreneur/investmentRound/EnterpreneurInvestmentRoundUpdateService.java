
package acme.features.enterpreneur.investmentRound;

import java.time.Year;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.activity.Activity;
import acme.entities.investmentRound.InvestmentRound;
import acme.entities.roles.Enterpreneur;
import acme.entities.spamlist.Spamlist;
import acme.entities.spamlist.Spamword;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractUpdateService;

@Service
public class EnterpreneurInvestmentRoundUpdateService implements AbstractUpdateService<Enterpreneur, InvestmentRound> {

	@Autowired
	EnterpreneurInvestmentRoundRepository repository;


	@Override
	public boolean authorise(final Request<InvestmentRound> request) {
		assert request != null;
		//Compruebo que el id del Enterpreneur Principal coincida con el del Enterpreneur asociado a este InvestmentRound
		//y que no esté en modo ACTIVE, por lo que aun se puede modificar
		Integer id = request.getPrincipal().getActiveRoleId();

		Enterpreneur e = this.repository.findOneEnterpreneurById(id);

		Boolean enterpOk = false;
		Integer iRId = request.getModel().getInteger("id");

		if (e != null) {
			enterpOk = this.repository.getEnterpIdByIRId(iRId).equals(id);
		}

		Boolean active = this.repository.findOneInvestmentRoundById(iRId).getActive().equals("ACTIVE");

		return enterpOk && !active;
	}

	@Override
	public void bind(final Request<InvestmentRound> request, final InvestmentRound entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<InvestmentRound> request, final InvestmentRound entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "kindRound", "title", "money", "info", "money", "active");

		Integer appsCount = this.repository.countAppsByIRId(entity.getId());

		model.setAttribute("workProgId", entity.getWorkProg().getId());
		model.setAttribute("appsCount", appsCount);
		model.setAttribute("invRoundId", entity.getId());
		model.setAttribute("active", entity.getActive());
		model.setAttribute("idW", request.getServletRequest().getParameter("workProgId"));
	}

	@Override
	public InvestmentRound findOne(final Request<InvestmentRound> request) {
		assert request != null;

		InvestmentRound result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneInvestmentRoundById(id);
		return result;
	}

	@Override
	public void validate(final Request<InvestmentRound> request, final InvestmentRound entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Boolean isSpamEN, isSpamES;
		String reallyBigString;
		reallyBigString = request.getModel().getString("title") + " " + request.getModel().getString("info");
		Spamlist spamEN = this.repository.findSpamLists("EN");
		Spamlist spamES = this.repository.findSpamLists("ES");

		isSpamEN = this.isSpam(reallyBigString, spamEN);
		isSpamES = this.isSpam(reallyBigString, spamES);

		String active = request.getServletRequest().getParameter("active");

		String tickerInput = request.getServletRequest().getParameter("ticker");

		String currentYear = Year.now().toString().substring(2);
		String enterpSectorPrefix = entity.getEnterpreneur().getActivitySector().substring(0, 3).toUpperCase();

		Boolean tickerFormat = tickerInput.matches(enterpSectorPrefix + "-" + currentYear + "-[0-9]{6}");

		String money = request.getServletRequest().getParameter("money");

		Boolean currencyValue = money.contains("EUR") || money.contains("€");

		request.getModel().setAttribute("spamEN", isSpamEN);
		request.getModel().setAttribute("spamES", isSpamES);

		Collection<Activity> cA = this.repository.findActivitiesByWPId(entity.getWorkProg().getId());

		Double totalBudget = 0.;
		for (Activity a : cA) {
			totalBudget += a.getBudget().getAmount();
		}

		Boolean activable = totalBudget >= entity.getMoney().getAmount();

		if (!errors.hasErrors("active") && active.equals("ACTIVE")) {
			errors.state(request, activable, "active", "acme.validation.active");
			request.getModel().setAttribute("active", "INACTIVE");
		}
		if (!errors.hasErrors()) {
			errors.state(request, tickerFormat, "ticker", "acme.validation.tickerFormat");
			errors.state(request, !isSpamEN, "title", "acme.validation.spamEN");
			errors.state(request, !isSpamES, "title", "acme.validation.spamES");
			errors.state(request, !isSpamES && !isSpamEN, "title", "acme.validation.spamBoth");
			errors.state(request, currencyValue, "money", "acme.validation.currency");
		}
	}

	@Override
	public void update(final Request<InvestmentRound> request, final InvestmentRound entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

	// Método Auxiliar

	private Boolean isSpam(final String reallyBigString, final Spamlist sl) {

		Collection<Spamword> spamwords = sl.getSpamwordslist();

		Double numSpamWords = 0.;

		for (Spamword sw : spamwords) {
			String spamword = sw.getSpamword();
			numSpamWords = numSpamWords + this.numDeSpamwords(reallyBigString.toLowerCase(), spamword, 0.);
		}

		int totalOfWords = reallyBigString.split(" ").length;

		Double percent = numSpamWords * 100 / totalOfWords;

		return percent >= sl.getThreshold();
	}

	private Double numDeSpamwords(final String fullText, final String spamword, final Double u) {
		if (!fullText.contains(spamword)) {
			return u;
		} else {
			Integer a = fullText.indexOf(spamword);
			return this.numDeSpamwords(fullText.substring(a + 1), spamword, u + 1);
		}
	}
}
