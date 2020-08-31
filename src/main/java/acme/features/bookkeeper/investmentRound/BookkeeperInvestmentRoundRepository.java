
package acme.features.bookkeeper.investmentRound;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investmentRound.InvestmentRound;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface BookkeeperInvestmentRoundRepository extends AbstractRepository {

	@Query("select i from InvestmentRound i")
	Collection<InvestmentRound> findMany();

	@Query("select i from InvestmentRound i where i.id = ?1")
	InvestmentRound findOneById(int id);

	@Query("select i from InvestmentRound i where i.active = ACTIVE")
	Collection<InvestmentRound> findManyActive();

	@Query("select count(a) from Application a where a.invRound.id = ?1")
	Integer countAppsByIVId(int id);

	@Query("select distinct a.investor.id from Application a where a.invRound.id = ?1")
	Collection<Integer> getInvestorsIds(int id);

	@Query("select i.id from Investor i where i.userAccount.id = ?1")
	Integer getInvestorIdByUAId(int id);

	@Query("select a.invRound.id from AccountingRecord a where a.bookkeeper.id = ?1")
	Collection<Integer> findManyByBookKId(int id);

	@Query("select i.id from InvestmentRound i")
	Collection<Integer> getInvRoundIds();
}
