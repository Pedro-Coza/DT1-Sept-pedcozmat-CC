
package acme.features.administrator.technologyRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.technologyRecord.TechnologyRecord;
import acme.framework.entities.Administrator;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorTechnologyRecordRepository extends AbstractRepository {

	@Query("select tr from TechnologyRecord tr")
	Collection<TechnologyRecord> findMany();

	@Query("select tr from TechnologyRecord tr where tr.id = ?1")
	TechnologyRecord findOneById(int id);

	@Query("select a from Administrator a where a.id = ?1")
	Administrator findOneAdministratorById(int id);
}
