package com.poi.dudu.domain;

import lombok.Data;

/**
 * 首页推荐
 * @author eisuto
 */
@Data
public class Recommend {
    private Long id;
    private String animeName;
    private String animeLink;
    private String imgLink;
}
