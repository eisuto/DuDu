package com.poi.dudu.data;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Data;

@Data
@Gecco(matchUrl = "https://www.agefans.cc/detail/{id}",pipelines = "animeDetailPipe")
public class AnimeDetailEntry implements HtmlBean {
    private AnimeDetail animeDetail;

    @RequestParameter("id")
    private int id;
}
