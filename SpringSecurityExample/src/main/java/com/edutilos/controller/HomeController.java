package com.edutilos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nijat Aghayev on 27.05.19.
 */
@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public String home() {
        return "Welcome to our homepage";
    }
}
