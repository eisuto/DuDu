package com.poi.dudu.controller;

import com.poi.dudu.base.BaseRequest;
import com.poi.dudu.base.Response;
import com.poi.dudu.domain.User;
import com.poi.dudu.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 用户相关 控制器
 *
 * @author eisuto
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    /**
     * 注册
     */
    @RequestMapping("/register")
    public Response<?> register(User user) throws Exception {
        return userService.register(user);
    }

    /**
     * 登录
     */
    @RequestMapping("/login")
    public Response<?> login(User user, HttpSession session) throws Exception {
        Response<?> response = userService.login(user);
        if (response.getData() != null) {
            User userInfo = (User) response.getData();
            session.setAttribute("userId", userInfo.getId());
        }
        return response;
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
