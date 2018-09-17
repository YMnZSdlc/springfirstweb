package pl.ymzs.springfirstweb.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.ymzs.springfirstweb.model.Author;
import pl.ymzs.springfirstweb.model.Book;
import pl.ymzs.springfirstweb.model.Publisher;
import pl.ymzs.springfirstweb.repositories.AuthorRepository;
import pl.ymzs.springfirstweb.repositories.BookRepository;
import pl.ymzs.springfirstweb.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();

    }

    private void initData() {

        // Foo
        Publisher publier = new Publisher(); //id 1
        publier.setName("foo");

        publisherRepository.save(publier);

        //Eric
        Author eric = new Author("Eric", "Evans"); //id 2
        Book ddd = new Book("Domin Driven Design", "1234", publier);// id 3
        eric.getBooks().add(ddd); // id2 i id3
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson"); // id4
        Book noEJB = new Book("J2EE Development without WJB", "2345", publier); //id 5
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }


}
