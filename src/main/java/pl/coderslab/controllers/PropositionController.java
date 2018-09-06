package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.validation.PropositionGroup;

import javax.validation.Valid;
import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/propositions")
public class PropositionController {
    @Autowired
    BookDao bookDao;

    @Autowired
    PublisherDao publisherDao;

    @Autowired
    AuthorDao authorDao;

    @RequestMapping("/delete/{id}")
    public String confirmToDelete(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookDao.findById(id));
        return "proposition/confirmDelete";
    }

    @RequestMapping("/confirmed/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookDao.propositionDelete(id);
        return "redirect:/propositions";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        Book book = new Book();
        book.setProposition(true);
        model.addAttribute("book", book);
        return "book/form";
    }

    @RequestMapping("/edit/{id}")
    public String displayForm(@PathVariable long id, Model model) {
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "book/form";
    }

    @PostMapping("/form")
    public String saveForm(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book/form";
        }
        if (book.getPublisher().getId() == null) {
            book.setPublisher(null);
        }
        if(book.getId() != null) {
            bookDao.update(book);
        } else {
            bookDao.save(book);
        }
        return "redirect:/propositions";
    }

    @RequestMapping("")
    public String allBooks(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "proposition/list";
    }

    @ModelAttribute("books")
    public List<Book> getBooks() {
        return bookDao.findAll();
    }

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers() {
        return publisherDao.getAll();
    }

    @ModelAttribute("authors")
    public List<Author> getAuthors() {
        return authorDao.findAll();
    }
}
