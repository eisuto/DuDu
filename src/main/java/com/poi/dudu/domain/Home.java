package com.poi.dudu.domain;

import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import java.util.List;

/**
 * 首页数据
 *
 * @author eisut
 */
@Data
public class Home {
    /**
     * 推荐动画列表
     */
    public List<Anime> recommendList;

    /**
     * 周放送列表
     */
    public List<List<Anime>> liveList;


    /**
     * 排行榜
     */
    public List<Anime> leaderboard;
}
