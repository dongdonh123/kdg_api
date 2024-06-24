package com.kdg.api.controller;


import com.kdg.api.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/demo")
    public String demo(){
        String demo = demoService.getDemo();

        return demo;
    }

    @PostMapping("/demo")
    public String postDemo(){
        String demo = demoService.getDemo();

        return demo;
    }
}
