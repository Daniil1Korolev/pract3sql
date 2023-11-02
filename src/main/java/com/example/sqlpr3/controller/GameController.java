package com.example.sqlpr3.controller;

import com.example.sqlpr3.models.Game;
import com.example.sqlpr3.repo.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/game/")
public class GameController {
    private final GameRepository repositoryClass;

    @Autowired
    public GameController (GameRepository repositoryClass) {
        this.repositoryClass = repositoryClass;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getGame(Model model) {
        List<Game> game = repositoryClass.findAll();
        model.addAttribute("game", game);
        return "all-game";
    }


    @RequestMapping(value="/", method = RequestMethod.POST)
    public String postGame(@RequestParam(name = "name", defaultValue = "") String name, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("name", name);
        return "redirect:/game/";
    }

    @RequestMapping(value = "create-game", method = RequestMethod.GET)
    public String game(Game game) {
        return "create-game";
    }

    @RequestMapping(value = "create-game", method = RequestMethod.POST)
    public String postGame(@Valid Game game, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "create-game";
        }
        repositoryClass.save(game);
        model.addAttribute("game", repositoryClass.findAll());
        return "all-game";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getGame(Model model, @PathVariable("id") int id) {
        Game game = repositoryClass.findById(id).orElseThrow(() -> new IllegalArgumentException("Данная игра не существует! ->  " + id));
        model.addAttribute("game", game);
        return "show-game";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public String putGame(Game game, Model model) {
        repositoryClass.save(game);
        model.addAttribute("game", repositoryClass.findAll());
        return "all-game";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String putGame(@PathVariable("id") int id, Model model) {
        repositoryClass.deleteById(id);
        model.addAttribute("game", repositoryClass.findAll());
        return "all-game";
    }
}


