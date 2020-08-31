
package acme.entities.investmentRound;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.entities.accountingRecord.AccountingRecord;
import acme.entities.application.Application;
import acme.entities.forum.Forum;
import acme.entities.roles.Enterpreneur;
import acme.entities.workProgramme.WorkProgramme;
import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InvestmentRound extends DomainEntity {

	private static final long				serialVersionUID	= 1L;

	//----- Atributes -----

	@NotNull
	private String							ticker;

	@Temporal(TemporalType.TIMESTAMP)
	private Date							creationDate;

	@NotBlank
	@Pattern(regexp = "SEED|ANGEL|SERIES-A|SERIES-B|SERIES-C|BRIDGE")
	private String							kindRound;

	@NotBlank
	private String							title;

	@NotNull
	private Money							money;

	@URL
	private String							info;

	@NotNull
	@Pattern(regexp = "ACTIVE|INACTIVE")
	private String							active;

	//----- Relationships -----

	@NotNull
	@OneToOne(mappedBy = "invRound", optional = false, targetEntity = WorkProgramme.class)
	private WorkProgramme					workProg;

	@OneToMany(mappedBy = "invRound", targetEntity = Application.class)
	private Collection<Application>			application;

	@ManyToOne(optional = false, targetEntity = Enterpreneur.class, fetch = FetchType.LAZY)
	private Enterpreneur					enterpreneur;

	@OneToMany(mappedBy = "invRound", targetEntity = AccountingRecord.class)
	private Collection<AccountingRecord>	acRecord;

	@OneToOne(mappedBy = "invRound", optional = false, targetEntity = Forum.class)
	private Forum							forum;

}
