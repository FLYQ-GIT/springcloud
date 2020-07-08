package com.guocoffee.springcloud.dao;

import com.guocoffee.springcloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-08
 */
@Mapper
public interface OrderDao {

    void create(Order order);

    void update(@Param("id") long id,@Param("status") Integer status);
}
