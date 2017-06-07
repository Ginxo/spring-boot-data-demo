package sl.demo.demomongo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController extends AbtractDemoController<Author, String> {

    @Autowired
    public AuthorController(AuthorRepository mongoRepository) {
        super(mongoRepository);
    }
}
