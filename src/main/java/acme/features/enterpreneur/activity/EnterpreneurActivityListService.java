
package acme.features.enterpreneur.activity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.activity.Activity;
import acme.entities.roles.Enterpreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class EnterpreneurActivityListService implements AbstractListService<Enterpreneur, Activity> {

	@Autowired
	EnterpreneurActivityRepository repository;


	@Override
	public boolean authorise(final Request<Activity> request) {
		assert request != null;
		//Compruebo que el Principal es Enterpreneur
		Integer id = request.getPrincipal().getActiveRoleId();

		Enterpreneur e = this.repository.findOneEnterpreneurById(id);

		return e != null;
	}

	@Override
	public void unbind(final Request<Activity> request, final Activity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "startDate", "endDate", "budget");

	}

	@Override
	public Collection<Activity> findMany(final Request<Activity> request) {
		assert request != null;

		Collection<Activity> result;

		String wPId = request.getServletRequest().getParameter("idW");
		result = this.repository.findManyByWPId(Integer.parseInt(wPId));

		return result;
	}
}
