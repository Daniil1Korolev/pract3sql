package com.example.sqlpr3.controller;

import com.example.sqlpr3.models.Person;
import com.example.sqlpr3.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/person/")
public class HomeController {
        private final PersonRepository repositoryClass;

        @Autowired
        public HomeController (PersonRepository repositoryClass) {
            this.repositoryClass = repositoryClass;
        }

        @RequestMapping(value = "/", method = RequestMethod.GET)
        public String getPerson(Model model) {
            List<Person> person = repositoryClass.findAll();
            model.addAttribute("person", person);
            return "all-person";
        }


        @RequestMapping(value="/", method = RequestMethod.POST)
        public String postPerson(@RequestParam(name = "name", defaultValue = "") String name, RedirectAttributes redirectAttributes) {
            redirectAttributes.addAttribute("name", name);
            return "redirect:/person/";
        }

        @RequestMapping(value = "create-person", method = RequestMethod.GET)
        public String person(Person person) {
            return "create-person";
        }

        @RequestMapping(value = "create-person", method = RequestMethod.POST)
        public String postPerson(@Valid Person person, BindingResult result, Model model) {
            if (result.hasErrors()) {
                return "create-person";
            }
            repositoryClass.save(person);
            model.addAttribute("person", repositoryClass.findAll());
            return "all-person";
        }

        @RequestMapping(value = "/{id}", method = RequestMethod.GET)
        public String getPerson(Model model, @PathVariable("id") int id) {
            Person person = repositoryClass.findById(id).orElseThrow(() -> new IllegalArgumentException("Данный сотрудник не существует! ->  " + id));
            model.addAttribute("person", person);
            return "show-person";
        }

        @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
        public String putPerson(Person person, Model model) {
            repositoryClass.save(person);
            model.addAttribute("person", repositoryClass.findAll());
            return "all-person";
        }

        @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
        public String putPerson(@PathVariable("id") int id, Model model) {
            repositoryClass.deleteById(id);
            model.addAttribute("person", repositoryClass.findAll());
            return "all-person";
        }
    }


