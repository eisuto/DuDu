package com.poi.dudu.mapper;

import com.poi.dudu.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends JpaRepository<User, Long> {
    User findByPasswordAndName(String password,String name);

}
