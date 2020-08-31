
package acme.entities.accountingRecord;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import acme.entities.investmentRound.InvestmentRound;
import acme.entities.roles.Bookkeeper;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AccountingRecord extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				title;

	@Pattern(regexp = "draft|published")
	private String				status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date				creationMoment;

	@NotNull
	private String				body;

	@ManyToOne(optional = true)
	private InvestmentRound		invRound;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private Bookkeeper			bookkeeper;

}
