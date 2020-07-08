package com.guocoffee.springcloud.service.impl;

import com.guocoffee.springcloud.dao.StorageDao;
import com.guocoffee.springcloud.service.IStorageService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: springcloud
 * @description:
 * @author: guo-coffee
 * @create: 2020-07-08
 */
@Service
@Slf4j
public class StorageService implements IStorageService {

//    private static final Logger LOGGER = LoggerFactory.getLogger(StorageService.class);

    @Resource
    private StorageDao storageDao;

    /**
     * 扣减库存
     */
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageDao.decrease(productId,count);
        log.info("------->storage-service中扣减库存结束");
    }
}
