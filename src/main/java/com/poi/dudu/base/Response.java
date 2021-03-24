package com.poi.dudu.base;

import lombok.Data;

/**
 * @author eisuto
 */
@Data
public class Response<T> {
    private Integer code;
    private T result;

    public Response(Integer code, T result) {
        this.code = code;
        this.result = result;
    }

}
