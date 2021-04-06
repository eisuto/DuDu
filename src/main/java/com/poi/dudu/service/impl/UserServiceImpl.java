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
    public Response register(User user) throws Exception {
        Response<User> response = new Response<>();

        User re = userMapper.save(user);
        response.setData(re);
        return response;
    }

    /**
     * 登录
     */
    @Override
    public Response login(User user) throws Exception {
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
     * @throws Exception
     */
    @Override
    public Response space(User user) throws Exception {
        return null;
    }

    /**
     * 用户列表
     *
     * @param page 分页
     * @return
     * @throws Exception
     */
    @Override
    public Response usersList(PageBase page) throws Exception {
        Response<Page> response = new Response<>();
        Page<User> users = userMapper.findAll(PageRequest.of(page.getNumber(), page.getSize()));
        response.setData(users);
        return response;
    }

}
