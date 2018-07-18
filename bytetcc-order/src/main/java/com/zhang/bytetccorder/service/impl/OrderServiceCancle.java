package com.zhang.bytetccorder.service.impl;

import com.zhang.bytetcccommon.DTO.UserDto;
import com.zhang.bytetccorder.dao.OrderDao;
import com.zhang.bytetccorder.domain.Order;
import com.zhang.bytetccorder.feign.ProductFeignService;
import com.zhang.bytetccorder.feign.UserFeignService;
import com.zhang.bytetccorder.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderServiceCancle")
public class OrderServiceCancle implements IOrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserFeignService userFeignService;

    @Autowired
    private ProductFeignService productFeignService;

    @Override
    @Transactional
    public Order createOrder(Integer uid, Integer pid, Integer quantity) {
        productFeignService.increaseQuantity( pid , quantity );
        return null;
    }

    @Override
    public boolean payOrder(Integer oid) {
        Order order = orderDao.getOne( oid );
        UserDto user = userFeignService.selectOne( order.getUid() );
        if( ! userFeignService.increaseAmount( order.getUid() , order.getTotalPrice() )){
            throw new RuntimeException("恢复余额失败");
        }
        return true;
    }

    @Override
    public boolean cancleOrder(Integer oid) {
        Order order = orderDao.getOne( oid );
        if( ! productFeignService.increaseFreeze( order.getPid() , order.getQuantity() )){
            throw new RuntimeException("恢复冻结失败");
        }
        return true;
    }

    @Override
    public Order selectOne(Integer oid) {
        return null;
    }
}
