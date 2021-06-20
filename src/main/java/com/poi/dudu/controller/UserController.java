package com.poi.dudu.controller;

import com.poi.dudu.base.BaseRequest;
import com.poi.dudu.base.Response;
import com.poi.dudu.domain.User;
import com.poi.dudu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 用户相关 控制器
 *
 * @author eisuto
 */
@Api(tags = "用户相关")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    /**
     * 登录
     */
    @ApiOperation(value = "登录", notes = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true),
    })
    @PostMapping("/login")
    public Response<?> login(User user) throws Exception {
        return new Response<>(userService.login(user));
    }

    /**
     * 注册
     */
    @ApiOperation(value = "注册", notes = "用户注册")
        @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "打印的文件名", required = true),
    })
    @RequestMapping("/register")
    public Response<?> register(User user) throws Exception {
        return userService.register(user);
    }



    /**
     * 空间
     */
    @RequestMapping("/space")
    public Response<?> space(User user) throws Exception {
        return userService.space(user);
    }

    /**
     * 获取用户列表
     */
    @GetMapping("/users")
    public Response usersList(BaseRequest base) throws Exception {
        return userService.usersList(base);
    }

    /**
     * 后台 - 添加
     */
    @PostMapping("/users")
    public Response userAdd(@RequestBody User user) throws Exception {
        return userService.usersAdd(user);
    }

    /**
     * 后台 - 批量删除
     */
    @DeleteMapping("/users/{ids}")
    public Response userDel(@PathVariable Long[] ids) throws Exception {
        Response response = new Response<>();
        int i = userService.userDel(ids);
        if (i == 0) {
            response.fail();
        }
        return response;
    }


}
