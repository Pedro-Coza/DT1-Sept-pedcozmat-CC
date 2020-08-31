
package acme.features.enterpreneur.investmentRound;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.investmentRound.InvestmentRound;
import acme.entities.roles.Enterpreneur;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("enterpreneur/investment-round/")
public class EnterpreneurInvestmentRoundController extends AbstractController<Enterpreneur, InvestmentRound> {

	@Autowired
	private EnterpreneurInvestmentRoundListMineService	listMineService;

	@Autowired
	private EnterpreneurInvestmentRoundShowService		showService;

	@Autowired
	private EnterpreneurInvestmentRoundCreateService	createService;

	@Autowired
	private EnterpreneurInvestmentRoundUpdateService	updateService;

	@Autowired
	private EnterpreneurInvestmentRoundDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listMineService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
	}

}
