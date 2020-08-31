
package acme.features.enterpreneur.application;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.application.Application;
import acme.entities.roles.Enterpreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class EnterpreneurApplicationListMineService implements AbstractListService<Enterpreneur, Application> {

	@Autowired
	EnterpreneurApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "creationDate", "statement", "invOffer", "status", "justification");
	}

	@Override
	public Collection<Application> findMany(final Request<Application> request) {
		assert request != null;

		Collection<Application> result = new ArrayList<Application>();

		Collection<Integer> ids = this.repository.findInvRoundIdbyEnterpreneurId(request.getPrincipal().getActiveRoleId());

		for (Integer i : ids) {
			result.addAll(this.repository.findApplicationsByIVID(i));
		}

		return result;
	}
}
