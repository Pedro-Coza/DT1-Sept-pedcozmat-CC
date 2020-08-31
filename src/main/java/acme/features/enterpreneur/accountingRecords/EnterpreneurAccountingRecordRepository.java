
package acme.features.enterpreneur.accountingRecords;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.accountingRecord.AccountingRecord;
import acme.entities.roles.Enterpreneur;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EnterpreneurAccountingRecordRepository extends AbstractRepository {

	@Query("select i from AccountingRecord i")
	Collection<AccountingRecord> findMany();

	@Query("select i from AccountingRecord i where i.id = ?1")
	AccountingRecord findOneById(int id);

	@Query("select a from AccountingRecord a where a.invRound.id = ?1")
	Collection<AccountingRecord> findManyByInvRoundId(int id);

	@Query("select i from Enterpreneur i where i.id = ?1")
	Enterpreneur findEnterpreneurById(int id);
}
