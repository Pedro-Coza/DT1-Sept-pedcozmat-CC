//
//package acme.features.authenticated.workProgramme;
//
//import java.util.Collection;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import acme.entities.workProgramme.WorkProgramme;
//import acme.framework.components.Model;
//import acme.framework.components.Request;
//import acme.framework.entities.Authenticated;
//import acme.framework.services.AbstractListService;
//
//@Service
//public class AuthenticatedWorkProgrammeListService implements AbstractListService<Authenticated, WorkProgramme> {
//
//	@Autowired
//	AuthenticatedWorkProgrammeRepository repository;
//
//
//	@Override
//	public boolean authorise(final Request<WorkProgramme> request) {
//		assert request != null;
//		return true;
//	}
//
//	@Override
//	public void unbind(final Request<WorkProgramme> request, final WorkProgramme entity, final Model model) {
//		assert request != null;
//		assert entity != null;
//		assert model != null;
//
//		request.unbind(entity, model, "activities");
//	}
//
//	@Override
//	public Collection<WorkProgramme> findMany(final Request<WorkProgramme> request) {
//		assert request != null;
//
//		Collection<WorkProgramme> result;
//
//		String iVId = request.getServletRequest().getParameter("id");
//		result = this.repository.findWorkProgrammesByIVID(Integer.parseInt(iVId));
//
//		return result;
//	}
//}
