package sl.demo.demomongo;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * The interface Author repository.
 */
public interface AuthorRepository extends MongoRepository<Author, String> {

}
