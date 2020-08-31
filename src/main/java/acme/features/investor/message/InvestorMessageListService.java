
package acme.features.investor.message;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.forum.Forum;
import acme.entities.forum.ForumAuthenticated;
import acme.entities.message.Message;
import acme.entities.roles.Investor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class InvestorMessageListService implements AbstractListService<Investor, Message> {

	@Autowired
	InvestorMessageRepository repository;


	@Override
	public boolean authorise(final Request<Message> request) {
		assert request != null;
		Boolean res = false;
		Integer forumId = Integer.parseInt(request.getServletRequest().getParameter("id"));
		Forum f = this.repository.findOneForumById(forumId);
		ForumAuthenticated fa = this.repository.findAuthentication(request.getPrincipal().getAccountId(), f.getId());

		if (fa != null) {
			res = true;
		}

		return res;
	}

	@Override
	public void unbind(final Request<Message> request, final Message entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creationMoment", "tags", "body");
		model.setAttribute("fId", request.getServletRequest().getParameter("id"));
	}

	@Override
	public Collection<Message> findMany(final Request<Message> request) {
		assert request != null;

		Collection<Message> result;

		result = this.repository.findManyMessagesByForumId(Integer.parseInt(request.getServletRequest().getParameter("id")));

		return result;
	}

}
