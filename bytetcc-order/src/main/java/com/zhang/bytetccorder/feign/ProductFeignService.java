package com.zhang.bytetccorder.feign;

import com.zhang.bytetcccommon.DTO.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "product",path = "/product")
public interface ProductFeignService {

    @GetMapping("/selectOne")
    public ProductDto selectOne(@RequestParam("pid")Integer pid);

    @GetMapping("/updateQuantity")
    public boolean updateQuantity( @RequestParam("pid")Integer pid ,@RequestParam("quantity") Integer quantity);

    @GetMapping("/updateFreeze")
    public boolean updateFreeze( @RequestParam("pid")Integer pid ,@RequestParam("freeze") Integer freeze);

    @GetMapping("/releaseQuantity")
    public boolean releaseQuantity( @RequestParam("pid")Integer pid ,@RequestParam("quantity") Integer quantity);

}
