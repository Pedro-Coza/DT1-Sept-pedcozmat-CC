
package acme.features.administrator.dashboard;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.entities.Administrator;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select a from Administrator a where a.id = ?1")
	Administrator findOneAdministratorById(int id);

	@Query("select count(x) from Notice x")
	Double getTotalNotice();

	@Query("select count(x) from TechnologyRecord x")
	Double getTotalTechRecords();

	@Query("select count(x) from ToolRecord x")
	Double getTotalToolRecords();

	@Query("select mmin.amount from Inquiry x where now()<=x.deadline")
	Collection<Double> getMinValuesInq();

	@Query("select mmax.amount from Inquiry x where now()<=x.deadline")
	Collection<Double> getMaxValuesInq();

	@Query("select mmin.amount from Overture x where now()<=x.deadline")
	Collection<Double> getMinValuesOvt();

	@Query("select mmax.amount from Overture x where now()<=x.deadline")
	Collection<Double> getMaxValuesOvt();

	@Query("select min(mmin.amount) from Inquiry x where now()<=x.deadline")
	Double getMinInq();

	@Query("select max(mmax.amount) from Inquiry a where now()<=a.deadline")
	Double getMaxInq();

	@Query("select min(mmin.amount) from Overture a where now()<=a.deadline")
	Double getMinOvt();

	@Query("select max(mmax.amount) from Overture a where now()<=a.deadline")
	Double getMaxOvt();

	@Query("select count(x) from TechnologyRecord x where x.source = 'open-source'")
	Double getTechCountOS();

	@Query("select count(x) from TechnologyRecord x where x.source = 'closed-source'")
	Double getTechCountCS();

	@Query("select count(x) from ToolRecord x where x.source = 'open-source'")
	Double getToolCountOS();

	@Query("select count(x) from ToolRecord x where x.source = 'closed-source'")
	Double getToolCountCS();

	@Query("select x.activitySector, count(x) from TechnologyRecord x group by x.activitySector")
	Collection<Object[]> findAllTechGBSector();

	@Query("select x.activitySector, count(x) from ToolRecord x group by x.activitySector")
	Collection<Object[]> findAllToolGBSector();

	@Query("select count(x) from TechnologyRecord x where x.activitySector = 'Technology'")
	Double getTechCountAS1();

	@Query("select count(x) from TechnologyRecord x where x.activitySector = 'Science'")
	Double getTechCountAS2();

	@Query("select count(x) from TechnologyRecord x where x.activitySector = 'Arts'")
	Double getTechCountAS3();

	@Query("select count(x) from TechnologyRecord x where x.activitySector = 'Business'")
	Double getTechCountAS4();

	@Query("select count(x) from TechnologyRecord x where x.activitySector = 'Health'")
	Double getTechCountAS5();

	@Query("select count(x) from ToolRecord x where x.activitySector = 'Technology'")
	Double getToolCountAS1();

	@Query("select count(x) from ToolRecord x where x.activitySector = 'Science'")
	Double getToolCountAS2();

	@Query("select count(x) from ToolRecord x where x.activitySector = 'Arts'")
	Double getToolCountAS3();

	@Query("select count(x) from ToolRecord x where x.activitySector = 'Business'")
	Double getToolCountAS4();

	@Query("select count(x) from ToolRecord x where x.activitySector = 'Health'")
	Double getToolCountAS5();

	@Query("select count(e) from Enterpreneur e")
	Double getEnterpreneurCount();

	@Query("select count(i) from InvestmentRound i")
	Double getInvRoundCount();

	@Query("select count(a) from Application a")
	Double getAppCount();

	@Query("select count(i) from Investor i")
	Double getInvestorCount();

	@Query("select count(x) from InvestmentRound x where x.kindRound = 'SEED'")
	Double getIRCountSeed();

	@Query("select count(x) from InvestmentRound x where x.kindRound = 'ANGEL'")
	Double getIRCountAngel();

	@Query("select count(x) from InvestmentRound x where x.kindRound = 'SERIES-A'")
	Double getIRCountSeriesA();

	@Query("select count(x) from InvestmentRound x where x.kindRound = 'SERIES-B'")
	Double getIRCountSeriesB();

	@Query("select count(x) from InvestmentRound x where x.kindRound = 'SERIES-C'")
	Double getIRCountSeriesC();

	@Query("select count(x) from InvestmentRound x where x.kindRound = 'BRIDGE'")
	Double getIRCountBridge();

	@Query("select count(x) from Application x where x.status = 1")
	Double getAppCountAccepted();

	@Query("select count(x) from Application x where x.status = 2")
	Double getAppCountRejected();
}
