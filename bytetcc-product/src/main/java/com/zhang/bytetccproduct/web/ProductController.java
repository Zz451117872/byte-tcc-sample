package com.zhang.bytetccproduct.web;

import com.zhang.bytetccproduct.dao.ProductDao;
import com.zhang.bytetccproduct.domain.Product;
import com.zhang.bytetccproduct.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/selectOne")
    @ResponseBody
    public Product selectOne( Integer pid ){
        return  productService.selectOne( pid );
    }

    @RequestMapping("/updateQuantity")
    @ResponseBody
    public boolean updateQuantity( Integer pid , Integer quantity ){
        return productService.updateQuantity( pid , quantity);
    }

    @RequestMapping("/decreaseQuantity")
    @ResponseBody
    public boolean decreaseQuantity( Integer pid , Integer quantity ){
        return productService.decreaseQuantity( pid , quantity);
    }

    @RequestMapping("/increaseQuantity")
    @ResponseBody
    public boolean increaseQuantity( Integer pid , Integer quantity ){
        return productService.increaseQuantity( pid , quantity);
    }

    @RequestMapping("/updateFreeze")
    @ResponseBody
    public boolean updateFreeze( Integer pid , Integer quantity ){
        return productService.updateFreeze( pid , quantity);
    }

    @RequestMapping("/decreaseFreeze")
    @ResponseBody
    public boolean decreaseFreeze( Integer pid , Integer quantity ){
        return productService.decreaseFreeze( pid , quantity);
    }

    @RequestMapping("/increaseFreeze")
    @ResponseBody
    public boolean increaseFreeze( Integer pid , Integer quantity ){
        return productService.increaseFreeze( pid , quantity);
    }
}
