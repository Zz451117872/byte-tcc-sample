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

    @GetMapping("/decreaseQuantity")
    public boolean decreaseQuantity( @RequestParam("pid")Integer pid , @RequestParam("quantity")Integer quantity);

    @GetMapping("/increaseQuantity")
    public boolean increaseQuantity(@RequestParam("pid")Integer pid , @RequestParam("quantity")Integer quantity);

    @GetMapping("/updateQuantity")
    public boolean updateQuantity( @RequestParam("pid")Integer pid ,@RequestParam("quantity") Integer quantity);

    @GetMapping("/decreaseFreeze")
    public boolean decreaseFreeze( @RequestParam("pid")Integer pid , @RequestParam("quantity")Integer quantity);

    @GetMapping("/increaseFreeze")
    public boolean increaseFreeze( @RequestParam("pid")Integer pid ,@RequestParam("quantity") Integer quantity);

    @GetMapping("/updateFreeze")
    public boolean updateFreeze( @RequestParam("pid")Integer pid ,@RequestParam("quantity") Integer quantity);

}
