
package acme.features.administrator.notice;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.notice.Notice;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorNoticeCreateService implements AbstractCreateService<Administrator, Notice> {

	@Autowired
	AdministratorNoticeRepository repository;


	@Override
	public boolean authorise(final Request<Notice> request) {
		assert request != null;
		Integer id = request.getPrincipal().getActiveRoleId();

		Administrator a = this.repository.findOneAdministratorById(id);

		return a != null;
	}

	@Override
	public void bind(final Request<Notice> request, final Notice entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creationDate");
	}

	@Override
	public void unbind(final Request<Notice> request, final Notice entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "header", "title", "deadline", "body", "relatedLinks");
		if (request.isMethod(HttpMethod.GET)) {
			model.setAttribute("accept", false);
		} else {
			request.transfer(model, "accept");
		}
	}

	@Override
	public Notice instantiate(final Request<Notice> request) {
		assert request != null;
		Notice result;
		Date moment = new Date(System.currentTimeMillis() - 1);

		result = new Notice();
		result.setCreationDate(moment);

		return result;
	}

	@Override
	public void validate(final Request<Notice> request, final Notice entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Boolean isAccepted;
		Calendar calendar;
		Date minimumDeadLine;

		if (!errors.hasErrors("deadline")) {
			calendar = new GregorianCalendar();
			calendar.add(Calendar.DAY_OF_MONTH, 7);
			minimumDeadLine = calendar.getTime();
			if (entity.getDeadline() == null) {
				errors.state(request, true, "deadline", "javax.validation.constraints.NotBlank.message");
			} else if (entity.getDeadline() != null) {
				errors.state(request, entity.getDeadline().after(minimumDeadLine), "deadline", "acme.validation.deadline");
			}
		}

		isAccepted = request.getModel().getBoolean("accept");
		errors.state(request, isAccepted, "accept", "acme.validation.accept");
	}

	@Override
	public void create(final Request<Notice> request, final Notice entity) {
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setCreationDate(moment);
		this.repository.save(entity);
	}

}
