package com.poi.dudu.service;

import com.poi.dudu.base.Response;
import com.poi.dudu.domain.User;

/**
 * 用户相关 服务层
 */
public interface UserService {
    /**
     * 用户注册
     *
     * @return
     */
    Response register(User user) throws Exception;
}
