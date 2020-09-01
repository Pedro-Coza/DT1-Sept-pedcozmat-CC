
package acme.features.enterpreneur.application;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.application.Application;
import acme.entities.investmentRound.InvestmentRound;
import acme.entities.roles.Enterpreneur;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EnterpreneurApplicationRepository extends AbstractRepository {

	@Query("select a from Application a")
	Collection<Application> findMany();

	@Query("select a from Application a where a.id = ?1")
	Application findOneById(int id);

	//	@Query("select i from Application i where now()<=i.deadline")
	//	Collection<Application> findManyActive();

	@Query("select a from Application a where a.invRound.id = ?1")
	Collection<Application> findApplicationsByIVID(int id);

	@Query("select i.id from InvestmentRound i where i.enterpreneur.id = ?1")
	Collection<Integer> findInvRoundIdbyEnterpreneurId(int id);

	@Query("select a from Application a where a.invRound.enterpreneur.id = ?1 order by a.ticker asc")
	Collection<Application> findManyByTicker(int activeRoleId);

	@Query("select a from Application a where a.invRound.enterpreneur.id = ?1 order by a.creationDate desc")
	Collection<Application> findManyByCreationDate(int activeRoleId);

	@Query("select e from Enterpreneur e where e.id = ?1")
	Enterpreneur findOneEnterpreneurById(int id);

	@Query("select i from InvestmentRound i where i.enterpreneur.id = ?1")
	Collection<InvestmentRound> findInvRoundByEnterpreneurId(int id);

	@Query("select i from InvestmentRound i where i.id = ?1")
	InvestmentRound findOneInvestmentRoundById(int id);

}
