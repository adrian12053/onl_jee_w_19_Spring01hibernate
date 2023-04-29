package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Slf4j
@Controller
@RequestMapping("validation")
@RequiredArgsConstructor
public class ValidationController {

    private final Validator validator;

    @GetMapping("validate")
    @ResponseBody
    public String validate() {
        Book book = new Book();

        Set<ConstraintViolation<Book>> result = validator.validate(book);

        if (!result.isEmpty()) {
            // błędy
            for (ConstraintViolation<Book> v : result) {
                log.info("{} : {}", v.getPropertyPath(), v.getMessage());
            }
        } else {
            // brak błędów
        }

        return null;
    }
}
