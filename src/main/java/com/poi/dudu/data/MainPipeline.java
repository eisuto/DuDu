package com.poi.dudu.data;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;

import java.util.List;

//注意，这里的PipelineName中的值必须与入口类中的pipelines对应
@PipelineName("mainPipeline")
public class MainPipeline implements Pipeline<AnimeSpiderEntry> {

    @Override
    public void process(AnimeSpiderEntry newsSpiderEntry) {
        HttpRequest request = newsSpiderEntry.getRequest();
        List<AnimeSummaryView> newsSummaryViews = newsSpiderEntry.getAnimeSummaryViews();
        for(AnimeSummaryView newsSummaryView : newsSummaryViews) {
            System.out.println(newsSummaryView);
        }
        //获取下一页url
        int nextPage = Integer.parseInt(newsSpiderEntry.getNextPage()) + 1;
        //将下一页的url加入待解析队列
        String nextPageurl = "https://www.agefans.cc/catalog/all-all-all-all-all-time-" + nextPage;
        SchedulerContext.into(request.subRequest(nextPageurl));
    }
}
