package com.poi.dudu.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author eisuto
 */
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private Integer level;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private Date createTime;
    @Column
    private Date loginTime;
}
