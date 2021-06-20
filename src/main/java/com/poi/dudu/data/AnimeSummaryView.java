package com.poi.dudu.data;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.sql.Date;

@Data
public class AnimeSummaryView implements HtmlBean {
    @Text
    @HtmlField(cssPath = ".cell_imform_name")
    private String cnName;

    private String jpName;

    private String img;

    //Href(click = true)能够让解析出来的链接直接放入待解析队列
    @Href(click = true)
    @HtmlField(cssPath = ".cell_imform_name")
    private String detailUrl;

    /**
     * 剧情类型
     */
    private String types;

    /**
     * 首播时间
     */
    private Date firstPlayDate;


    /**
     * 放送状态
     */
    private String status;

    /**
     * 制作公司
     */
    private String company;

    /**
     * 原作者
     */
    private String author;


    /**
     * 简介
     */
    private String summary;




}
