package com.guocoffee.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: springcloud
 * @description: 用于返回前端通用json
 * @author: guo-coffee
 * @create: 2020-07-02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String msg;
    private T data;

    /**
     * 提供一个无返回 实体的构造器
     * @param code
     * @param msg
     */
    public CommonResult(Integer code, String msg) {
        // 调用全参构造器
        this(code,msg,null);
    }
}
