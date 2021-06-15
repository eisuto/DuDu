package com.poi.dudu.base;

import lombok.Data;

/**
 * 基本请求对象
 *
 * @author eisuto
 */
@Data
public class BaseRequest {
    /**
     * 搜索关键字
     */
    private String keyword;
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
