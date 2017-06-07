package sl.demo.demomongo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Book controller.
 */
@RestController
@RequestMapping("/book")
public class BookController extends AbtractDemoController<Book, String> {

    /**
     * Instantiates a new Book controller.
     *
     * @param mongoRepository the mongo repository
     */
    @Autowired
    public BookController(BookRepository mongoRepository) {
        super(mongoRepository);
    }

    /**
     * Get authors response entity.
     *
     * @param id the id
     *
     * @return the response entity
     */
    @GetMapping("/{id}/authors")
    public ResponseEntity<Iterable<Author>> getAuthors(String id){
        final Book book = super.getById(id);
        final Iterable<Author> authors = book.getAuthor();
        return book!=null ? new ResponseEntity(book.getAuthor(), HttpStatus.OK) : new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }
}
