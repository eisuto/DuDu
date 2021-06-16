package com.poi.dudu.service.impl;

import com.poi.dudu.base.Response;
import com.poi.dudu.domain.Anime;
import com.poi.dudu.domain.Type;
import com.poi.dudu.mapper.AnimeRepository;
import com.poi.dudu.mapper.TypeRepository;
import com.poi.dudu.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * 动画相关服务层
 *
 * @author eisuto
 */
@Service
public class AnimeServiceImpl implements AnimeService {
    @Autowired
    AnimeRepository animeRepository;

    @Autowired
    TypeRepository typeRepository;

    /**
     * 给动画添加类型
     *
     * @return
     */
    @Override
    public Response<?> addTypeToAnime() {
        Anime anime = animeRepository.findOneByNameChinese("超能力女儿");
        Type type = typeRepository.findOneByName("搞笑");
        Set<Type> selectedTypes = anime.getTypes();
        selectedTypes.add(type);
        anime.setTypes(selectedTypes);
        animeRepository.save(anime);
        return new Response<>();
    }
}
