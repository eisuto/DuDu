package com.poi.dudu.data;

import com.geccocrawler.gecco.annotation.Attr;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.spider.HtmlBean;

public class AnimeDetail implements HtmlBean {
    @Attr("href")
    @HtmlField(cssPath = "res_links_a")
    private String pan;
}
