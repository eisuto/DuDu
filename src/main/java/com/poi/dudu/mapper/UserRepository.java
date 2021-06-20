package com.poi.dudu.mapper;

import com.poi.dudu.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author eisuto
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 登录
     * @return
     */
    @Query(value =
            "select u from User u " +
            "where u.password = :password and (u.name = :name or u.phone =:name or u.email =:name)")
    User login(@Param("password") String password,@Param("name") String name);

    /**
     * 检查用户是否存在
     * 查询是否有相同的用户名、邮箱、手机号
     */
    @Query(value =
            "select u from User u where u.name =:name or u.phone = :name or u.email = :name")
    User checkExist(@Param("name") String name);



    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Modifying
    @Transactional
    Integer deleteByIdIn(Long[] ids);

}
