package com.poi.dudu.service.impl;

import com.poi.dudu.base.PageBase;
import com.poi.dudu.base.Response;
import com.poi.dudu.domain.User;
import com.poi.dudu.mapper.UserMapper;
import com.poi.dudu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Vector;


/**
 * 用户相关业务 服务层实现
 *
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
    public Response register(User user) {
        Response<User> response = new Response<>();

        User re = userMapper.save(user);
        response.setData(re);
        return response;
    }

    /**
     * 登录
     */
    @Override
    public Response login(User user) {
        Response<User> response = new Response<>();
        User re = userMapper.findByPasswordAndName(user.getPassword(), user.getName());
        if (re == null) {
            response.fail();
        } else {
            response.setData(re);
        }
        return response;
    }

    /**
     * 空间
     *
     * @param user 信息
     * @return
     */
    @Override
    public Response space(User user) {
        return null;
    }

    /**
     * 用户列表
     *
     * @param page 分页
     * @return
     */
    @Override
    public Response usersList(PageBase page) {
        Response<Page> response = new Response<>();
        Page<User> users = userMapper.findAll(PageRequest.of(page.getNumber()-1, page.getSize()));
        response.setData(users);
        return response;
    }

    /**
     * 管理员添加用户
     *
     * @param user
     * @return
     */
    @Override
    public Response usersAdd(User user) {
        Response<User> response = new Response<>();
        User re = userMapper.save(user);
        response.setData(re);
        return response;
    }

}
