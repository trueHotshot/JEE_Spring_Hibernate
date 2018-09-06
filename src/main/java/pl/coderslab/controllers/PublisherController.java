package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import java.util.List;

@Controller
@RequestMapping("/publishers")
public class PublisherController {
    @Autowired
    PublisherDao publisherDao;

    @Autowired
    BookDao bookDao;

    @RequestMapping("/save")
    @ResponseBody
    public String addPublisher(@RequestParam String name) {
        Publisher publisher = new Publisher();
        publisher.setName(name);

        publisherDao.save(publisher);
        return "Id dodanego wydawcy to:" + publisher.getId();
    }

    @RequestMapping("/update")
    @ResponseBody
    public String editPublisher(@RequestParam Long id, @RequestParam String name) {
        Publisher publisher = publisherDao.findById(id);
        publisher.setName(name);

        publisherDao.update(publisher);
        return "Id zedytowanego wydawcy to:" + publisher.getId();
    }

    @RequestMapping("/get")
    @ResponseBody
    public Publisher getPublisher(@RequestParam Long id) {
        return publisherDao.findById(id);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deletePublisher(@RequestParam Long id) {
        Publisher publisher = publisherDao.findById(id);

        publisherDao.delete(publisher);
        return "Id usuniętego wydawcy to:" + publisher.getId();
    }

    @GetMapping("/form")
    public String displayForm(Model model, @RequestParam(required=false) Long id) {
        if(id != null) {
            model.addAttribute("publisher", publisherDao.findById(id));
        } else {
            model.addAttribute("publisher", new Publisher());
        }
        return "publisher/form";
    }

    @PostMapping("/form")
    public String saveForm(Model model, @ModelAttribute Publisher publisher) {
        if(publisher.getId() != null) {
            publisherDao.update(publisher);
        } else {
            publisherDao.save(publisher);
        }
        return "redirect:/publishers";
    }

    @RequestMapping("")
    public String allPublishers(Model model) {

        model.addAttribute("publishers", publisherDao.getAll());
        return "publisher/list";
    }

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers() {
        return publisherDao.getAll();
    }

    @ModelAttribute("books")
    public List<Book> getBooks() {
        return bookDao.findAll();
    }
}
