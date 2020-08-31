
package acme.features.patron.banner;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banner.Banner;
import acme.entities.roles.Patron;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class PatronBannerListService implements AbstractListService<Patron, Banner> {

	@Autowired
	PatronBannerRepository repository;


	@Override
	public boolean authorise(final Request<Banner> request) {
		assert request != null;
		//Comprueba que el principal es un patron y por tanto puede listar
		Integer principalId = request.getPrincipal().getActiveRoleId();
		Patron p = this.repository.findPatronById(principalId);

		return p != null;
	}

	@Override
	public void unbind(final Request<Banner> request, final Banner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "targetUrl", "creditCard");
	}

	@Override
	public Collection<Banner> findMany(final Request<Banner> request) {
		assert request != null;
		Collection<Banner> nonBannerBannerList;

		nonBannerBannerList = this.repository.findManyMine(request.getPrincipal().getActiveRoleId());

		return nonBannerBannerList;
	}

}
