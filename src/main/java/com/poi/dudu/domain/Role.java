package com.poi.dudu.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * 角色
 * @author eisuto
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "role")
public class Role extends BaseDomain{

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
