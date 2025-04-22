package com.project.pet.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/pet")
public class PetController {

    @GetMapping
    public String getPet() {
        return "Hello shopping online project";
    }

}
