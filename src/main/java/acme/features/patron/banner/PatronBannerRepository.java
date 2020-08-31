
package acme.features.patron.banner;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.banner.Banner;
import acme.entities.roles.Patron;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronBannerRepository extends AbstractRepository {

	@Query("select b from Banner b where b.id = ?1")
	Banner findOneById(int id);

	@Query("select b from Banner b where b.patron.id = ?1")
	Collection<Banner> findManyMine(int id);

	// @Query("select cc from CreditCard cc where cc.commercial.id = ?1")
	// CreditCard findCreditCardByBannerId(int id);

	@Query("select p from Patron p where p.id = ?1")
	Patron findPatronById(int id);
}
