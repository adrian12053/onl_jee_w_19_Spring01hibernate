package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Person;

@Slf4j
@Controller
@RequestMapping("persons")
@RequiredArgsConstructor
public class PersonController {

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        return "persons-form";
    }

//    @PostMapping
//    @ResponseBody
//    public void handleForm(@RequestParam("login") String login,
//                           @RequestParam("password") String password,
//                           @RequestParam("email") String email ) {
//        log.info("{} / {} / {}", login, password, email);
//    }

    @PostMapping
    @ResponseBody
    public void handleForm(@ModelAttribute("person") Person person) {
        log.info("{}", person);
    }
}
