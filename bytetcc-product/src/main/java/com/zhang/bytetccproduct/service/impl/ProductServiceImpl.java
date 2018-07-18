package com.zhang.bytetccproduct.service.impl;

import com.zhang.bytetccproduct.dao.ProductDao;
import com.zhang.bytetccproduct.domain.Product;
import com.zhang.bytetccproduct.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product selectOne(Integer pid) {
        return productDao.getOne( pid );
    }

    @Override
    public boolean updateQuantity(Integer pid, Integer amount) {
        return productDao.updateQuantity(pid, amount) > 0;
    }

    @Override
    public boolean increaseQuantity(Integer pid, Integer quantity) {
        return productDao.increaseQuantity( pid,  quantity) > 0;
    }

    @Override
    public boolean decreaseQuantity(Integer pid, Integer quantity) {
        return productDao.decreaseQuantity(pid, quantity) > 0;
    }

    @Override
    public boolean decreaseFreeze(Integer pid, Integer quantity) {
        return productDao.decreaseFreeze(pid, quantity) > 0;
    }

    @Override
    public boolean increaseFreeze(Integer pid, Integer quantity) {
        return productDao.increaseFreeze(pid, quantity) > 0;
    }

    @Override
    public boolean updateFreeze(Integer pid, Integer quantity) {
        return productDao.updateFreeze(pid, quantity) > 0;
    }


}
