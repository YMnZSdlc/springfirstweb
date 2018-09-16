package pl.ymzs.springfirstweb.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.ymzs.springfirstweb.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
