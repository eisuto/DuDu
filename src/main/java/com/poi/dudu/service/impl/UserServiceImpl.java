package com.poi.dudu.service.impl;

import com.poi.dudu.base.BaseRequest;
import com.poi.dudu.base.Response;
import com.poi.dudu.domain.User;
import com.poi.dudu.mapper.UserRepository;
import com.poi.dudu.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 用户相关业务 服务层实现
 *
 * @author eisuto
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserRepository userRepository;

    /**
     * 注册
     * @return
     */
    @Override
    public User register(User user) {

        if(user.getVerifyCode().equals("1234")){
            if(userRepository.checkExist(user.getName())==null){
                return userRepository.save(user);
            }
        }
        return null;
    }

    /**
     * 登录
     * @return
     */
    @Override
    public User login(User user) {
        return userRepository.login(user.getPassword(), user.getName());
    }

    /**
     * 空间
     *
     * @param user 信息
     * @return
     */
    @Override
    public Response<?> space(User user) {
        return null;
    }

    /**
     * 用户列表
     *
     * @param page 分页
     * @return
     */
    @Override
    public Response<?> usersList(BaseRequest page) {
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
    public Response<?> usersAdd(User user) {
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
