
package acme.features.authenticated.enterpreneur;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.roles.Enterpreneur;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/enterpreneur/")
public class AuthenticatedEnterpreneurController extends AbstractController<Authenticated, Enterpreneur> {

	@Autowired
	private AuthenticatedEnterpreneurCreateService createService;


	// Constructors--------------------------------------

	@PostConstruct
	private void intialise() {
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
