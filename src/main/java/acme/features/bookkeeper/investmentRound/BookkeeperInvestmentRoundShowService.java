
package acme.features.bookkeeper.investmentRound;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investmentRound.InvestmentRound;
import acme.entities.roles.Bookkeeper;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class BookkeeperInvestmentRoundShowService implements AbstractShowService<Bookkeeper, InvestmentRound> {

	@Autowired
	private BookkeeperInvestmentRoundRepository repository;


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

		request.unbind(entity, model, "ticker", "creationDate", "kindRound", "title", "money", "info");

		Integer appsCount = this.repository.countAppsByIVId(entity.getId());

		Integer roleId = request.getPrincipal().getAccountId();

		Integer invId = this.repository.getInvestorIdByUAId(roleId);

		Boolean creator = roleId.equals(entity.getEnterpreneur().getUserAccount().getId());

		Collection<Integer> invIds = this.repository.getInvestorsIds(entity.getId());
		Boolean applicator = invIds.contains(invId);

		Boolean involved = creator || applicator;

		model.setAttribute("workProgId", entity.getWorkProg().getId());
		model.setAttribute("appsCount", appsCount);
		model.setAttribute("invRoundId", entity.getId());
		model.setAttribute("involved", involved);

	}

	@Override
	public InvestmentRound findOne(final Request<InvestmentRound> request) {
		assert request != null;

		InvestmentRound result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

}
