package com.zhang.bytetccuser.service.impl;

import com.zhang.bytetccuser.dao.UserDao;
import com.zhang.bytetccuser.domain.User;
import com.zhang.bytetccuser.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userServiceConfirm")
@Transactional
public class UserServiceConfirm implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User selectOne(Integer uid) {
        return userDao.getOne( uid );
    }

    @Override
    public boolean updateAmount(Integer uid, Integer amount) {
        return userDao.confirmUpdateAmount( uid , amount ) > 0 ;
    }

    @Override
    public boolean updateFreeze(Integer uid, Integer freeze) {
        return userDao.confirmUpdateFreeze( uid ,freeze ) > 0 ;
    }


}
