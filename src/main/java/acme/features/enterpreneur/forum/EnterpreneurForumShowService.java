
package acme.features.enterpreneur.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.forum.Forum;
import acme.entities.roles.Enterpreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class EnterpreneurForumShowService implements AbstractShowService<Enterpreneur, Forum> {

	@Autowired
	private EnterpreneurForumRepository repository;


	@Override
	public boolean authorise(final Request<Forum> request) {
		assert request != null;
		Integer principalId = request.getPrincipal().getActiveRoleId();
		Enterpreneur e = this.repository.findEnterpreneurById(principalId);

		Integer forumId = request.getModel().getInteger("id");
		Forum f = this.repository.findOneForumById(forumId);

		return e != null && f.getAdministrator().equals(e.getUserAccount());
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
