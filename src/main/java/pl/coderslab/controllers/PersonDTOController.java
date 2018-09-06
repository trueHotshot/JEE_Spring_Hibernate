package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDTO;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/persondto")
public class PersonDTOController {

    @ModelAttribute("genderList")
    public List<String> genderOptions() {
        String a[] = new String[] {"Male", "Female", "Shemale"};
        return Arrays.asList(a);
    }

    @ModelAttribute("countries")
    public List<String> countriel() {
        String a[] = new String[] {"Poland", "USA", "UK", "Germany", "Italy"};
        return Arrays.asList(a);
    }

    @ModelAttribute("skillList")
    public List<String> skillOptions() {
        String a[] = new String[] {"java", "php", "ruby", "python"};
        return Arrays.asList(a);
    }

    @ModelAttribute("hobbies")
    public List<String> hobbyOptions() {
        String a[] = new String[] {"programming", "programming", "programming"};
        return Arrays.asList(a);
    }

    @GetMapping("/form")
    public String displayForm(Model model) {
        PersonDTO personDTO = new PersonDTO();
        model.addAttribute("personDTO", personDTO);
        return "persondto/form";
    }

    @PostMapping("/form")
    public String saveForm(Model model, @ModelAttribute PersonDTO personDTO) {
        model.addAttribute("person", personDTO);
        return "persondto/view";
    }
}
