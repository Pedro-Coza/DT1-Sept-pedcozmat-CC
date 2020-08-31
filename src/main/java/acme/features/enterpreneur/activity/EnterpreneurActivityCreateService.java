
package acme.features.enterpreneur.activity;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.activity.Activity;
import acme.entities.roles.Enterpreneur;
import acme.entities.spamlist.Spamlist;
import acme.entities.spamlist.Spamword;
import acme.entities.workProgramme.WorkProgramme;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EnterpreneurActivityCreateService implements AbstractCreateService<Enterpreneur, Activity> {

	@Autowired
	EnterpreneurActivityRepository repository;


	@Override
	public boolean authorise(final Request<Activity> request) {
		assert request != null;
		Integer id = request.getPrincipal().getActiveRoleId();

		Enterpreneur e = this.repository.findOneEnterpreneurById(id);

		return e != null;
	}

	@Override
	public void bind(final Request<Activity> request, final Activity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creationDate");
	}

	@Override
	public void unbind(final Request<Activity> request, final Activity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "endDate", "budget");

		model.setAttribute("workProgId", request.getServletRequest().getParameter("idW"));
	}

	@Override
	public Activity instantiate(final Request<Activity> request) {

		Activity result = new Activity();

		Date moment = new Date(System.currentTimeMillis() - 1);

		result.setStartDate(moment);

		return result;
	}

	@Override
	public void validate(final Request<Activity> request, final Activity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Boolean isSpamEN, isSpamES;
		String reallyBigString;
		reallyBigString = request.getModel().getString("title");
		Spamlist spamEN = this.repository.findSpamLists("EN");
		Spamlist spamES = this.repository.findSpamLists("ES");

		isSpamEN = this.isSpam(reallyBigString, spamEN);
		isSpamES = this.isSpam(reallyBigString, spamES);

		String money = request.getServletRequest().getParameter("budget");

		Boolean currencyValue = money.contains("EUR") || money.contains("€");

		request.getModel().setAttribute("spamEN", isSpamEN);
		request.getModel().setAttribute("spamES", isSpamES);

		if (!errors.hasErrors()) {
			errors.state(request, !isSpamEN, "title", "acme.validation.spamEN");
			errors.state(request, !isSpamES, "title", "acme.validation.spamES");
			errors.state(request, currencyValue, "budget", "acme.validation.currency");
		}
	}

	@Override
	public void create(final Request<Activity> request, final Activity entity) {

		String idWP = request.getServletRequest().getParameter("idW");

		WorkProgramme wP = this.repository.findOneWorkProgrammeById(Integer.parseInt(idWP));

		entity.setWorkProg(wP);

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
