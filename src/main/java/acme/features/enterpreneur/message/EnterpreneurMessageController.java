
package acme.features.enterpreneur.message;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.message.Message;
import acme.entities.roles.Enterpreneur;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/enterpreneur/message/")
public class EnterpreneurMessageController extends AbstractController<Enterpreneur, Message> {

	@Autowired
	private EnterpreneurMessageListService	listService;

	@Autowired
	private EnterpreneurMessageShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
