package com.poi.dudu.service;

import com.poi.dudu.base.BaseRequest;
import com.poi.dudu.base.Response;
import com.poi.dudu.domain.User;

/**
 * 用户相关 服务层
 *
 * @author eisuto
 */
public interface UserService {
    /**
     * 注册
     *
     * @param user 信息
     * @return
     * @throws Exception
     */
    Response<?> register(User user) throws Exception;

    /**
     * 登录
     *
     * @param user 信息
     * @return info
     * @throws Exception
     */
    User login(User user) throws Exception;

    /**
     * 空间
     *
     * @param user 信息
     * @return
     * @throws Exception
     */
    Response<?> space(User user) throws Exception;

    /**
     * 用户列表
     * @param page
     * @return
     * @throws Exception
     */
    Response<?> usersList(BaseRequest page) throws Exception;

    /**
     * 管理员 添加
     * @param user
     * @return
     * @throws Exception
     */
    Response<?> usersAdd(User user) throws Exception;

    /**
     * 管理员 删除
     * @param ids
     * @return
     * @throws Exception
     */
    Integer userDel(Long[] ids) throws Exception;
}
