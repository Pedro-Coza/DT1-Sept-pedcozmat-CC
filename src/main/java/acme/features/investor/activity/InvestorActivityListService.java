
package acme.features.investor.activity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.activity.Activity;
import acme.entities.roles.Investor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class InvestorActivityListService implements AbstractListService<Investor, Activity> {

	@Autowired
	InvestorActivityRepository repository;


	@Override
	public boolean authorise(final Request<Activity> request) {
		assert request != null;
		return true;
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

		String wPId = request.getServletRequest().getParameter("id");
		result = this.repository.findManyByWPId(Integer.parseInt(wPId));

		return result;
	}
}
