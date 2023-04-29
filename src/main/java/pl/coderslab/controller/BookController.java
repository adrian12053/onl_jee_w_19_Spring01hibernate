package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;
import pl.coderslab.repository.BookRepository;

import java.util.Random;

@Slf4j
@Transactional
@RestController
@RequiredArgsConstructor
@RequestMapping("books")
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    private final BookRepository bookRepository;

    @GetMapping("add")
    public String addBook() {
        // add publisher
        Publisher publisher = new Publisher();
        publisher.setName("pub_" + new Random().nextInt());
        publisherDao.save(publisher);

        Book book = new Book();
        book.setTitle("Title 1");
        book.setDescription("Description 1");
        book.setRating(3);
        book.setPublisher(publisher); // ustawiamy wydawcę

        bookDao.saveBook(book);

        return "book id is " + book.getId();
    }

    @GetMapping("get/{id}")
    public String getBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        return book.toString();
    }

    @GetMapping("update/{id}/{title}")
    public String updateBook(@PathVariable long id, @PathVariable String title ) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
        return book.toString();
    }

    @GetMapping("delete/{id}")
    public String deleteBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "deleted";
    }

    @GetMapping("/all")
    @ResponseBody  // optional since we use @RestController
    public void getAllBooks() {
        bookRepository.findAll().forEach(b -> log.info(b.toString()));

//        bookDao.findAll().forEach(b -> log.info(b.toString()));
    }

}
