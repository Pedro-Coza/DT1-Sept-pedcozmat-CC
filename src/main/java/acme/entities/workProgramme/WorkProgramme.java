
package acme.entities.workProgramme;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import acme.entities.activity.Activity;
import acme.entities.investmentRound.InvestmentRound;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class WorkProgramme extends DomainEntity {

	private static final long		serialVersionUID	= 1L;

	@OneToOne(optional = true, cascade = CascadeType.ALL)
	private InvestmentRound			invRound;

	@OneToMany(mappedBy = "workProg", cascade = CascadeType.ALL)
	private Collection<Activity>	activities;
}
