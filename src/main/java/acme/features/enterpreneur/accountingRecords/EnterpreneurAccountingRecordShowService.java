
package acme.features.enterpreneur.accountingRecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.accountingRecord.AccountingRecord;
import acme.entities.roles.Enterpreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class EnterpreneurAccountingRecordShowService implements AbstractShowService<Enterpreneur, AccountingRecord> {

	@Autowired
	private EnterpreneurAccountingRecordRepository repository;


	@Override
	public boolean authorise(final Request<AccountingRecord> request) {
		assert request != null;
		Integer principalId = request.getPrincipal().getActiveRoleId();
		Enterpreneur i = this.repository.findEnterpreneurById(principalId);

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
	public AccountingRecord findOne(final Request<AccountingRecord> request) {
		assert request != null;

		AccountingRecord result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

}
