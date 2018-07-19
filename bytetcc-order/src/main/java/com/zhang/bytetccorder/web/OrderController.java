package com.zhang.bytetccorder.web;

import com.zhang.bytetccorder.domain.Order;
import com.zhang.bytetccorder.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderServiceTry;

    @Autowired
    private IOrderService orderServiceConfirm;

    @Autowired
    private IOrderService orderServiceCancle;

    @RequestMapping("selectOne")
    @ResponseBody
    public Object selectOne(Integer oid){
        Order order =  orderServiceTry.selectOne( oid );
        if( order != null ){
            return order;
        }
        return 1;
    }

    @RequestMapping("createOrder")
    @ResponseBody
    public Order createOrder( Integer uid , Integer pid , Integer quantity){
        try{
            try{
                orderServiceTry.createOrder( uid , pid , quantity );
            }catch (Exception e){
                return null;
            }
            return orderServiceConfirm.createOrder( uid ,pid , quantity );
        }catch (Exception e2){
            orderServiceCancle.createOrder( uid , pid , quantity );
        }
        return null;
    }

    @RequestMapping("payOrder")
    @ResponseBody
    public boolean payOrder( Integer oid ){
        try{
            if( orderServiceTry.payOrder( oid )){
                return orderServiceConfirm.payOrder( oid );
            }
        }catch (Exception e){
            orderServiceCancle.payOrder( oid );
        }
        return false;
    }

    @RequestMapping("cancleOrder")
    @ResponseBody
    public boolean cancleOrder( Integer oid ){
        try{
            if( orderServiceTry.cancleOrder( oid )){
                return orderServiceConfirm.cancleOrder( oid );
            }
        }catch (Exception e){
            orderServiceCancle.cancleOrder( oid );
        }
        return false;
    }
}
