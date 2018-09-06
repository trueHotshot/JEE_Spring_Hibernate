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
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookDao bookDao;

    @Autowired
    PublisherDao publisherDao;

    @Autowired
    AuthorDao authorDao;

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers() {
        return publisherDao.getAll();
    }

    @ModelAttribute("authors")
    public List<Author> getAuthors() {
        return authorDao.findAll();
    }

    @ModelAttribute("books")
    public List<Book> getBooks() {
        return bookDao.findAll();
    }

    @RequestMapping("/delete/{id}")
    public String confirmToDelete(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookDao.findById(id));
        return "book/confirmDelete";
    }

    @RequestMapping("/confirmed/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookDao.delete(id);
        return "redirect:/books";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/form";
    }

    @RequestMapping("/edit/{id}")
    public String displayForm(@PathVariable long id, Model model) {
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "book/form";
    }

    @PostMapping("/form")
    public String saveForm(@Validated({PropositionGroup.class, Default.class}) Book book, BindingResult result) {
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
        return "redirect:/books";
    }

    @RequestMapping("")
    public String allBooks(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "book/list";
    }

}
