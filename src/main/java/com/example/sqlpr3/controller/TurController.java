package com.example.sqlpr3.controller;

import com.example.sqlpr3.models.Tur;
import com.example.sqlpr3.repo.TurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/tur/")
public class TurController {
    private final TurRepository repositoryClass;

    @Autowired
    public TurController (TurRepository repositoryClass) {
        this.repositoryClass = repositoryClass;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getTur(Model model) {
        List<Tur> tur = repositoryClass.findAll();
        model.addAttribute("tur", tur);
        return "all-tur";
    }


    @RequestMapping(value="/", method = RequestMethod.POST)
    public String postTur(@RequestParam(name = "name", defaultValue = "") String name, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("name", name);
        return "redirect:/tur/";
    }

    @RequestMapping(value = "create-tur", method = RequestMethod.GET)
    public String tur(Tur tur) {
        return "create-tur";
    }

    @RequestMapping(value = "create-tur", method = RequestMethod.POST)
    public String postTur(@Valid Tur tur, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "create-tur";
        }
        repositoryClass.save(tur);
        model.addAttribute("tur", repositoryClass.findAll());
        return "all-tur";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getTur(Model model, @PathVariable("id") int id) {
        Tur tur = repositoryClass.findById(id).orElseThrow(() -> new IllegalArgumentException("Данный тур не существует! ->  " + id));
        model.addAttribute("tur", tur);
        return "show-tur";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public String putTur(Tur tur, Model model) {
        repositoryClass.save(tur);
        model.addAttribute("tur", repositoryClass.findAll());
        return "all-tur";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String putTur(@PathVariable("id") int id, Model model) {
        repositoryClass.deleteById(id);
        model.addAttribute("tur", repositoryClass.findAll());
        return "all-tur";
    }
}


