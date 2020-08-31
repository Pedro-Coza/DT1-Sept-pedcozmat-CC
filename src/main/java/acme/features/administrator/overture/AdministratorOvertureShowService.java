
package acme.features.administrator.overture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.overture.Overture;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorOvertureShowService implements AbstractShowService<Administrator, Overture> {

	@Autowired
	private AdministratorOvertureRepository repository;


	@Override
	public boolean authorise(final Request<Overture> request) {
		assert request != null;
		Integer id = request.getPrincipal().getActiveRoleId();

		Administrator a = this.repository.findOneAdministratorById(id);

		return a != null;
	}

	@Override
	public void unbind(final Request<Overture> request, final Overture entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creationDate", "deadline", "description", "mmin", "mmax", "email");

	}

	@Override
	public Overture findOne(final Request<Overture> request) {
		assert request != null;

		Overture result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

}
