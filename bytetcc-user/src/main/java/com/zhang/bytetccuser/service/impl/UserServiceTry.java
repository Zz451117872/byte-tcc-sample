package com.zhang.bytetccuser.service.impl;

import com.zhang.bytetccuser.dao.UserDao;
import com.zhang.bytetccuser.domain.User;
import com.zhang.bytetccuser.service.IUserService;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userServiceTry")
@Transactional
public class UserServiceTry implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User selectOne(Integer uid) {
        return userDao.getOne( uid );
    }

    @Override
    public boolean updateAmount(Integer uid, Integer amount) {
        return userDao.tryUpdateAmount( uid , amount ) > 0 ;
    }

    @Override
    public boolean updateFreeze(Integer uid, Integer freeze) {
        return userDao.tryUpdateFreeze( uid , freeze ) > 0;
    }

}
