
package acme.features.administrator.toolRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.toolRecord.ToolRecord;
import acme.framework.entities.Administrator;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorToolRecordRepository extends AbstractRepository {

	@Query("select tr from ToolRecord tr")
	Collection<ToolRecord> findMany();

	@Query("select tr from ToolRecord tr where tr.id = ?1")
	ToolRecord findOneById(int id);

	@Query("select a from Administrator a where a.id = ?1")
	Administrator findOneAdministratorById(int id);
}
