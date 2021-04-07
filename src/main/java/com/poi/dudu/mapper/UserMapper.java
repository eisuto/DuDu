package com.poi.dudu.mapper;

import com.poi.dudu.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



/**
 * @author eisuto
 */
@Repository
public interface UserMapper extends JpaRepository<User, Long> {
    /**
     * 根据用户名和密码查询
     * @param password 密码
     * @param name 用户名
     * @return 用户
     */
    User findByPasswordAndName(String password,String name);

}
