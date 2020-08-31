
package acme.entities.roles;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import acme.entities.banner.Banner;
import acme.entities.creditCard.CreditCard;
import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patron extends UserRole {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				orgName;

	@OneToOne(mappedBy = "patron", optional = true)
	private CreditCard			creditCard;

	@OneToMany(mappedBy = "patron")
	private Collection<Banner>	banner;

}
