package com.poi.dudu.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 动画
 * @author eisuto
 */
@Data
@Entity
@Table(name = "anime")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Anime {
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 名称 中文
     */
    @Column
    private String nameChinese;

    /**
     * 名称 日文
     */
    @Column
    private String nameJapanese;

    /**
     * 图片路径
     */
    @Column
    private String imgPath;

    /**
     * 类型 - 多对多
     */

    @ManyToMany(targetEntity = Type.class, cascade = CascadeType.ALL)
    @JoinTable(name = "anime_type",
            joinColumns = {@JoinColumn(name = "anime_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "type_id", referencedColumnName = "id")}
    )
    private Set<Type> types;

    /**
     * 首播时间
     */
    @Column
    private Date firstPlayDate;


    /**
     * 放送状态
     */
    @Column
    private String status;

    /**
     * 制作公司
     */
    @Column
    private String company;

    /**
     * 原作者
     */
    private String author;


    /**
     * 简介
     */
    @Lob
    @Column(columnDefinition="text")
    private String summary;

}
