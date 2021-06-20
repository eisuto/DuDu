package com.poi.dudu.data;

import com.geccocrawler.gecco.pipeline.Pipeline;

public class AnimeDetailPipe implements Pipeline<AnimeDetailEntry> {

    @Override
    public void process(AnimeDetailEntry newsDetailEntry) {
        AnimeDetail newsDetail = newsDetailEntry.getAnimeDetail();
        System.out.println(newsDetail);
    }
}
