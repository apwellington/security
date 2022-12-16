package com.example.scuritye.resources;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResources {
    @GetMapping("/home")
    public String home(){
        return "Hola Mundo";
    }
}
