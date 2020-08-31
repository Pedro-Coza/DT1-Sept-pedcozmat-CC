
package acme.entities.application;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import acme.entities.investmentRound.InvestmentRound;
import acme.entities.roles.Investor;
import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Application extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				ticker;

	@Temporal(TemporalType.TIMESTAMP)
	private Date				creationDate;

	@NotBlank
	private String				statement;

	@NotNull
	private Money				invOffer;

	@NotBlank
	@Pattern(regexp = "ACCEPTED|REJECTED|PENDING") //pending, accepted, rejected
	private String				status;

	private String				justification;

	@ManyToOne(optional = false)
	private InvestmentRound		invRound;

	@ManyToOne(optional = false)
	private Investor			investor;
}
