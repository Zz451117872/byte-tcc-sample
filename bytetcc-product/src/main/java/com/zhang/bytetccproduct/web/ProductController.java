package com.zhang.bytetccproduct.web;

import com.zhang.bytetcccommon.DTO.ProductDto;
import com.zhang.bytetccproduct.dao.ProductDao;
import com.zhang.bytetccproduct.domain.Product;
import com.zhang.bytetccproduct.service.IProductService;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productServiceTry;

    @Autowired
    private IProductService productServiceConfirm;

    @Autowired
    private IProductService productServiceCancle;

    @RequestMapping("/selectOne")
    @ResponseBody
    public ProductDto selectOne(Integer pid ){
        Product product =  productServiceTry.selectOne( pid );
        if( product != null ){
            ProductDto productDto = new ProductDto();
            productDto.setFreeze( product.getFreeze() );
            productDto.setName( product.getName() );
            productDto.setPid( product.getPid() );
            productDto.setPrice( product.getPrice() );
            productDto.setQuantity( product.getQuantity() );
            productDto.setVersion( product.getVersion() );
            return productDto;
        }
        return null;
    }

    @RequestMapping("/updateQuantity")
    @ResponseBody
    public boolean updateQuantity( Integer pid , Integer quantity ){
        try{
            if( productServiceTry.updateQuantity( pid , quantity)){
                 return productServiceConfirm.updateQuantity( pid ,quantity );
            }
        }catch (Exception e){
            productServiceCancle.updateQuantity( pid , quantity );
        }
        return false;
    }

    @RequestMapping("/updateFreeze")
    @ResponseBody
    public boolean updateFreeze( Integer pid , Integer freeze ){
        try{
            if( productServiceTry.updateQuantity( pid , freeze )){
                return productServiceConfirm.updateQuantity( pid ,freeze );
            }
        }catch (Exception e){
            productServiceCancle.updateQuantity( pid , freeze );
        }
        return false;
    }

    @RequestMapping("/releaseQuantity")
    @ResponseBody
    public boolean releaseQuantity( Integer pid , Integer quantity ){
        try{
            if( productServiceTry.releaseQuantity( pid , quantity )){
                return productServiceConfirm.releaseQuantity( pid , quantity );
            }
        }catch (Exception e){
            productServiceCancle.releaseQuantity( pid , quantity );
        }
        return false;
    }


}
