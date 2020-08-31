
package acme.features.investor.accountingRecords;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.accountingRecord.AccountingRecord;
import acme.entities.roles.Investor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class InvestorAccountingRecordListService implements AbstractListService<Investor, AccountingRecord> {

	@Autowired
	InvestorAccountingRecordRepository repository;


	@Override
	public boolean authorise(final Request<AccountingRecord> request) {
		assert request != null;
		Integer principalId = request.getPrincipal().getActiveRoleId();
		Investor i = this.repository.findInvestorById(principalId);

		return i != null;
	}

	@Override
	public void unbind(final Request<AccountingRecord> request, final AccountingRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "status", "creationMoment", "body");
	}

	@Override
	public Collection<AccountingRecord> findMany(final Request<AccountingRecord> request) {
		assert request != null;

		Collection<AccountingRecord> result;
		Integer iRId = Integer.parseInt(request.getServletRequest().getParameter("id"));

		result = this.repository.findManyByInvRoundId(iRId);

		return result;
	}
}
