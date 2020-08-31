
package acme.features.enterpreneur.application;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.application.Application;
import acme.entities.roles.Enterpreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class EnterpreneurApplicationListByTickerService implements AbstractListService<Enterpreneur, Application> {

	// Internal state ---------------------------------------------------------

	@Autowired
	EnterpreneurApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;
		Integer id = request.getPrincipal().getActiveRoleId();

		Enterpreneur e = this.repository.findOneEnterpreneurById(id);

		return e != null;
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

		Collection<Application> result;
		Principal principal;
		principal = request.getPrincipal();
		result = this.repository.findManyByTicker(principal.getActiveRoleId());

		return result;
	}

}