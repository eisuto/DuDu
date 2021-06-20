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
    AnimeRepository animeRepository;



    /**
     * 主页数据
     */
    @Override
    public Response<?> data() {
        Home home = new Home();
        home.setRecommendList(animeRepository.recommendAnime());
        return new Response<>(home);
    }



}
