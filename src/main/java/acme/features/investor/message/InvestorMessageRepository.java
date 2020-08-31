
package acme.features.investor.message;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.forum.Forum;
import acme.entities.forum.ForumAuthenticated;
import acme.entities.message.Message;
import acme.entities.spamlist.Spamlist;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InvestorMessageRepository extends AbstractRepository {

	@Query("select m from Message m where m.forum.id = ?1")
	Collection<Message> findManyMessagesByForumId(int id);

	@Query("select m from Message m where m.id = ?1")
	Message findOneMessageById(int id);

	@Query("select f from Forum f where f.id = ?1")
	Forum findOneForumById(int id);

	@Query("select a from Spamlist a where a.idiom = ?1")
	Spamlist findIdiom(String idiom);

	@Query("select fa from ForumAuthenticated fa where fa.user.id = ?1 and fa.forum.id = ?2")
	ForumAuthenticated findAuthentication(int id, int forumId);

}
