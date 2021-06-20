package com.poi.dudu.data;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Data;

import java.util.List;

@Data
@Gecco(matchUrl = "https://www.agefans.cc/catalog/all-all-all-all-all-time-{page}", pipelines = {"mainPipeline", "animeDetailPipe"})
public class AnimeSpiderEntry implements HtmlBean {
    @Request
    private HttpRequest request;

    @HtmlField(cssPath = ".blockcontent1")
    private List<AnimeSummaryView> animeSummaryViews;

    @Text
    @HtmlField(cssPath = ".pbutton asciifont > a")
    private String nextPage;

    public static void main(String[] args) {
        GeccoEngine.create()
                .classpath("com.poi.dudu.data")
                .start("https://www.agefans.cc/catalog/all-all-all-all-all-time-1")
                .thread(5)
                .interval(500)
                .start();
    }
}
