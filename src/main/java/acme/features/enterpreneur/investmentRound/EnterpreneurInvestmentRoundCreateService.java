
package acme.features.enterpreneur.investmentRound;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.accountingRecord.AccountingRecord;
import acme.entities.application.Application;
import acme.entities.forum.Forum;
import acme.entities.forum.ForumAuthenticated;
import acme.entities.investmentRound.InvestmentRound;
import acme.entities.roles.Enterpreneur;
import acme.entities.spamlist.Spamlist;
import acme.entities.spamlist.Spamword;
import acme.entities.workProgramme.WorkProgramme;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EnterpreneurInvestmentRoundCreateService implements AbstractCreateService<Enterpreneur, InvestmentRound> {

	@Autowired
	EnterpreneurInvestmentRoundRepository repository;


	@Override
	public boolean authorise(final Request<InvestmentRound> request) {
		assert request != null;
		//Compruebo que el id del Principal activo corresponde a un Enterpreneur
		Integer id = request.getPrincipal().getActiveRoleId();

		Enterpreneur e = this.repository.findOneEnterpreneurById(id);

		return e != null;
	}

	@Override
	public void bind(final Request<InvestmentRound> request, final InvestmentRound entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creationDate", "active");
	}

	@Override
	public void unbind(final Request<InvestmentRound> request, final InvestmentRound entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "kindRound", "title", "money", "info", "money");
	}

	@Override
	public InvestmentRound instantiate(final Request<InvestmentRound> request) {

		InvestmentRound result = new InvestmentRound();

		Date moment = new Date(System.currentTimeMillis() - 1);
		Integer id = request.getPrincipal().getActiveRoleId();
		Enterpreneur e = this.repository.findOneEnterpreneurById(id);
		WorkProgramme wP = new WorkProgramme();
		Collection<Application> apps = new ArrayList<Application>();
		Collection<AccountingRecord> acRecords = new ArrayList<AccountingRecord>();

		result.setCreationDate(moment);
		result.setEnterpreneur(e);
		result.setAcRecord(acRecords);
		result.setApplication(apps);
		result.setWorkProg(wP);
		result.setActive("INACTIVE");
		;
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

		String tickerInput = request.getServletRequest().getParameter("ticker");

		String currentYear = Year.now().toString().substring(2);
		String enterpSectorPrefix = entity.getEnterpreneur().getActivitySector().substring(0, 3).toUpperCase();

		Boolean tickerFormat = tickerInput.matches(enterpSectorPrefix + "-" + currentYear + "-[0-9]{6}");

		String money = request.getServletRequest().getParameter("money");
		Boolean currencyValue = money.contains("EUR") || money.contains("€");

		request.getModel().setAttribute("spamEN", isSpamEN);
		request.getModel().setAttribute("spamES", isSpamES);

		if (!errors.hasErrors()) {
			errors.state(request, tickerFormat, "ticker", "acme.validation.tickerFormat");
			if (!isSpamEN && !isSpamES) {
				errors.state(request, !isSpamES && !isSpamEN, "title", "acme.validation.spamBoth");
			} else if (!isSpamEN && isSpamES || isSpamEN && !isSpamES) {
				errors.state(request, !isSpamEN, "title", "acme.validation.spamEN");
				errors.state(request, !isSpamES, "title", "acme.validation.spamES");
			}
			errors.state(request, currencyValue, "money", "acme.validation.currency");
		}
	}

	@Override
	public void create(final Request<InvestmentRound> request, final InvestmentRound entity) {

		Date moment = new Date(System.currentTimeMillis() - 1);

		Integer id = request.getPrincipal().getActiveRoleId();
		Enterpreneur e = this.repository.findOneEnterpreneurById(id);

		WorkProgramme wP = new WorkProgramme();
		wP.setInvRound(entity);
		this.repository.save(wP);

		entity.setWorkProg(wP);

		Forum f = new Forum();
		f.setAdministrator(e.getUserAccount());
		f.setCreationDate(moment);
		f.setInvRound(entity);
		f.setTitle("Forum of " + entity.getTitle() + " - [" + entity.getTicker() + "]");

		ForumAuthenticated fA = new ForumAuthenticated();
		fA.setForum(f);
		fA.setUser(e.getUserAccount());
		this.repository.save(fA);

		Collection<ForumAuthenticated> fAC = new ArrayList<ForumAuthenticated>();
		fAC.add(fA);

		f.setUsers(fAC);

		this.repository.save(f);
		entity.setForum(f);
		if (entity.getMoney().getCurrency().equals("EUR")) {
			entity.getMoney().setCurrency("€");
		}
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
