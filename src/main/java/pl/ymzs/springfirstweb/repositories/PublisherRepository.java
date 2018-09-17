package pl.ymzs.springfirstweb.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.ymzs.springfirstweb.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {


}
