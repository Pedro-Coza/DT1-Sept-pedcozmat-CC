
package acme.features.administrator.overture;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.overture.Overture;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorOvertureUpdateService implements AbstractUpdateService<Administrator, Overture> {

	@Autowired
	AdministratorOvertureRepository repository;


	@Override
	public boolean authorise(final Request<Overture> request) {
		assert request != null;
		Integer id = request.getPrincipal().getActiveRoleId();

		Administrator a = this.repository.findOneAdministratorById(id);

		return a != null;
	}

	@Override
	public void bind(final Request<Overture> request, final Overture entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creationDate");
	}

	@Override
	public void unbind(final Request<Overture> request, final Overture entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "mmin", "mmax", "email");
	}

	@Override
	public Overture findOne(final Request<Overture> request) {
		assert request != null;

		Overture result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

	@Override
	public void validate(final Request<Overture> request, final Overture entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Calendar calendar;
		Date minimumDeadLine;

		if (!errors.hasErrors("deadline")) {
			calendar = new GregorianCalendar();
			calendar.add(Calendar.DAY_OF_MONTH, 7);
			minimumDeadLine = calendar.getTime();
			if (entity.getDeadline() != null) {
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
	public void update(final Request<Overture> request, final Overture entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
