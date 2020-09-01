
package acme.entities.application;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.entities.investmentRound.InvestmentRound;
import acme.entities.roles.Investor;
import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "ticker asc"), @Index(columnList = "creationDate desc")
})
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

	private String				xxxxOffer;

	@URL
	private String				link;

	//@Pattern(regexp = "^$|^(?=(.*[a-zA-Z])){1,}(?=(.*[\\d])){1,}(?=(.*[\\W])){1,}.{10,}$")
	private String				password;

	@ManyToOne(optional = false)
	private InvestmentRound		invRound;

	@ManyToOne(optional = false)
	private Investor			investor;
}
