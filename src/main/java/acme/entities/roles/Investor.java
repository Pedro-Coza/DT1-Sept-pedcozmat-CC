
package acme.entities.roles;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import acme.entities.application.Application;
import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Investor extends UserRole {

	private static final long		serialVersionUID	= 1L;

	@NotBlank
	private String					firmName;

	@NotBlank
	//@Pattern(regexp = "Technology|Science|Arts|Business|Health")
	private String					activitySector;

	@NotBlank
	private String					profile;

	@OneToMany(mappedBy = "investor")
	private Collection<Application>	applications;


	public String getString() {
		return this.firmName + "-" + this.activitySector + super.toString();
	}
}
