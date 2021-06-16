package com.poi.dudu.service;

import com.poi.dudu.base.Response;

/**
 * 主页服务层
 * @author eisut
 */
public interface HomeService {

    /**
     * 主页数据
     * @return
     */
    Response<?> data();

    /**
     * 给动画添加类型
     * @return
     */
    Response<?> addTypeToAnime();
}
