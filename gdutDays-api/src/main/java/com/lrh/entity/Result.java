package com.lrh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lrh
 * @description
 * @date 2023/2/14
 */
@Data
@AllArgsConstructor
public class Result {
    private Integer code;
    private Object data;
    private String message;

    public static Result success(Object data){
        return new Result(200,data,"success");
    }

    public static Result fail(Integer code,Object data,String message){
        return new Result(code,data,message);
    }
}
