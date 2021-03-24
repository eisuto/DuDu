package com.poi.dudu.service.impl;

import com.poi.dudu.base.Response;
import com.poi.dudu.domain.Home;
import com.poi.dudu.domain.Recommend;
import com.poi.dudu.mapper.RecommendMapper;
import com.poi.dudu.service.HomeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author eisuto
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Resource
    RecommendMapper recommendMapper;

    /**
     * 主页数据
     */
    @Override
    public Response data() {
        Home home = new Home();
        List<Recommend> recommendList = recommendMapper.selectList(null);
        home.setRecommendList(recommendList);
        return new Response<>(home);
    }
}
