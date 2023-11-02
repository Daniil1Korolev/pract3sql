package com.example.sqlpr3.controller;
import com.example.sqlpr3.models.Tovar;
import com.example.sqlpr3.repo.TovarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/tovar/")
public class TovarController {
    private final TovarRepository repositoryClass;

    @Autowired
    public TovarController (TovarRepository repositoryClass) {
        this.repositoryClass = repositoryClass;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getTovar(Model model) {
        List<Tovar> tovar = repositoryClass.findAll();
        model.addAttribute("tovar", tovar);
        return "all-tovar";
    }


    @RequestMapping(value="/", method = RequestMethod.POST)
    public String postTovar(@RequestParam(name = "name", defaultValue = "") String name, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("name", name);
        return "redirect:/tovar/";
    }

    @RequestMapping(value = "create-tovar", method = RequestMethod.GET)
    public String tovar(Tovar tovar) {
        return "create-tovar";
    }

    @RequestMapping(value = "create-tovar", method = RequestMethod.POST)
    public String postTovar(@Valid Tovar tovar, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "create-tovar";
        }
        repositoryClass.save(tovar);
        model.addAttribute("tovar", repositoryClass.findAll());
        return "all-tovar";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getTovar(Model model, @PathVariable("id") int id) {
        Tovar tovar = repositoryClass.findById(id).orElseThrow(() -> new IllegalArgumentException("Данный товар не существует! ->  " + id));
        model.addAttribute("tovar", tovar);
        return "show-tovar";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public String puTovar(Tovar tovar, Model model) {
        repositoryClass.save(tovar);
        model.addAttribute("tovar", repositoryClass.findAll());
        return "all-tovar";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String putTovar(@PathVariable("id") int id, Model model) {
        repositoryClass.deleteById(id);
        model.addAttribute("tovar", repositoryClass.findAll());
        return "all-tovar";
    }
}


