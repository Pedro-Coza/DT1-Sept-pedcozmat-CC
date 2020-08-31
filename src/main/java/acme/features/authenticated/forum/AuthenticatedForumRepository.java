
package acme.features.authenticated.forum;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.forum.Forum;
import acme.entities.forum.ForumAuthenticated;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedForumRepository extends AbstractRepository {

	@Query("select f from Forum f join f.users u where u.user.id = ?1")
	Collection<Forum> findManyForumByUserId(int id);

	@Query("select f from Forum f where f.id = ?1")
	Forum findOneForumById(int id);

	@Query("select fa from ForumAuthenticated fa where fa.user.id = ?1 and fa.forum.id = ?2")
	ForumAuthenticated findAuthentication(int id, int forumId);

}
