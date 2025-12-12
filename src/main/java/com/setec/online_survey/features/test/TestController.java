package com.setec.online_survey.features.test;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/test")
public class TestController {

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String getString(){
        return "Home Page";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String getStrings(){
        return "hello ";
    }

    @PostMapping
    public String testPost(@RequestBody String body){
        return body;
    }
}
