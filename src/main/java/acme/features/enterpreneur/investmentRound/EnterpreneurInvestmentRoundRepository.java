
package acme.features.enterpreneur.investmentRound;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.activity.Activity;
import acme.entities.application.Application;
import acme.entities.investmentRound.InvestmentRound;
import acme.entities.roles.Enterpreneur;
import acme.entities.spamlist.Spamlist;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EnterpreneurInvestmentRoundRepository extends AbstractRepository {

	@Query("select i from InvestmentRound i")
	Collection<InvestmentRound> findMany();

	@Query("select i from InvestmentRound i where i.id = ?1")
	InvestmentRound findOneInvestmentRoundById(int id);

	@Query("select i from InvestmentRound i where i.active = ACTIVE")
	Collection<InvestmentRound> findManyActive();

	@Query("select count(a) from Application a where a.invRound.id = ?1")
	Integer countAppsByIRId(int id);

	@Query("select i from InvestmentRound i where i.enterpreneur.id = ?1")
	Collection<InvestmentRound> findManyByEnterpreneurId(int id);

	@Query("select e from Enterpreneur e where e.id = ?1")
	Enterpreneur findOneEnterpreneurById(int id);

	@Query("select i.enterpreneur.id from InvestmentRound i where i.id = ?1")
	Integer getEnterpIdByIRId(int id);

	@Query("select s from Spamlist s where s.idiom = ?1")
	Spamlist findSpamLists(String idiom);

	@Query("select a from Application a where a.invRound.id = ?1")
	Collection<Application> findManyApplicationsByIRId(int id);

	@Query("select a from Activity a where a.workProg.id = ?1")
	Collection<Activity> findActivitiesByWPId(int id);

	@Transactional
	@Modifying
	@Query("delete from Message m where m.forum.id = ?1")
	void deleteMessageByForumId(int id);

	@Transactional
	@Modifying
	@Query("delete from Forum f where id = ?1")
	void deleteForum(int id);

	@Transactional
	@Modifying
	@Query("delete from Activity a where a.workProg.id = ?1")
	void deleteActivitiesByWPId(int id);

	@Transactional
	@Modifying
	@Query("delete from WorkProgramme w where id = ?1")
	void deleteWorkProgramme(int id);

	@Transactional
	@Modifying
	@Query("delete from AccountingRecord a where a.invRound.id = ?1")
	void deleteAccountingRecord(int id);

	@Transactional
	@Modifying
	@Query("delete from ForumAuthenticated fA where fA.forum.id = ?1")
	void deleteForumAuthenticated(int id);

	@Transactional
	@Modifying
	@Query("delete from InvestmentRound i where i.id = ?1")
	void deleteIR(int id);

}
