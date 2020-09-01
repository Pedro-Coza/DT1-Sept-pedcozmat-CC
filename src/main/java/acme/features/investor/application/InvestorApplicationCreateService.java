
package acme.features.investor.application;

import java.time.Year;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.application.Application;
import acme.entities.investmentRound.InvestmentRound;
import acme.entities.roles.Investor;
import acme.entities.spamlist.Spamlist;
import acme.entities.spamlist.Spamword;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class InvestorApplicationCreateService implements AbstractCreateService<Investor, Application> {

	@Autowired
	InvestorApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		boolean res = false;
		assert request != null;

		Integer principalId = request.getPrincipal().getActiveRoleId();
		Investor i = this.repository.findInvestorById(principalId);
		if (i != null) {
			String iRId = request.getServletRequest().getParameter("id");

			InvestmentRound iR = this.repository.findOneInvestmentRoundById(Integer.parseInt(iRId));
			if (iR.getActive().equals("ACTIVE")) {
				res = true;
			}
		}
		return res;
	}

	@Override
	public void bind(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "statement", "invOffer", "xxxxOffer", "link", "password");

		model.setAttribute("id", request.getServletRequest().getParameter("id"));

		String invRId = request.getServletRequest().getParameter("id");
		InvestmentRound invR = this.repository.findOneInvestmentRoundById(Integer.parseInt(invRId));
		String invRoundPrefix = invR.getTicker().substring(0, 3);
		String currentYear = Year.now().toString().substring(2);
		String placeholder = invRoundPrefix + "-" + currentYear + "-";

		model.setAttribute("ticker", placeholder);
		model.setAttribute("xxxxOffer", "xxxxOffer: " + invR.getXXXX());
	}

	@Override
	public Application instantiate(final Request<Application> request) {

		Application result = new Application();

		Integer investorId = request.getPrincipal().getActiveRoleId();
		Investor inv = this.repository.findOneInvestorById(investorId);
		result.setInvestor(inv);

		String invRId = request.getServletRequest().getParameter("id");

		InvestmentRound invR = this.repository.findOneInvestmentRoundById(Integer.parseInt(invRId));
		result.setInvRound(invR);

		result.setStatus("PENDING");

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		result.setCreationDate(moment);

		result.setJustification("");

		return result;
	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Boolean isSpamEN, isSpamES;
		String reallyBigString;
		reallyBigString = request.getModel().getString("statement") + request.getModel().getString("xxxxOffer");
		Spamlist spamEN = this.repository.findSpamLists("EN");
		Spamlist spamES = this.repository.findSpamLists("ES");

		isSpamEN = this.isSpam(reallyBigString, spamEN);
		isSpamES = this.isSpam(reallyBigString, spamES);

		String tickerInput = request.getServletRequest().getParameter("ticker");

		String currentYear = Year.now().toString().substring(2);

		String invRId = request.getServletRequest().getParameter("id");
		InvestmentRound invR = this.repository.findOneInvestmentRoundById(Integer.parseInt(invRId));
		String invRoundPrefix = invR.getTicker().substring(0, 3);

		Boolean tickerFormat = tickerInput.matches(invRoundPrefix + "-" + currentYear + "-[0-9]{6}");

		String money = request.getServletRequest().getParameter("invOffer");

		Boolean currencyValue = money.contains("EUR") || money.contains("€");

		request.getModel().setAttribute("spamEN", isSpamEN);
		request.getModel().setAttribute("spamES", isSpamES);

		String link = request.getModel().getString("link");
		String password = request.getModel().getString("password");

		Boolean passMatchesPattern = password.matches("^$|^(?=(.*[a-zA-Z])){1,}(?=(.*[\\d])){1,}(?=(.*[\\W])){1,}.{10,}$");
		Boolean emptyLinkWPass = link.equals("") && !password.equals("");

		if (!errors.hasErrors()) {
			errors.state(request, tickerFormat, "ticker", "acme.validation.tickerFormat");
			if (!isSpamEN && !isSpamES) {
				errors.state(request, !isSpamEN && !isSpamES, "statement", "acme.validation.spamBoth");
			} else {
				errors.state(request, isSpamEN && !isSpamES, "statement", "acme.validation.spamEN");
				errors.state(request, !isSpamEN && isSpamES, "statement", "acme.validation.spamEN");
			}
			errors.state(request, currencyValue, "invOffer", "acme.validation.currency");
			errors.state(request, !emptyLinkWPass, "link", "acme.validation.emptyLink");
			errors.state(request, passMatchesPattern, "password", "acme.validation.password");
		}
	}

	@Override
	public void create(final Request<Application> request, final Application entity) {
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setCreationDate(moment);

		String invRId = request.getServletRequest().getParameter("id");
		InvestmentRound invR = this.repository.findOneInvestmentRoundById(Integer.parseInt(invRId));

		entity.setInvRound(invR);

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
