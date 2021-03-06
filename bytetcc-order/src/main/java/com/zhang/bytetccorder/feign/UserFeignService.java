package com.zhang.bytetccorder.feign;

import com.zhang.bytetcccommon.DTO.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "user" , path = "/user")
public interface UserFeignService {

    @GetMapping("/selectOne")
    public UserDto selectOne(@RequestParam("uid")Integer uid);

    @GetMapping("/updateAmount")
    public boolean updateAmount( @RequestParam("uid")Integer uid, @RequestParam("amount")Integer amount);

    @GetMapping("/updateFreeze")
    public boolean updateFreeze( @RequestParam("uid")Integer uid, @RequestParam("freeze")Integer freeze);
}
