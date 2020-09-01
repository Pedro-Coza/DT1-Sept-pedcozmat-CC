
package acme.features.enterpreneur.investmentRound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investmentRound.InvestmentRound;
import acme.entities.roles.Enterpreneur;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractDeleteService;

@Service
public class EnterpreneurInvestmentRoundDeleteService implements AbstractDeleteService<Enterpreneur, InvestmentRound> {

	@Autowired
	EnterpreneurInvestmentRoundRepository repository;


	@Override
	public boolean authorise(final Request<InvestmentRound> request) {
		assert request != null;
		//Compruebo que el id del Enterpreneur Principal coincida con el del Enterpreneur asociado a este InvestmentRound
		//y que no tenga aplicaciones hechas para poder borrarlo
		Integer id = request.getPrincipal().getActiveRoleId();

		Enterpreneur e = this.repository.findOneEnterpreneurById(id);

		Boolean enterpOk = false;
		Integer iRId = request.getModel().getInteger("id");
		InvestmentRound iR = this.repository.findOneInvestmentRoundById(iRId);
		Boolean appsCountValid = iR.getApplication().isEmpty();

		if (e != null) {
			enterpOk = this.repository.getEnterpIdByIRId(iRId).equals(id);
		}

		return enterpOk && appsCountValid;
	}

	@Override
	public void bind(final Request<InvestmentRound> request, final InvestmentRound entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<InvestmentRound> request, final InvestmentRound entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "kindRound", "title", "money", "info", "money", "active", "XXXX");

		Integer appsCount = this.repository.countAppsByIRId(entity.getId());

		model.setAttribute("appsCount", appsCount);
	}

	@Override
	public InvestmentRound findOne(final Request<InvestmentRound> request) {
		assert request != null;

		InvestmentRound result = null;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneInvestmentRoundById(id);

		return result;
	}

	@Override
	public void validate(final Request<InvestmentRound> request, final InvestmentRound entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Boolean deleteable = this.repository.findManyApplicationsByIRId(entity.getId()).isEmpty();

		errors.state(request, deleteable, "ticker", "acme.validation.notDeleteable");
	}

	@Override
	public void delete(final Request<InvestmentRound> request, final InvestmentRound entity) {
		assert request != null;
		assert entity != null;

		Integer forumId = entity.getForum().getId();
		Integer workPId = entity.getWorkProg().getId();

		this.repository.deleteMessageByForumId(forumId);
		this.repository.deleteForumAuthenticated(forumId);
		this.repository.deleteForum(forumId);
		this.repository.deleteActivitiesByWPId(workPId);
		this.repository.deleteWorkProgramme(workPId);

		this.repository.deleteAccountingRecord(entity.getId());

		this.repository.deleteIR(entity.getId());

	}
}
