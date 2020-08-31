
package acme.features.administrator.challenge;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.challenge.Challenge;
import acme.framework.entities.Administrator;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorChallengeRepository extends AbstractRepository {

	@Query("select c from Challenge c")
	Collection<Challenge> findMany();

	@Query("select c from Challenge c where c.id = ?1")
	Challenge findOneById(int id);

	@Query("select c from Challenge c where now()<=c.deadline")
	Collection<Challenge> findManyActive();

	@Query("select a from Administrator a where a.id = ?1")
	Administrator findOneAdministratorById(int id);
}
