package com.poi.dudu.service;

import com.poi.dudu.base.Response;
import com.poi.dudu.domain.User;

/**
 * 用户相关 服务层
 * @author eisuto
 */
public interface UserService {
    /**
     * 注册
     *
     * @return
     */
    Response register(User user) throws Exception;

    /**
     * 登录
     * @param user 信息
     */
    Response login(User user) throws Exception;
}
