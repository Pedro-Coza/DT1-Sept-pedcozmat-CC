
package acme.features.administrator.overture;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.overture.Overture;
import acme.framework.entities.Administrator;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorOvertureRepository extends AbstractRepository {

	@Query("select i from Overture i")
	Collection<Overture> findMany();

	@Query("select i from Overture i where i.id = ?1")
	Overture findOneById(int id);

	@Query("select i from Overture i where now()<=i.deadline")
	Collection<Overture> findManyActive();

	@Query("select a from Administrator a where a.id = ?1")
	Administrator findOneAdministratorById(int id);
}
