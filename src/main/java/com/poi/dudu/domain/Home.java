package com.poi.dudu.domain;

import lombok.Data;

import java.util.List;

/**
 * 首页数据
 * @author eisut
 */
@Data
public class Home {
    public List<Recommend> recommendList;
}
