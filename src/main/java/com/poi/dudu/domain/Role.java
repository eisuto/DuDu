package com.poi.dudu.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * 角色
 * @author eisuto
 */
@Data
@Entity
@Table(name = "role")
public class Role{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer status;

    @CreationTimestamp
    @Column
    private Date createTime;


}
