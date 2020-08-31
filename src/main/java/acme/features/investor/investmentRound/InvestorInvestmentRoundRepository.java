
package acme.features.investor.investmentRound;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investmentRound.InvestmentRound;
import acme.entities.roles.Investor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InvestorInvestmentRoundRepository extends AbstractRepository {

	@Query("select i from InvestmentRound i")
	Collection<InvestmentRound> findMany();

	@Query("select i from InvestmentRound i where i.id = ?1")
	InvestmentRound findOneById(int id);

	@Query("select i from InvestmentRound i where i.active = 'ACTIVE'")
	Collection<InvestmentRound> findManyActive();

	@Query("select count(a) from Application a where a.invRound.id = ?1")
	Integer countAppsByIVId(int id);

	@Query("select distinct a.investor.id from Application a where a.invRound.id = ?1")
	Collection<Integer> getInvestorsIds(int id);

	@Query("select i.id from Investor i where i.userAccount.id = ?1")
	Integer getInvestorIdByUAId(int id);

	@Query("select i from Investor i where i.id = ?1")
	Investor findInvestorById(int id);
}
