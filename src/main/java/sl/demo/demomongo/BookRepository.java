package sl.demo.demomongo;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * The interface Author repository.
 */
public interface BookRepository extends MongoRepository<Book, String> {

}
