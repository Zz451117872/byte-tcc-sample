package com.zhang.bytetccproduct.service;

import com.zhang.bytetccproduct.domain.Product;

public interface IProductService {

    Product selectOne( Integer pid );

    boolean updateQuantity( Integer pid , Integer amount );

    boolean updateFreeze(Integer pid, Integer freeze);

    boolean releaseQuantity(Integer pid, Integer quantity);

}
