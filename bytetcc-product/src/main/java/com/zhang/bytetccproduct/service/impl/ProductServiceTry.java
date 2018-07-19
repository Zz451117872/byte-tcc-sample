package com.zhang.bytetccproduct.service.impl;

import com.zhang.bytetccproduct.dao.ProductDao;
import com.zhang.bytetccproduct.domain.Product;
import com.zhang.bytetccproduct.service.IProductService;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("productServiceTry")
public class ProductServiceTry implements IProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional
    public Product selectOne(Integer pid) {
        return productDao.getOne( pid );
    }

    @Override
    @Transactional
    public boolean updateQuantity(Integer pid, Integer quantity) {
        return productDao.tryUpdateQuantity( pid , quantity ) > 0;
    }


    @Override
    @Transactional
    public boolean updateFreeze(Integer pid, Integer freeze) {
        return productDao.tryUpdateFreeze( pid , freeze ) > 0 ;
    }

    @Override
    @Transactional
    public boolean releaseQuantity(Integer pid, Integer quantity) {
        return productDao.tryReleaseQuantity( pid , quantity ) > 0 ;
    }
}
