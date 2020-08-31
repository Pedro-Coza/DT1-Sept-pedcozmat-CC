
package acme.features.patron.banner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banner.Banner;
import acme.entities.roles.Patron;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class PatronBannerShowService implements AbstractShowService<Patron, Banner> {

	@Autowired
	PatronBannerRepository repository;


	@Override
	public boolean authorise(final Request<Banner> request) {
		assert request != null;
		//Comprueba que el principal es un patron y es propietario del banner a mostrar
		Integer principalId = request.getPrincipal().getActiveRoleId();
		Patron p = this.repository.findPatronById(principalId);

		Integer bannerId = request.getModel().getInteger("id");

		Banner b = this.repository.findOneById(bannerId);

		return b.getPatron().equals(p);
	}

	@Override
	public void unbind(final Request<Banner> request, final Banner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "targetUrl", "creditCard");

		if (entity.getCreditCard() != null) {
			model.setAttribute("cardId", entity.getCreditCard().getId());
		}
	}

	@Override
	public Banner findOne(final Request<Banner> request) {
		assert request != null;

		Banner result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
