
package acme.features.investor.forum;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.forum.Forum;
import acme.entities.roles.Investor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class InvestorForumListMineService implements AbstractListService<Investor, Forum> {

	@Autowired
	InvestorForumRepository repository;


	@Override
	public boolean authorise(final Request<Forum> request) {
		assert request != null;
		Integer principalId = request.getPrincipal().getActiveRoleId();
		Investor i = this.repository.findInvestorById(principalId);

		return i != null;
	}

	@Override
	public void unbind(final Request<Forum> request, final Forum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creationDate");
	}

	@Override
	public Collection<Forum> findMany(final Request<Forum> request) {
		assert request != null;

		Integer id = request.getPrincipal().getAccountId();

		Collection<Forum> result = this.repository.findManyForumByUserId(id);

		return result;
	}
}
