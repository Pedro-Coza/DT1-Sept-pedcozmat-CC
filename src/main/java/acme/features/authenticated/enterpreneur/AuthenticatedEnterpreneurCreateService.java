
package acme.features.authenticated.enterpreneur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Enterpreneur;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.entities.UserAccount;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedEnterpreneurCreateService implements AbstractCreateService<Authenticated, Enterpreneur> {

	@Autowired
	AuthenticatedEnterpreneurRepository repository;


	@Override
	public boolean authorise(final Request<Enterpreneur> request) {
		assert request != null;

		int userId = request.getPrincipal().getAccountId();

		UserAccount ua = this.repository.findOneUserAccountById(userId);
		Enterpreneur e = this.repository.findOneEnterpreneurByUserId(ua.getId());
		// int employerId = e.getId();

		return e == null;
	}

	@Override
	public void bind(final Request<Enterpreneur> request, final Enterpreneur entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Enterpreneur> request, final Enterpreneur entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "startupName", "activitySector", "qualifRecord", "skillRecord");

	}

	@Override
	public Enterpreneur instantiate(final Request<Enterpreneur> request) {
		assert request != null;

		Enterpreneur result;
		Principal principal;
		UserAccount userAccount;
		Integer userAccountId;

		principal = request.getPrincipal();
		userAccountId = principal.getAccountId();
		userAccount = this.repository.findOneUserAccountById(userAccountId);

		result = new Enterpreneur();
		result.setUserAccount(userAccount);

		return result;
	}

	@Override
	public void validate(final Request<Enterpreneur> request, final Enterpreneur entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<Enterpreneur> request, final Enterpreneur entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

	@Override
	public void onSuccess(final Request<Enterpreneur> request, final Response<Enterpreneur> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}
	}

}
