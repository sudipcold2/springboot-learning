package com.example.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("/")
    public String homePage(){
        return "Welcome to the Spring Boot World !!!!!";
    }

    @GetMapping("/test")
    public String testPage(){
        return "test page 3" + "app name and version :: " + appName + " : " + appVersion;
    }


}
