
package acme.features.enterpreneur.accountingRecords;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.accountingRecord.AccountingRecord;
import acme.entities.roles.Enterpreneur;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("enterpreneur/accounting-record/")
public class EnterpreneurAccountingRecordController extends AbstractController<Enterpreneur, AccountingRecord> {

	@Autowired
	private EnterpreneurAccountingRecordListService	listService;

	@Autowired
	private EnterpreneurAccountingRecordShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
