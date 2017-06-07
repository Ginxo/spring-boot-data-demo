package sl.demo.demomongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * The interface Author repository.
 */
@RepositoryRestResource(collectionResourceRel = "author", path = "author")
public interface AuthorRepository extends MongoRepository<Author, String> {

    List<Author> findByName(@Param("name") String name);
}
