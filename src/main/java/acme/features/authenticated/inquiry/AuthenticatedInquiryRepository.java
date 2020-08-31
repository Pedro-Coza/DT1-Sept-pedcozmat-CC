
package acme.features.authenticated.inquiry;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.inquiry.Inquiry;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedInquiryRepository extends AbstractRepository {

	@Query("select i from Inquiry i")
	Collection<Inquiry> findMany();

	@Query("select i from Inquiry i where i.id = ?1")
	Inquiry findOneById(int id);

	@Query("select i from Inquiry i where now()<=i.deadline")
	Collection<Inquiry> findManyActive();
}
