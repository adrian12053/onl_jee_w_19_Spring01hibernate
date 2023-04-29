package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByTitle(String title);

    Book findByTitleAndDescription(String title, String description);

    List<Book> findByPublisher(Publisher publisher);

    List<Book> findByPagesGreaterThan(int pages); // SELECT * FROM books WHERE pages > x
}
