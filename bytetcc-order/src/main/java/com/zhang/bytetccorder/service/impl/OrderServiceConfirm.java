package com.zhang.bytetccorder.service.impl;

import com.zhang.bytetcccommon.DTO.ProductDto;
import com.zhang.bytetcccommon.DTO.UserDto;
import com.zhang.bytetccorder.dao.OrderDao;
import com.zhang.bytetccorder.domain.Order;
import com.zhang.bytetccorder.feign.ProductFeignService;
import com.zhang.bytetccorder.feign.UserFeignService;
import com.zhang.bytetccorder.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service("orderServiceConfirm")
@Transactional
public class OrderServiceConfirm implements IOrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserFeignService userFeignService;

    @Autowired
    private ProductFeignService productFeignService;

    @Override
    public Order createOrder(Integer uid, Integer pid, Integer quantity) {

        ProductDto productDto = productFeignService.selectOne( pid );

        Order order = new Order();
        order.setPid( pid );
        order.setPrice( productDto.getPrice() );
        order.setQuantity( quantity );
        order.setStatus( "未付款");
        order.setTotalPrice( productDto.getPrice() * quantity );
        order.setUid( uid );
        order.setVersion( new Date().getTime() );

        orderDao.save( order );
        return order;
    }

    @Override
    public boolean payOrder(Integer oid) {

        Order order = orderDao.getOne( oid );
        order.setStatus( "已支付");
        order.setVersion( new Date().getTime() );
        orderDao.save( order );
        return true;
    }

    @Override
    public boolean cancleOrder(Integer oid) {
        Order order = orderDao.getOne( oid );
        order.setStatus( "已取消");
        order.setVersion( new Date().getTime() );
        orderDao.save( order );
        return true;
    }

    @Override
    public Order selectOne(Integer oid) {
        return orderDao.getOne( oid );
    }
}
