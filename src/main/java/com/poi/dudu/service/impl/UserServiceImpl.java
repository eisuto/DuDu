package com.poi.dudu.service.impl;

import com.poi.dudu.base.BaseRequest;
import com.poi.dudu.base.Response;
import com.poi.dudu.domain.User;
import com.poi.dudu.mapper.UserRepository;
import com.poi.dudu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


/**
 * 用户相关业务 服务层实现
 *
 * @author eisuto
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    /**
     * 注册
     */
    @Override
    public Response register(User user) {
        Response<User> response = new Response<>();

        User re = userRepository.save(user);
        response.setData(re);
        return response;
    }

    /**
     * 登录
     */
    @Override
    public Response login(User user) {
        Response<User> response = new Response<>();
        User re = userRepository.findByPasswordAndName(user.getPassword(), user.getName());
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
    public Response usersList(BaseRequest page) {
        Response<Page> response = new Response<>();
        Page<User> users = userRepository.findAll(PageRequest.of(page.getNumber()-1, page.getSize()));
        response.setData(users);
        return response;
    }

    /**
     * 管理员 添加用户
     *
     * @param user
     * @return
     */
    @Override
    public Response usersAdd(User user) {
        Response<User> response = new Response<>();
        User re = userRepository.save(user);
        response.setData(re);
        return response;
    }

    /**
     * 管理员 删除
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public Integer userDel(Long[] ids) throws Exception {
        return userRepository.deleteByIdIn(ids);
    }


}
