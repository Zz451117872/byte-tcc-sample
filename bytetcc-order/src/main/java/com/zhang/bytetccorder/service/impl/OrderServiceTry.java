package com.zhang.bytetccorder.service.impl;

import com.zhang.bytetcccommon.DTO.ProductDto;
import com.zhang.bytetcccommon.DTO.UserDto;
import com.zhang.bytetccorder.dao.OrderDao;
import com.zhang.bytetccorder.domain.Order;
import com.zhang.bytetccorder.feign.ProductFeignService;
import com.zhang.bytetccorder.feign.UserFeignService;
import com.zhang.bytetccorder.service.IOrderService;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service("orderServiceTry")
@Transactional
public class OrderServiceTry implements IOrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserFeignService userFeignService;

    @Autowired
    private ProductFeignService productFeignService;

    @Override
    public Order createOrder(Integer uid, Integer pid, Integer quantity) {
        /**
         * 1.判断库存
         * 2.预减库存
         */
        ProductDto productDto = productFeignService.selectOne( pid );
        if( productDto.getQuantity() < quantity ){
            throw new RuntimeException("库存不够");
        }
        if( ! productFeignService.updateQuantity( pid , quantity )){
            throw new RuntimeException("预减订单失败");
        }
        return null;
    }

    @Override
    public boolean payOrder(Integer oid) {
        /**
         * 1.判断余额
         * 2.预减余额
         */
        Order order = orderDao.getOne( oid );
        UserDto user = userFeignService.selectOne( order.getUid() );
        if( user.getAmount() < order.getTotalPrice() ){
            throw new RuntimeException("余额不够");
        }
        if( ! userFeignService.updateAmount( order.getUid() , order.getTotalPrice() ) ){
            throw new RuntimeException("预减余额失败");
        }
        return true;
    }

    @Override
    public boolean cancleOrder(Integer oid) {
        /**
         * 1.订单状态判断
         * 2.预释放库存
         */
        Order order = orderDao.getOne( oid );
        if( !"未付款".equals( order.getStatus() )){
            throw new RuntimeException(" 订单状态为：" + order.getStatus()+" 无法取消订单");
        }
        if( !productFeignService.releaseQuantity( order.getPid() , order.getQuantity() )){
            throw new RuntimeException("预释放库存失败");
        }
        return true;
    }

    @Override
    public Order selectOne(Integer oid) {
        return orderDao.getOne( oid );
    }
}
