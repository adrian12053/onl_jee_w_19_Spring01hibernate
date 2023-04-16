package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("bookForm")
public class BookFormController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    @GetMapping
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "bookForm-add";
    }

    @PostMapping
    @ResponseBody
    public void handleAddBookForm(@ModelAttribute("book") Book book) {
        log.info("Adding new book - {}", book);
        bookDao.saveBook(book);
    }

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers() {
        return publisherDao.findAll();
    }
}
