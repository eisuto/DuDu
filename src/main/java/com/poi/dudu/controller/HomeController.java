package com.poi.dudu.controller;

import com.poi.dudu.base.Response;
import com.poi.dudu.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author eisuto
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    HomeService homeService;

    @RequestMapping("/data")
    public Response data() {
        return homeService.data();
    }
}
