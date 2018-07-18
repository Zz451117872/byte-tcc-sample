package com.zhang.bytetccorder.service;

import com.zhang.bytetccorder.domain.Order;

public interface IOrderService {

    public Order createOrder(Integer uid , Integer pid , Integer quantity);

    public boolean payOrder( Integer oid);

    public boolean cancleOrder( Integer oid);

    public Order selectOne( Integer oid);
}
