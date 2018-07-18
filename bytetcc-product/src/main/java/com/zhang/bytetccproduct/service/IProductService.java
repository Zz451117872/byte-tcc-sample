package com.zhang.bytetccproduct.service;

import com.zhang.bytetccproduct.domain.Product;

public interface IProductService {

    public Product selectOne( Integer pid );

    public boolean updateQuantity( Integer pid , Integer amount );

    boolean decreaseFreeze(Integer pid, Integer quantity);

    boolean increaseFreeze(Integer pid, Integer quantity);

    boolean updateFreeze(Integer pid, Integer quantity);

    boolean increaseQuantity(Integer pid, Integer quantity);

    boolean decreaseQuantity(Integer pid, Integer quantity);
}
