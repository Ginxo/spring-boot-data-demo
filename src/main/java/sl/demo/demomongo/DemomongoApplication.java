package sl.demo.demomongo;

import de.flapdoodle.embed.process.collections.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemomongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemomongoApplication.class, args);
	}

	@Autowired
	private BookRepository bookRepository;


	@Autowired
	private AuthorRepository authorRepository;

	@PostConstruct
	public void initData(){
		Author author = new Author();
		author.setName("Kike");
		author.setSurname("Mingorance");
		author = authorRepository.save(author);

		final Book book = new Book();
		book.setAuthor(Collections.newArrayList(author));
		book.setTitle("Libro flipante");


		Author author2 = new Author();
		author2.setName("Kike2");
		author2.setSurname("Mingorance2");
		author2 = authorRepository.save(author2);

		final Book book2 = new Book();
		book2.setAuthor(Collections.newArrayList(author, author2));
		book2.setTitle("Libro flipante2");

		bookRepository.save(book);
		bookRepository.save(book2);
	}
}
