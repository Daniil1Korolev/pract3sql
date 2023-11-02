package com.example.sqlpr3.controller;

import com.example.sqlpr3.models.Hero;
import com.example.sqlpr3.repo.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/hero/")
public class HeroController {
        private final HeroRepository repositoryClass;

        @Autowired
        public HeroController (HeroRepository repositoryClass) {
            this.repositoryClass = repositoryClass;
        }

        @RequestMapping(value = "/", method = RequestMethod.GET)
        public String getHero(Model model) {
            List<Hero> characters = repositoryClass.findAll();
            model.addAttribute("hero", characters);
            return "all-hero";
        }

        @RequestMapping(value = "create-hero", method = RequestMethod.GET)
        public String hero(Hero hero) {
            return "create-hero";
        }

        @RequestMapping(value = "create-hero", method = RequestMethod.POST)
        public String postHero(@Valid Hero hero, BindingResult result, Model model) {
            if (result.hasErrors()) {
                return "create-hero";
            }
            repositoryClass.save(hero);
            model.addAttribute("hero", repositoryClass.findAll());
            return "all-hero";
        }

        @RequestMapping(value = "/{id}", method = RequestMethod.GET)
        public String getHero(Model model, @PathVariable("id") int id) {
            Hero hero = repositoryClass.findById(id).orElseThrow(() -> new IllegalArgumentException("Данный герой не существует! ->  " + id));
            model.addAttribute("hero", hero);
            return "show-hero";
        }

        @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
        public String putHero(Hero hero, Model model) {
            repositoryClass.save(hero);
            model.addAttribute("hero", repositoryClass.findAll());
            return "all-hero";
        }

        @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
        public String putHero(@PathVariable("id") int id, Model model) {
            repositoryClass.deleteById(id);
            model.addAttribute("hero", repositoryClass.findAll());
            return "all-hero";
        }
    }
