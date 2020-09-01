
package acme.features.enterpreneur.application;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.application.Application;
import acme.entities.investmentRound.InvestmentRound;
import acme.entities.roles.Enterpreneur;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractUpdateService;

@Service
public class EnterpreneurApplicationUpdateService implements AbstractUpdateService<Enterpreneur, Application> {

	//Repository
	@Autowired
	EnterpreneurApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;
		Boolean enterpOk = false;

		Integer enterpId = request.getPrincipal().getActiveRoleId();

		Collection<InvestmentRound> cIR = this.repository.findInvRoundByEnterpreneurId(enterpId);

		for (InvestmentRound iR : cIR) {
			for (Application a : iR.getApplication()) {
				if (a.getId() == request.getModel().getInteger("id")) {
					enterpOk = true;
				}
			}
		}

		return enterpOk;
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

		request.unbind(entity, model, "status", "justification", "xxxxOffer", "link", "password");

		Boolean pwdProtected = !entity.getPassword().isEmpty() && entity.getPassword() != null;
		if (pwdProtected) {
			model.setAttribute("pwdProtected", true);
		} else if (request.getServletRequest().getParameter("pwdProtected") == "true") {
			model.setAttribute("pwdProtected", true);
		}
		model.setAttribute("pwdOk", false);
	}

	@Override
	public Application findOne(final Request<Application> request) {

		assert request != null;

		Application result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;

	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Boolean isRejectedEmpty = request.getModel().getAttribute("status").equals("REJECTED") && request.getModel().getAttribute("justification").toString().isEmpty();

		if (!errors.hasErrors("status")) {
			errors.state(request, !isRejectedEmpty, "justification", "acme.validation.justification");
		}
		Boolean pwdProtected = !entity.getPassword().isEmpty() && entity.getPassword() != null;
		request.getModel().setAttribute("pwdProtected", pwdProtected);

		String pass = "";
		Boolean pending = request.getServletRequest().getParameter("status") == "PENDING";

		if (request.getServletRequest().getParameter("password") != null && !pending) {
			pass = request.getServletRequest().getParameter("password");
			Boolean pwdOk = !entity.getPassword().isEmpty() && entity.getPassword().equals(pass);

			request.getModel().setAttribute("pwdOk", pwdOk);

			if (!errors.hasErrors("password")) {
				errors.state(request, pwdOk, "password", "acme.validation.pwdWrong");
				//errors.state(request, !pwdOk, "password", "acme.validation.pwdOk");
			}
		}

	}

	@Override
	public void update(final Request<Application> request, final Application entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
