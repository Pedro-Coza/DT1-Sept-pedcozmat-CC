
package acme.features.investor.application;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.application.Application;
import acme.entities.investmentRound.InvestmentRound;
import acme.entities.roles.Investor;
import acme.entities.spamlist.Spamlist;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InvestorApplicationRepository extends AbstractRepository {

	@Query("select a from Application a")
	Collection<Application> findMany();

	@Query("select a from Application a where a.id = ?1")
	Application findOneById(int id);

	//	@Query("select i from Application i where now()<=i.deadline")
	//	Collection<Application> findManyActive();

	@Query("select a from Application a where a.invRound.id = ?1")
	Collection<Application> findApplicationsByIVID(int id);

	//@Query("select i.id from InvestmentRound i where i.investor.id = ?1")
	//Collection<Integer> findInvRoundIdbyInvestorId(int id);

	@Query("select a from Application a where a.investor.id = ?1")
	Collection<Application> findManyMine(int id);

	@Query("select i from InvestmentRound i where i.id = ?1")
	InvestmentRound findOneInvestmentRoundById(int id);

	@Query("select i from Investor i where i.id = ?1")
	Investor findOneInvestorById(int id);

	@Query("select s from Spamlist s where s.idiom = ?1")
	Spamlist findSpamLists(String idiom);

	@Query("select i from Investor i where i.id = ?1")
	Investor findInvestorById(int id);
}
