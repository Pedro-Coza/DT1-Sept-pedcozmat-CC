
package acme.features.authenticated.activity;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.activity.Activity;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedActivityRepository extends AbstractRepository {

	@Query("select a from Activity a where a.workProg.id = ?1")
	Collection<Activity> findManyByWPId(int id);

	@Query("select a from Activity a where a.id = ?1")
	Activity findOneById(int id);

	//	@Query("select i from Activity i where now()<=i.deadline")
	//	Collection<Activity> findManyActive();
}
