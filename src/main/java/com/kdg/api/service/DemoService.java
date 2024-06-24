package com.kdg.api.service;


import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public String getDemo(){
        return "service demo!";
    }
}
