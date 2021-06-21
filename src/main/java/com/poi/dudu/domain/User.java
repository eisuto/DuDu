package com.poi.dudu.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @author eisuto
 */
@Data
@Entity
@Table(name = "user")
public class User {
    @TableGenerator(
            name = "plusOne",
            initialValue = 10000,
            allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "plusOne")
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
    private String avatar;

    @CreationTimestamp
    @Column
    private Date createTime;

    @UpdateTimestamp
    @Column
    private Date loginTime;

    private String verifyCode;
}
