package com.guocoffee.springcloud.dao;

import com.guocoffee.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: springcloud
 * @description: dao层，链接数据库
 * @author: guo-coffee
 * @create: 2020-07-02
 */
@Mapper
public interface PaymentDao {

    Payment getById(@Param("id") long id);

    int save(Payment payment);
}
