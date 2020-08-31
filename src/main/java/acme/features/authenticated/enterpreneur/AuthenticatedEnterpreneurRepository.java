
package acme.features.authenticated.enterpreneur;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import acme.entities.roles.Enterpreneur;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Service
public interface AuthenticatedEnterpreneurRepository extends AbstractRepository {

	@Query("select e from Enterpreneur e where e.userAccount.id = ?1")
	Enterpreneur findOneEnterpreneurByUserId(int id);

	@Query("select ua from UserAccount ua where ua.id = ?1")
	UserAccount findOneUserAccountById(int id);

}
