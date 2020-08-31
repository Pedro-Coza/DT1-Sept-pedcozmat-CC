
package acme.features.administrator.inquiry;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.inquiry.Inquiry;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorInquiryCreateService implements AbstractCreateService<Administrator, Inquiry> {

	@Autowired
	AdministratorInquiryRepository repository;


	@Override
	public boolean authorise(final Request<Inquiry> request) {
		assert request != null;
		Integer id = request.getPrincipal().getActiveRoleId();

		Administrator a = this.repository.findOneAdministratorById(id);

		return a != null;
	}

	@Override
	public void bind(final Request<Inquiry> request, final Inquiry entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creationDate");
	}

	@Override
	public void unbind(final Request<Inquiry> request, final Inquiry entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "mmin", "mmax", "email");

	}

	@Override
	public Inquiry instantiate(final Request<Inquiry> request) {
		assert request != null;
		Inquiry result;
		Date moment = new Date(System.currentTimeMillis() - 1);

		result = new Inquiry();
		result.setCreationDate(moment);

		return result;
	}

	@Override
	public void validate(final Request<Inquiry> request, final Inquiry entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

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

		Boolean currencyValue = request.getServletRequest().getParameter("mmin").contains("EUR");
		Boolean currencyValue2 = request.getServletRequest().getParameter("mmax").contains("EUR");

		if (!errors.hasErrors()) {
			errors.state(request, currencyValue, "mmin", "acme.validation.currency");
			errors.state(request, currencyValue2, "mmax", "acme.validation.currency");
		}
	}

	@Override
	public void create(final Request<Inquiry> request, final Inquiry entity) {
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setCreationDate(moment);
		this.repository.save(entity);
	}

}
