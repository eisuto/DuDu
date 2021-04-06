package com.poi.dudu.base;

import lombok.Data;

/**
 * 分页对象
 *
 * @author eisuto
 */
@Data
public class PageBase {
    /**
     * 当前页数
     */
    private Integer number;
    /**
     * 页大小
     */
    private Integer size;
    /**
     * 总页数
     */
    private Integer totalPages;
}
