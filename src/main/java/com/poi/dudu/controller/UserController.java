package com.poi.dudu.controller;

import com.poi.dudu.base.Response;
import com.poi.dudu.domain.User;
import com.poi.dudu.mapper.UserMapper;
import com.poi.dudu.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**用户相关 控制器
 * @author eisuto
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/register")
    public Response register(User user) throws Exception {
        return userService.register(user);
    }

    @RequestMapping("/login")
    public Response login(User user, HttpSession session) throws Exception{
        Response response = userService.login(user);
        if(response.getResult()!=null){
            User userInfo = (User)response.getResult();
            session.setAttribute("userId",userInfo.getId());
        }
        return  response;
    }
    @RequestMapping("/space")
    public Response space(User user) throws Exception{
        return userService.space(user);
    }

}
