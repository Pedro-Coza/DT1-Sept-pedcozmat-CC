
package acme.features.patron.creditCard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.creditCard.CreditCard;
import acme.entities.roles.Patron;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronCreditCardRepository extends AbstractRepository {

	@Query("select d from CreditCard d where d.id = ?1")
	CreditCard findOneCardById(int id);

	@Query("select d from CreditCard d where d.number = ?1 AND d.cvv = ?2")
	CreditCard findByNumberCvv(String number, String cvv);

	@Query("select p from Patron p where p.id = ?1")
	Patron findPatronById(int id);
}
