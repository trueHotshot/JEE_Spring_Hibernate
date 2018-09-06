package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    AuthorDao authorDao;

    @ModelAttribute("authors")
    public List<Author> getAuthors() {
        return authorDao.findAll();
    }


    @RequestMapping("/delete")
    @ResponseBody
    public String deleteAuthor(@RequestParam Long id) {
        Author author = authorDao.findById(id);

        authorDao.delete(author);
        return "Id usuniętego autora to:" + author.getId();
    }

    @GetMapping("/form")
    public String displayForm(@RequestParam(required=false) Long id, Model model) {
        if(id != null) {
            model.addAttribute("author", authorDao.findById(id));
        } else {
            model.addAttribute("author", new Author());
        }
        return "author/form";
    }

    @PostMapping("/form")
    public String saveForm(@Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "author/form";
        }
        if(author.getId() != null) {
            authorDao.update(author);
        } else {
            authorDao.save(author);
        }
        return "redirect:/authors";
    }

    @RequestMapping("")
    public String allAuthors(Model model) {

        model.addAttribute("authors", authorDao.findAll());
        return "author/list";
    }


//
//    @ModelAttribute("books")
//    public List<Book> getBooks() {
//        return bookDao.findAll();
//    }

}
