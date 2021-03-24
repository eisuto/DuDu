package com.poi.dudu.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author eisuto
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
