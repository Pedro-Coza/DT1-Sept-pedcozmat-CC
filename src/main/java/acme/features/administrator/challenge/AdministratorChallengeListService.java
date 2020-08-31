
package acme.features.administrator.challenge;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenge.Challenge;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorChallengeListService implements AbstractListService<Administrator, Challenge> {

	@Autowired
	AdministratorChallengeRepository repository;


	@Override
	public boolean authorise(final Request<Challenge> request) {
		assert request != null;
		Integer id = request.getPrincipal().getActiveRoleId();

		Administrator a = this.repository.findOneAdministratorById(id);

		return a != null;
	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "expert", "average", "rookie", "expertReward", "averageReward", "rookieReward");
	}

	@Override
	public Collection<Challenge> findMany(final Request<Challenge> request) {
		assert request != null;

		Collection<Challenge> result;

		result = this.repository.findManyActive();

		return result;
	}
}
