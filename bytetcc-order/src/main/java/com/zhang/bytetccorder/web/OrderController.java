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
    private IOrderService orderService;

    @RequestMapping("selectOne")
    @ResponseBody
    public Order selectOne(Integer oid){
        return orderService.selectOne( oid );
    }

    @RequestMapping("createOrder")
    @ResponseBody
    public Order createOrder( Integer uid , Integer pid , Integer quantity){
        return orderService.createOrder( uid , pid , quantity );
    }

    @RequestMapping("payOrder")
    @ResponseBody
    public boolean payOrder( Integer oid ){
        return orderService.payOrder( oid );
    }

    @RequestMapping("cancleOrder")
    @ResponseBody
    public boolean cancleOrder( Integer oid ){
        return orderService.cancleOrder( oid );
    }
}
