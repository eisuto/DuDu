package com.poi.dudu.mapper;

import com.poi.dudu.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author eisuto
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 根据用户名和密码查询
     * @param password 密码
     * @param name 用户名
     * @return 用户
     */
    User findByPasswordAndName(String password,String name);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Modifying
    @Transactional
    Integer deleteByIdIn(Long[] ids);

}
