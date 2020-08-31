
package acme.entities.creditCard;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import acme.entities.banner.Banner;
import acme.entities.roles.Patron;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CreditCard extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				holderName;

	@NotBlank
	@Pattern(regexp = "[0-9]{13,16}")
	private String				number;

	@NotNull
	@Pattern(regexp = "[0-9]{2}/[0-9]{4}")
	private String				expirationDate;

	@NotBlank
	@Pattern(regexp = "[0-9]{3}")
	private String				cvv;

	@OneToOne(optional = true)
	private Banner				banner;

	@OneToOne(optional = true)
	private Patron				patron;
}
