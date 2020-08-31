
package acme.entities.technologyRecord;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "activitySector asc"), @Index(columnList = "rating asc")
})
public class TechnologyRecord extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				title;

	@NotBlank
	@Pattern(regexp = "Technology|Science|Arts|Business|Health")
	private String				activitySector;

	@NotBlank
	private String				investorName;

	@NotBlank
	private String				description;

	@NotBlank
	private String				website;

	@NotBlank
	private String				email;

	@NotBlank
	@Pattern(regexp = "open-source|closed-source")
	private String				source;

	@NotNull
	@Range(min = -5, max = 5)
	private Integer				rating;
}
