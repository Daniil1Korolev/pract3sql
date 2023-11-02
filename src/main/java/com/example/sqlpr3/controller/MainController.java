package com.example.sqlpr3.controller;

import com.example.sqlpr3.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/main")
public class MainController {


    private final PersonRepository repositoryClass;

    @Autowired
    public MainController(PersonRepository repositoryClass) {
        this.repositoryClass = repositoryClass;
    }

    @GetMapping("")
    public String main(Model model){
        return "main";
    }
}