package com.venturestartup.hackathon.global.check;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {

    @GetMapping("/api/check")
    public String check() {
        return "Ok!";
    }
}