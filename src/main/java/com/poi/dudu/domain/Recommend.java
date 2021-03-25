package com.poi.dudu.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 首页推荐
 * @author eisuto
 */
@Data
@Entity
@Table(name = "recommend")
public class Recommend {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String animeName;
    @Column
    private String animeLink;
    @Column
    private String imgLink;
}
