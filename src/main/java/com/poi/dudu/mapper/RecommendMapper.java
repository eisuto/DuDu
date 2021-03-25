package com.poi.dudu.mapper;

import com.poi.dudu.domain.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 首页推荐
 * @author eisuto
 */
@Repository
public interface RecommendMapper extends JpaRepository<Recommend, Long> {
}
