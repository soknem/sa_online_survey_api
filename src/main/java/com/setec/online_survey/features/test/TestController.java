package com.setec.online_survey.features.test;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("")
    public String getString(){
        return "Home Page";
    }

    @GetMapping("/{text}")
    public String getString(@PathVariable String text){
        return "hello "+text;
    }

    @PostMapping
    public String testPost(@RequestBody String body){
        return body;
    }
}
