
package acme.features.enterpreneur.activity;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.activity.Activity;
import acme.entities.roles.Enterpreneur;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("enterpreneur/activity/")
public class EnterpreneurActivityController extends AbstractController<Enterpreneur, Activity> {

	@Autowired
	private EnterpreneurActivityListService		listService;

	@Autowired
	private EnterpreneurActivityShowService		showService;

	@Autowired
	private EnterpreneurActivityCreateService	createService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
