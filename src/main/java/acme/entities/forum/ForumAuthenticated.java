
package acme.entities.forum;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import acme.framework.entities.DomainEntity;
import acme.framework.entities.UserAccount;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ForumAuthenticated extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@Valid
	@ManyToOne(optional = true)
	private Forum				forum;

	@Valid
	@ManyToOne
	private UserAccount			user;

}
