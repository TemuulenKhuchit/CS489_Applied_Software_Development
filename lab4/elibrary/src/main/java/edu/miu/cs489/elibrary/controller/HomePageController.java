package edu.miu.cs489.elibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/", "/elibrary", "/home" })
public class HomePageController {

    @GetMapping({ "", "/", "/index" })
    public String index() {
        return "home/index";
    }
}