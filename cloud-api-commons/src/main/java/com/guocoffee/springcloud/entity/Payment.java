package com.guocoffee.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: springcloud
 * @description: Payment实体类
 * @author: guo-coffee
 * @create: 2020-07-02
 */
@Data
@AllArgsConstructor // 全参
@NoArgsConstructor // 空参
public class Payment implements Serializable {

    private long id;
    private String name;
}
