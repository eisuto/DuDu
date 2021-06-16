package com.poi.dudu.service;

import com.poi.dudu.base.Response;

/**
 * 动画相关服务层接口
 * @author eisuto
 */
public interface AnimeService {
    /**
     * 给动画添加类型
     * @return
     */
    Response<?> addTypeToAnime();
}
