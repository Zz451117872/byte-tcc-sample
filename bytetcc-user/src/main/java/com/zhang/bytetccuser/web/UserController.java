package com.zhang.bytetccuser.web;

import com.zhang.bytetccuser.domain.User;
import com.zhang.bytetccuser.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/selectOne")
    @ResponseBody
    public User selectOne(Integer uid ){
        return userService.selectOne( uid );
    }

    @RequestMapping("/updateAmount")
    @ResponseBody
    public boolean updateAmount( Integer uid , Integer amount ){
       return userService.updateAmount( uid , amount );
    }

    @RequestMapping("/decreaseAmount")
    @ResponseBody
    public boolean decreaseAmount( Integer uid , Integer amount ){
        return userService.decreaseAmount( uid , amount );
    }

    @RequestMapping("/increaseAmount")
    @ResponseBody
    public boolean increaseAmount( Integer uid , Integer amount ){
        return userService.increaseAmount( uid , amount );
    }


}
