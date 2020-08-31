
package acme.entities.roles;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import acme.entities.investmentRound.InvestmentRound;
import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Enterpreneur extends UserRole {

	private static final long			serialVersionUID	= 1L;

	@NotBlank
	private String						startupName;

	@NotBlank
	//	@Pattern(regexp = "Technology|Science|Arts|Business|Health")
	private String						activitySector;

	@NotBlank
	private String						qualifRecord;

	@NotBlank
	private String						skillRecord;

	@OneToMany(mappedBy = "enterpreneur", fetch = FetchType.LAZY)
	private Collection<InvestmentRound>	invRound;
}
