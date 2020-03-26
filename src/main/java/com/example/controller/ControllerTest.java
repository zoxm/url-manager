package com.example.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class ControllerTest {

    @RequestMapping("{str}")
    public String test(@PathVariable("str")String str){
        return "success"+str;
    }
}
