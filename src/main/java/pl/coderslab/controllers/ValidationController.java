package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class ValidationController {

    @Autowired
    Validator validator;

    @RequestMapping("/validateBook")
    public String validateBook(Model model) {
        Book book = new Book();
        book.setTitle("Krowa i przyjaciele");
        List<Author> authors = new ArrayList<>();
        authors.add(new Author());
        book.setAuthors(authors);
        book.setPublisher(new Publisher());
        Set<ConstraintViolation<Book>> violations = validator.validate(book);

        model.addAttribute("violations", violations);

        return "validator/book";
    }

    @RequestMapping("/validateAuthor")
    public String validateAuthor(Model model) {
        Author author = new Author();
        author.setFirstName("Mariusz");
        author.setLastName("Majusz");
//        author.setEmail("email");
//        author.setPesel("abc");
        Set<ConstraintViolation<Author>> violations = validator.validate(author);
        model.addAttribute("violations", violations);
        return "validator/book";
    }

    @RequestMapping("/validatePublisher")
    public String validatePublisher(Model model) {
        Publisher publisher = new Publisher();
        Set<ConstraintViolation<Publisher>> violations = validator.validate(publisher);
        model.addAttribute("violations", violations);
        return "validator/book";
    }
}
