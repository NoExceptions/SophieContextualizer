package com.ihm.contextualizer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/util")
public class UtilEndP {
    @GetMapping(value = "/")
    public String sayHi() {
        return "Hi!";
    }
}
