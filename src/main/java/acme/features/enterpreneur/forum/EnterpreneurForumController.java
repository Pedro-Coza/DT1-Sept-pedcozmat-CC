
package acme.features.enterpreneur.forum;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.forum.Forum;
import acme.entities.roles.Enterpreneur;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("enterpreneur/forum/")
public class EnterpreneurForumController extends AbstractController<Enterpreneur, Forum> {

	@Autowired
	private EnterpreneurForumListMineService	listService;

	@Autowired
	private EnterpreneurForumShowService		showService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
