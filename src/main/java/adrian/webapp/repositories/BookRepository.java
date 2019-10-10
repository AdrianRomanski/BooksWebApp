package adrian.webapp.repositories;

import adrian.webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface  BookRepository extends CrudRepository<Book, Long> {
}
