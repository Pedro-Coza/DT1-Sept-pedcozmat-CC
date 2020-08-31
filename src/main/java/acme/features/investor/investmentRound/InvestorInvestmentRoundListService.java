
package acme.features.investor.investmentRound;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investmentRound.InvestmentRound;
import acme.entities.roles.Investor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class InvestorInvestmentRoundListService implements AbstractListService<Investor, InvestmentRound> {

	@Autowired
	InvestorInvestmentRoundRepository repository;


	@Override
	public boolean authorise(final Request<InvestmentRound> request) {
		assert request != null;
		Integer principalId = request.getPrincipal().getActiveRoleId();
		Investor i = this.repository.findInvestorById(principalId);

		return i != null;
	}

	@Override
	public void unbind(final Request<InvestmentRound> request, final InvestmentRound entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "kindRound", "title", "money", "info");
	}

	@Override
	public Collection<InvestmentRound> findMany(final Request<InvestmentRound> request) {
		assert request != null;

		Collection<InvestmentRound> result;

		result = this.repository.findManyActive();

		return result;
	}
}
