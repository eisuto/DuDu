package com.poi.dudu.base;

import lombok.Data;

/**
 * @author eisuto
 */
@Data
public class Response<T> {
    private Integer code;
    private String msg;
    private T result;

    public Response(Integer code, String msg, T result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public Response(T result) {
        this.code = 0;
        this.msg = "操作成功";
        this.result = result;
    }

}
