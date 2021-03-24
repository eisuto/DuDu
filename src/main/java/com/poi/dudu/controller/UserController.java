package com.poi.dudu.controller;

import com.poi.dudu.domain.User;
import com.poi.dudu.mapper.UserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserMapper userMapper;
    @RequestMapping("/all")
    public List<User> all(User user){
        userMapper.insert(user);
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
        return userList;
    }

}
