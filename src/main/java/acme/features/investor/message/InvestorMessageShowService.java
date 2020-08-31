
package acme.features.investor.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.forum.ForumAuthenticated;
import acme.entities.message.Message;
import acme.entities.roles.Investor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class InvestorMessageShowService implements AbstractShowService<Investor, Message> {

	@Autowired
	InvestorMessageRepository repository;


	@Override
	public boolean authorise(final Request<Message> request) {
		assert request != null;

		Integer principalId = request.getPrincipal().getAccountId();
		Integer messageId = request.getModel().getInteger("id");

		Message m = this.repository.findOneMessageById(messageId);

		ForumAuthenticated fA = this.repository.findAuthentication(principalId, m.getForum().getId());

		return fA != null;
	}

	@Override
	public void unbind(final Request<Message> request, final Message entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creationMoment", "tags", "body");

	}

	@Override
	public Message findOne(final Request<Message> request) {
		assert request != null;

		Message result;

		String id = request.getServletRequest().getParameter("id");
		result = this.repository.findOneMessageById(Integer.parseInt(id));

		return result;
	}

}
