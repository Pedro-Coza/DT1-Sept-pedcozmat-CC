//
//package acme.features.authenticated.workProgramme;
//
//import java.util.Collection;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import acme.entities.workProgramme.WorkProgramme;
//import acme.framework.repositories.AbstractRepository;
//
//@Repository
//public interface AuthenticatedWorkProgrammeRepository extends AbstractRepository {
//
//	@Query("select w from WorkProgramme w")
//	Collection<WorkProgramme> findMany();
//
//	@Query("select w from WorkProgramme w where w.id = ?1")
//	WorkProgramme findOneById(int id);
//
//	//	@Query("select w from WorkProgramme w where now()<=w.deadline")
//	//	Collection<WorkProgramme> findManyActive();
//
//	@Query("select w from WorkProgramme w where w.invRound.id = ?1")
//	Collection<WorkProgramme> findWorkProgrammesByIVID(int id);
//}
