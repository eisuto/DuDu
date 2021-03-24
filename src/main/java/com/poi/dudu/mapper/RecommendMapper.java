package com.poi.dudu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.poi.dudu.domain.Recommend;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 首页推荐
 * @author eisuto
 */
@Repository
@Mapper
public interface RecommendMapper extends BaseMapper<Recommend> {
}
