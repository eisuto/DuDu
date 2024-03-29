package com.poi.dudu.base;

import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

/**
 * @author eisuto
 */
@Data
public class Response<T> implements Serializable {
    private static final long serialVersionUID = 3886133510113334083L;
    private Integer code;
    private String msg;
    private T data;

    public Response(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Response(T data) {
        this(200, "操作成功", data);
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

    public Response<?> success(T data){
        return new Response<>(data);
    }
}
