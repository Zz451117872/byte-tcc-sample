package com.zhang.bytetccuser.web;

import com.zhang.bytetcccommon.DTO.UserDto;
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
    private IUserService userServiceTry;

    @Autowired
    private IUserService userServiceConfirm;

    @Autowired
    private IUserService userServiceCancle;

    @RequestMapping("/selectOne")
    @ResponseBody
    public UserDto selectOne(Integer uid ){
        User user =  userServiceTry.selectOne( uid );
        if( user != null ){
            UserDto userDto = new UserDto();
            userDto.setAmount( user.getAmount() );
            userDto.setFreeze( user.getFreeze() );
            userDto.setName( user.getName() );
            userDto.setPassword( user.getPassword() );
            userDto.setUid( user.getUid() );
            userDto.setVersion( user.getVersion() );
            return userDto;
        }
        return null;
    }

    @RequestMapping("/updateAmount")
    @ResponseBody
    public boolean updateAmount( Integer uid , Integer amount ){

        try{
            if( userServiceTry.updateAmount( uid , amount )){
                return userServiceConfirm.updateAmount( uid ,amount );
            }
        }catch (Exception e){
            userServiceCancle.updateAmount( uid , amount );
        }
       return false;
    }

    @RequestMapping("/updateFreeze")
    @ResponseBody
    public boolean updateFreeze( Integer uid , Integer freeze ){
        try{
            if( userServiceTry.updateFreeze( uid , freeze )){
                return userServiceConfirm.updateFreeze( uid , freeze );
            }
        }catch (Exception e){
            userServiceCancle.updateFreeze( uid , freeze );
        }
        return false;
    }


}
