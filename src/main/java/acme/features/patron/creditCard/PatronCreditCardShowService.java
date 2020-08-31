
package acme.features.patron.creditCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banner.Banner;
import acme.entities.creditCard.CreditCard;
import acme.entities.roles.Patron;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class PatronCreditCardShowService implements AbstractShowService<Patron, CreditCard> {

	@Autowired
	PatronCreditCardRepository repository;


	@Override
	public boolean authorise(final Request<CreditCard> request) {
		assert request != null;

		Integer principalId = request.getPrincipal().getActiveRoleId();
		Integer cardId = Integer.parseInt(request.getServletRequest().getParameter("id"));
		CreditCard cCard = this.repository.findOneCardById(cardId);

		Patron p = this.repository.findPatronById(principalId);
		Banner b = cCard.getBanner();

		return b.getPatron().equals(p);
	}

	@Override
	public void unbind(final Request<CreditCard> request, final CreditCard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "holderName", "number", "number", "expirationDate", "cvv");
	}

	@Override
	public CreditCard findOne(final Request<CreditCard> request) {
		assert request != null;

		CreditCard result;
		String id;

		id = request.getServletRequest().getParameter("id");
		result = this.repository.findOneCardById(Integer.parseInt(id));

		return result;
	}

}
