
package acme.features.investor.forum;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.application.Application;
import acme.entities.forum.Forum;
import acme.entities.roles.Investor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class InvestorForumShowService implements AbstractShowService<Investor, Forum> {

	@Autowired
	private InvestorForumRepository repository;


	@Override
	public boolean authorise(final Request<Forum> request) {
		assert request != null;
		Integer principalId = request.getPrincipal().getActiveRoleId();
		Investor i = this.repository.findInvestorById(principalId);

		Integer forumId = request.getModel().getInteger("id");
		Forum f = this.repository.findOneForumById(forumId);
		Boolean investorApplied = false;

		Collection<Application> cA = f.getInvRound().getApplication();
		for (Application a : cA) {
			if (a.getInvestor().equals(i)) {
				investorApplied = true;
				break;
			}
		}

		return i != null && investorApplied;
	}

	@Override
	public void unbind(final Request<Forum> request, final Forum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creationDate");

	}

	@Override
	public Forum findOne(final Request<Forum> request) {
		assert request != null;

		Forum result;

		String id = request.getServletRequest().getParameter("id");
		result = this.repository.findOneForumById(Integer.parseInt(id));
		return result;
	}

}
