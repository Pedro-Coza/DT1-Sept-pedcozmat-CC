
package acme.features.patron.banner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.banner.Banner;
import acme.entities.roles.Patron;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/patron/banner/")
public class PatronBannerController extends AbstractController<Patron, Banner> {

	@Autowired
	private PatronBannerListService		listService;

	@Autowired
	private PatronBannerShowService		showService;

	@Autowired
	private PatronBannerCreateService	createService;

	@Autowired
	private PatronBannerDeleteService	deleteService;

	@Autowired
	private PatronBannerUpdateService	updateService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
	}

}
