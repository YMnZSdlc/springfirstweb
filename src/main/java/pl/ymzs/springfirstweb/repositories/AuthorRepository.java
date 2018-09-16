package pl.ymzs.springfirstweb.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.ymzs.springfirstweb.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
