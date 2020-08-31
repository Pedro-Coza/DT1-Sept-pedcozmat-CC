
package acme.features.authenticated.overture;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.overture.Overture;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedOvertureRepository extends AbstractRepository {

	@Query("select o from Overture o")
	Collection<Overture> findMany();

	@Query("select o from Overture o where o.id = ?1")
	Overture findOneById(int id);

	@Query("select o from Overture o where now()<=o.deadline")
	Collection<Overture> findManyActive();
}
