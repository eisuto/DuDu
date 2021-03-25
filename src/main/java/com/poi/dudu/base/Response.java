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
    private T result;

    public Response(Integer code, String msg, T result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public Response(T result) {
        this(0, "操作成功", result);
    }

    public Response() {
        this(null);
    }

    /**
     * 操作失败时
     */
    public void fail(){
        this.code = -1;
        this.msg = "操作失败";
    }

}
