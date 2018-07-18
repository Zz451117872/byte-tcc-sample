package com.zhang.bytetccuser.service.impl;

import com.zhang.bytetccuser.dao.UserDao;
import com.zhang.bytetccuser.domain.User;
import com.zhang.bytetccuser.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userServiceConfirm")
public class UserServiceConfirm implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User selectOne(Integer uid) {
        return null;
    }

    @Override
    public boolean updateAmount(Integer uid, Integer amount) {
        return false;
    }

    @Override
    public boolean decreaseAmount(Integer uid, Integer amount) {
        return false;
    }

    @Override
    public boolean increaseAmount(Integer uid, Integer amount) {
        return false;
    }
}
