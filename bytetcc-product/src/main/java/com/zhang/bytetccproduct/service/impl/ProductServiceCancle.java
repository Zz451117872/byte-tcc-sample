package com.zhang.bytetccproduct.service.impl;

import com.zhang.bytetccproduct.dao.ProductDao;
import com.zhang.bytetccproduct.domain.Product;
import com.zhang.bytetccproduct.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("productServiceCancle")
public class ProductServiceCancle implements IProductService {

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
        return productDao.cancleUpdateQuantity( pid , quantity ) > 0 ;
    }

    @Override
    @Transactional
    public boolean updateFreeze(Integer pid, Integer freeze) {
        return productDao.cancleUpdateFreeze( pid , freeze ) > 0 ;
    }

    @Override
    @Transactional
    public boolean releaseQuantity(Integer pid, Integer quantity) {
        return productDao.cancleReleaseQuantity( pid , quantity ) > 0 ;
    }
}
