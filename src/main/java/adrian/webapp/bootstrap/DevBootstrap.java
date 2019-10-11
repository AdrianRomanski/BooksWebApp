package adrian.webapp.bootstrap;

import adrian.webapp.model.Author;
import adrian.webapp.model.Book;
import adrian.webapp.model.Publisher;
import adrian.webapp.repositories.AuthorRepository;
import adrian.webapp.repositories.BookRepository;
import adrian.webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

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

        Publisher worx = new Publisher();
        worx.setName("Worx");
        publisherRepository.save(worx);

        Publisher addisonWesley = new Publisher();
        addisonWesley.setName("Addison-Wesley");
        publisherRepository.save(addisonWesley);

        // Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Decision", "1234", addisonWesley);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        // Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);


    }
}