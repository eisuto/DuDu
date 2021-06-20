package com.poi.dudu.mapper;

import com.poi.dudu.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author eisuto
 */
public interface AnimeRepository extends JpaRepository<Anime, Long>, JpaSpecificationExecutor<Anime> {

    Anime findOneByNameChinese(String name);

    /**
     * 推荐动画 随机10条
     */
    @Query(nativeQuery=true,value = "select * from `anime` order by rand() limit 10")
    List<Anime> recommendAnime();


}
