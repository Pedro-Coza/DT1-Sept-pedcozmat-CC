
package acme.features.enterpreneur.application;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.application.Application;
import acme.entities.roles.Enterpreneur;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("enterpreneur/application/")
public class EnterpreneurApplicationController extends AbstractController<Enterpreneur, Application> {

	@Autowired
	private EnterpreneurApplicationListService					listService;

	@Autowired
	private EnterpreneurApplicationShowService					showService;

	@Autowired
	private EnterpreneurApplicationUpdateService				updateService;

	@Autowired
	private EnterpreneurApplicationListMineService				listMineService;

	@Autowired
	private EnterpreneurApplicationListByCreationDateService	listByDateService;

	@Autowired
	private EnterpreneurApplicationListByTickerService			listByTickerService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineService);
		super.addCustomCommand(CustomCommand.LIST_DATE, BasicCommand.LIST, this.listByDateService);
		super.addCustomCommand(CustomCommand.LIST_TICKER, BasicCommand.LIST, this.listByTickerService);
	}

}
