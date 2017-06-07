package sl.demo.demomongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;

public abstract class AbtractDemoController<E, ID extends Serializable> {

    private MongoRepository<E, ID> mongoRepository;

    protected AbtractDemoController(MongoRepository<E, ID> mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    @GetMapping("/{id}")
    public E getById(ID id) {
        return this.mongoRepository.findOne(id);
    }

    @GetMapping
    public Iterable<E> getAll() {
        return this.mongoRepository.findAll();
    }
}
