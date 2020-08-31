
package acme.features.administrator.dashboard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.dashboard.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	@Autowired
	AdministratorDashboardRepository repository;


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;

		Integer id = request.getPrincipal().getActiveRoleId();
		Administrator a = this.repository.findOneAdministratorById(id);

		return a != null;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		Double totalNotice = this.repository.getTotalNotice();
		Double totalTechRec = this.repository.getTotalTechRecords();
		Double totalToolRec = this.repository.getTotalToolRecords();

		Double minInq = this.repository.getMinInq();
		Double maxInq = this.repository.getMaxInq();

		Double minOvt = this.repository.getMinOvt();
		Double maxOvt = this.repository.getMaxOvt();

		Collection<Double> minValInq = this.repository.getMinValuesInq();
		Collection<Double> maxValInq = this.repository.getMaxValuesInq();
		Collection<Double> minValOvt = this.repository.getMinValuesOvt();
		Collection<Double> maxValOvt = this.repository.getMaxValuesOvt();

		Double avgInq = this.getAvgInterval(minValInq, maxValInq);
		Double avgOvt = this.getAvgInterval(minValOvt, maxValOvt);
		Double stdDevInq = this.getStdDevInterval(minValInq, maxValInq);
		Double stdDevOvt = this.getStdDevInterval(minValOvt, maxValOvt);

		Double techCountOS = this.repository.getTechCountOS();
		Double techCountCS = this.repository.getTechCountCS();
		Double toolCountOS = this.repository.getToolCountOS();
		Double toolCountCS = this.repository.getToolCountCS();

		Double avgInvXEnt = this.repository.getInvRoundCount() / this.repository.getEnterpreneurCount();
		Double avgAppXEnt = this.repository.getAppCount() / this.repository.getEnterpreneurCount();
		Double avgAppXInv = this.repository.getAppCount() / this.repository.getInvestorCount();

		request.unbind(entity, model, "labels", "numTech", "numTool");

		model.setAttribute("totalNotice", totalNotice);
		model.setAttribute("totalTechRec", totalTechRec);
		model.setAttribute("totalToolRec", totalToolRec);

		model.setAttribute("minInq", minInq);
		model.setAttribute("maxInq", maxInq);
		model.setAttribute("minOvt", minOvt);
		model.setAttribute("maxOvt", maxOvt);
		model.setAttribute("avgInq", avgInq);
		model.setAttribute("avgOvt", avgOvt);
		model.setAttribute("stdDevInq", stdDevInq);
		model.setAttribute("stdDevOvt", stdDevOvt);

		model.setAttribute("techCountOS", techCountOS);
		model.setAttribute("techCountCS", techCountCS);
		model.setAttribute("toolCountOS", toolCountOS);
		model.setAttribute("toolCountCS", toolCountCS);

		model.setAttribute("countTechAS1", this.repository.getTechCountAS1());
		model.setAttribute("countTechAS2", this.repository.getTechCountAS2());
		model.setAttribute("countTechAS3", this.repository.getTechCountAS3());
		model.setAttribute("countTechAS4", this.repository.getTechCountAS4());
		model.setAttribute("countTechAS5", this.repository.getTechCountAS5());

		model.setAttribute("countToolAS1", this.repository.getToolCountAS1());
		model.setAttribute("countToolAS2", this.repository.getToolCountAS2());
		model.setAttribute("countToolAS3", this.repository.getToolCountAS3());
		model.setAttribute("countToolAS4", this.repository.getToolCountAS4());
		model.setAttribute("countToolAS5", this.repository.getToolCountAS5());

		model.setAttribute("avgInvRoundXEnterpreneur", avgInvXEnt);
		model.setAttribute("avgAppsXEnterpreneur", avgAppXEnt);
		model.setAttribute("avgInvRoundXInvestor", avgAppXInv);

		model.setAttribute("iRKindSeed", this.repository.getIRCountSeed());
		model.setAttribute("iRKindAngel", this.repository.getIRCountAngel());
		model.setAttribute("iRKindSeriesA", this.repository.getIRCountSeriesA());
		model.setAttribute("iRKindSeriesB", this.repository.getIRCountSeriesB());
		model.setAttribute("iRKindSeriesC", this.repository.getIRCountSeriesC());
		model.setAttribute("iRKindBridge", this.repository.getIRCountBridge());

		model.setAttribute("acceptedApps", this.repository.getAppCountAccepted());
		model.setAttribute("rejectedApps", this.repository.getAppCountRejected());

	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		Dashboard result = new Dashboard();

		return result;
	}

	private Double getAvgInterval(final Collection<Double> minValues, final Collection<Double> maxValues) {

		Double sumUp = 0.0;
		if (minValues.size() == maxValues.size()) {
			for (Double d : minValues) {
				for (Double d2 : maxValues) {
					sumUp += d;
					sumUp += d2;
				}
			}
		}
		return sumUp / minValues.size();
	}

	public Double getStdDevInterval(final Collection<Double> minValues, final Collection<Double> maxValues) {

		Double avg = this.getAvgInterval(minValues, maxValues);
		Double distancesSum = 0.0;
		if (minValues.size() == maxValues.size()) {
			List<Double> distances = new ArrayList<Double>();
			for (Double d : minValues) {
				for (Double d2 : maxValues) {
					Double aux1 = (d - avg) * (d - avg);
					Double aux2 = (d2 - avg) * (d2 - avg);
					distances.add(aux1);
					distances.add(aux2);
				}
			}

			for (Double d : distances) {
				distancesSum += d;
			}
		}

		return Math.sqrt(distancesSum / minValues.size());
	}

}
