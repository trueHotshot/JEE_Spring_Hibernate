package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.entity.Person;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonDao personDao;

    @RequestMapping("/save")
    @ResponseBody
    public String savePerson(@RequestParam String login, @RequestParam String password, @RequestParam String email) {
        Person person = new Person();
        person.setLogin(login);
        person.setPassword(password);
        person.setEmail(email);

        personDao.save(person);
        return "Id dodanej osoby to:" + person.getId();
    }

    @RequestMapping("/update")
    @ResponseBody
    public String editPerson(@RequestParam Long id, @RequestParam String login, @RequestParam String password, @RequestParam String email) {
        Person person = personDao.findById(id);
        person.setLogin(login);
        person.setPassword(password);
        person.setEmail(email);;

        personDao.update(person);
        return "Id zedytowanej osoby to:" + person.getId();
    }

    @RequestMapping("/get")
    @ResponseBody
    public Person getPerson(@RequestParam Long id) {
        return personDao.findById(id);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deletePublisher(@RequestParam Long id) {
        Person person = personDao.findById(id);

        personDao.delete(person);
        return "Id usuniętej osoby to:" + person.getId();
    }

    @GetMapping("/form")
    public String displayForm(Model model) {
        Person person = new Person();
        person.setLogin("zimnyleszek");
        model.addAttribute("person", person);
        return "person/form";
    }

    @PostMapping("/form")
    @ResponseBody
    public String saveForm(@ModelAttribute Person person) {
        personDao.save(person);
        return "Id: " + person.getId();
    }
}
