
package acme.features.authenticated.investor;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.roles.Investor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/investor/")
public class AuthenticatedInvestorController extends AbstractController<Authenticated, Investor> {

	@Autowired
	private AuthenticatedInvestorCreateService createService;


	// Constructors--------------------------------------

	@PostConstruct
	private void intialise() {
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
