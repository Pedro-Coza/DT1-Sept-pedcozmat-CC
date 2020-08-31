
package acme.entities.forum;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.entities.investmentRound.InvestmentRound;
import acme.entities.message.Message;
import acme.framework.entities.DomainEntity;
import acme.framework.entities.UserAccount;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Forum extends DomainEntity {

	private static final long				serialVersionUID	= 1L;

	@NotBlank
	private String							title;

	@Temporal(TemporalType.TIMESTAMP)
	private Date							creationDate;

	@OneToOne(optional = true, cascade = CascadeType.ALL)
	private InvestmentRound					invRound;

	@OneToMany(mappedBy = "forum")
	private Collection<Message>				messages;

	@NotNull
	@OneToOne
	private UserAccount						administrator;

	@Valid
	@OneToMany(mappedBy = "forum")
	private Collection<ForumAuthenticated>	users;

}
