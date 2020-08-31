
package acme.features.enterpreneur.investmentRound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investmentRound.InvestmentRound;
import acme.entities.roles.Enterpreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class EnterpreneurInvestmentRoundShowService implements AbstractShowService<Enterpreneur, InvestmentRound> {

	@Autowired
	private EnterpreneurInvestmentRoundRepository repository;


	@Override
	public boolean authorise(final Request<InvestmentRound> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<InvestmentRound> request, final InvestmentRound entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "creationDate", "kindRound", "title", "money", "info", "active");

		Integer appsCount = this.repository.countAppsByIRId(entity.getId());

		model.setAttribute("workProgId", entity.getWorkProg().getId());
		model.setAttribute("appsCount", appsCount);
		model.setAttribute("invRoundId", entity.getId());
		model.setAttribute("active", entity.getActive());
		model.setAttribute("forumId", entity.getForum().getId());
	}

	@Override
	public InvestmentRound findOne(final Request<InvestmentRound> request) {
		assert request != null;

		InvestmentRound result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneInvestmentRoundById(id);
		return result;
	}

}
