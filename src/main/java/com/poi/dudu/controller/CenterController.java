package com.poi.dudu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CenterController {

    @ResponseBody
    @RequestMapping("/")
    public String index() {
        return "index";
    }


}
