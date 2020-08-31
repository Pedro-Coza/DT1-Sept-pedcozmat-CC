
package acme.entities.roles;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import acme.entities.accountingRecord.AccountingRecord;
import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Bookkeeper extends UserRole {

	private static final long				serialVersionUID	= 1L;

	@NotBlank
	private String							firmName;

	@NotBlank
	private String							statement;

	@OneToMany(mappedBy = "bookkeeper", cascade = CascadeType.ALL)
	private Collection<AccountingRecord>	accRecords;

}
