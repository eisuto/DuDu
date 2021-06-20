package com.poi.dudu.controller;

import com.poi.dudu.base.Response;
import com.poi.dudu.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 主页控制器
 * @author eisuto
 */
@Api(tags = "首页")
@RestController
@RequestMapping("/home")
public class HomeController {

    @Resource
    HomeService homeService;


    @ApiOperation(value = "获取首页数据", notes = "")
    @GetMapping("/data")
    public Response<?> data() {
        return homeService.data();
    }
}
