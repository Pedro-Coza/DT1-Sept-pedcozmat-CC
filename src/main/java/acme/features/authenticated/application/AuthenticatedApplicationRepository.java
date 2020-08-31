
package acme.features.authenticated.application;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.application.Application;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedApplicationRepository extends AbstractRepository {

	@Query("select a from Application a")
	Collection<Application> findMany();

	@Query("select a from Application a where a.id = ?1")
	Application findOneById(int id);

	//	@Query("select i from Application i where now()<=i.deadline")
	//	Collection<Application> findManyActive();

	@Query("select a from Application a where a.invRound.id = ?1 and a.status != 'PENDING'")
	Collection<Application> findApplicationsByIVID(int id);
}
