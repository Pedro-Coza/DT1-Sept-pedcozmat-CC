
package acme.features.investor.activity;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.activity.Activity;
import acme.entities.roles.Investor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InvestorActivityRepository extends AbstractRepository {

	@Query("select a from Activity a where a.workProg.id = ?1")
	Collection<Activity> findManyByWPId(int id);

	@Query("select a from Activity a where a.id = ?1")
	Activity findOneById(int id);

	@Query("select i from Investor i where i.id = ?1")
	Investor findInvestorById(int id);
}
