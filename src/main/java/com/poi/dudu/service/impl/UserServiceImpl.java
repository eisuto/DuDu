package com.poi.dudu.service.impl;

import com.poi.dudu.base.Response;
import com.poi.dudu.domain.User;
import com.poi.dudu.mapper.UserMapper;
import com.poi.dudu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Vector;


/**
 * 用户相关业务 服务层实现
 * @author eisuto
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 注册
     */
    @Override
    public Response register(User user) throws Exception{
        Response<User> response = new Response<>();

        User re = userMapper.save(user);
        response.setResult(re);
        return response;
    }

    /**
     * 登录
     */
    @Override
    public Response login(User user) throws Exception {
        Response<User> response = new Response<>();
        User re = userMapper.findByPasswordAndName(user.getPassword(),user.getName());
        response.setResult(re);
        return response;
    }

}
