package com.poi.dudu.service.impl;

import com.poi.dudu.base.Response;
import com.poi.dudu.domain.Anime;
import com.poi.dudu.domain.Home;
import com.poi.dudu.domain.Recommend;
import com.poi.dudu.domain.Type;
import com.poi.dudu.mapper.AnimeRepository;
import com.poi.dudu.mapper.RecommendRepository;
import com.poi.dudu.mapper.TypeRepository;
import com.poi.dudu.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @author eisuto
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    RecommendRepository recommendRepository;

    @Autowired
    AnimeRepository animeRepository;

    @Autowired
    TypeRepository typeRepository;

    /**
     * 主页数据
     */
    @Override
    public Response<?> data() {
        Home home = new Home();
        List<Recommend> recommendList = recommendRepository.findAll();
        home.setRecommendList(recommendList);
        return new Response<>(home);
    }


    /**
     * 给动画添加类型
     * @return
     */

    @Override
    public Response<?> addTypeToAnime(){
        Anime anime = animeRepository.findOneByNameChinese("超能力女儿");
        Type type = typeRepository.findOneByName("搞笑");
        Set<Type> selectedTypes = anime.getTypes();
        selectedTypes.add(type);
        anime.setTypes(selectedTypes);
        animeRepository.save(anime);
        return new Response<>();
    }

}
