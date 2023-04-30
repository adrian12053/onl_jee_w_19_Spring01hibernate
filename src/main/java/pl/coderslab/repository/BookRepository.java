package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Category;
import pl.coderslab.model.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByTitleAndDescription(String title, String description);

    List<Book> findByPublisher(Publisher publisher);

    List<Book> findByPagesGreaterThan(int pages); // SELECT * FROM books WHERE pages > x

    //metodę wyszukującą książki dla zadanego tytułu.
    List<Book> findByTitle(String title);

    //metodę wyszukującą książki dla zadanej kategorii
    List<Book> findByCategory(Category category);

    //metodę wyszukującą książki dla zadanego id kategorii
    List<Book> findByCategoryId(Long categoryId);

    List<Book> findByCategoryName(String categoryName);

    List<Book> findByAuthorsContains(Author author);

    List<Book> findByAuthors_FirstName(String fn);

}
