
package acme.features.enterpreneur.forum;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.forum.Forum;
import acme.entities.roles.Enterpreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class EnterpreneurForumListMineService implements AbstractListService<Enterpreneur, Forum> {

	@Autowired
	EnterpreneurForumRepository repository;


	@Override
	public boolean authorise(final Request<Forum> request) {
		assert request != null;
		Integer principalId = request.getPrincipal().getActiveRoleId();
		Enterpreneur e = this.repository.findEnterpreneurById(principalId);

		return e != null;
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
