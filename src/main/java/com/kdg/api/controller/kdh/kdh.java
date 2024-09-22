package com.kdg.api.controller.kdh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class kdh {

    @GetMapping("/kdh")
    public String kdhP(){

        return "KDH 퍼블릭";
    }
}
