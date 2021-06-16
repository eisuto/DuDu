package com.poi.dudu.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 动画类型
 */
@Data
@Entity
@Table(name = "type")
public class Type {
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 类型名称
     */
    @Column
    private String name;

    /**
     * 动画 - 多对多
     */
    @ManyToMany(mappedBy = "types")  //配置多表关系
    private Set<Anime> animes = new HashSet<>();
}
