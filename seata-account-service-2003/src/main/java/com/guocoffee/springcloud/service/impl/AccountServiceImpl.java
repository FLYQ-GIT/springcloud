package com.guocoffee.springcloud.service.impl;

import com.guocoffee.springcloud.dao.AccountDao;
import com.guocoffee.springcloud.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-08
 */
@Service
@Slf4j
public class AccountServiceImpl implements IAccountService {

    @Resource
    AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");
        // 模拟超时异常，全局事务回滚
        try { TimeUnit.SECONDS.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
        accountDao.decrease(userId,money);
        log.info("------->account-service中扣减账户余额结束");
    }
}
