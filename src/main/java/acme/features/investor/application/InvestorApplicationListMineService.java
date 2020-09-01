
package acme.features.investor.application;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.application.Application;
import acme.entities.roles.Investor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class InvestorApplicationListMineService implements AbstractListService<Investor, Application> {

	@Autowired
	InvestorApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;
		Integer principalId = request.getPrincipal().getActiveRoleId();
		Investor i = this.repository.findInvestorById(principalId);

		return i != null;
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "creationDate", "statement", "invOffer", "status", "xxxxOffer", "link", "password");
	}

	@Override
	public Collection<Application> findMany(final Request<Application> request) {
		assert request != null;

		Collection<Application> result = new ArrayList<Application>();

		result = this.repository.findManyMine(request.getPrincipal().getActiveRoleId());

		return result;
	}
}
