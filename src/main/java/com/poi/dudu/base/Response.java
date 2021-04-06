package com.poi.dudu.base;

import lombok.Data;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @author eisuto
 */
@Data
public class Response<T> {
    private Integer code;
    private String msg;
    private T data;

    public Response(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Response(T data) {
        this(0, "操作成功", data);
    }

    public Response() {
        this(null);
    }

    /**
     * 操作失败时
     */
    public void fail(){
        this.code = 400;
        this.msg = "操作失败";
    }

}
