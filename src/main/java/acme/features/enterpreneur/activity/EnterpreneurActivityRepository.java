
package acme.features.enterpreneur.activity;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.activity.Activity;
import acme.entities.investmentRound.InvestmentRound;
import acme.entities.roles.Enterpreneur;
import acme.entities.spamlist.Spamlist;
import acme.entities.workProgramme.WorkProgramme;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EnterpreneurActivityRepository extends AbstractRepository {

	@Query("select a from Activity a where a.workProg.id = ?1")
	Collection<Activity> findManyByWPId(int id);

	@Query("select a from Activity a where a.id = ?1")
	Activity findOneById(int id);

	@Query("select s from Spamlist s where s.idiom = ?1")
	Spamlist findSpamLists(String idiom);

	@Query("select e from Enterpreneur e where e.id = ?1")
	Enterpreneur findOneEnterpreneurById(int id);

	@Query("select wp from WorkProgramme wp where wp.id = ?1")
	WorkProgramme findOneWorkProgrammeById(int id);

	@Query("select i from InvestmentRound i where i.id = ?1")
	InvestmentRound findOneIRById(int id);

	//	@Query("select i from InvestmentRound i join i.workProg w where w.id = ?1")
	//	InvestmentRound findOneIRByWPId(int id);

	//	@Query("select i from Activity i where now()<=i.deadline")
	//	Collection<Activity> findManyActive();
}
