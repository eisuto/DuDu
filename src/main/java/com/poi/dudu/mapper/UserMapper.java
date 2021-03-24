package com.poi.dudu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.poi.dudu.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
