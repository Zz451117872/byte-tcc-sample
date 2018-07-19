package com.zhang.bytetccuser.service;

import com.zhang.bytetccuser.domain.User;

public interface IUserService {

    public User selectOne(Integer uid);

    public boolean updateAmount( Integer uid , Integer amount);

    public boolean updateFreeze( Integer uid , Integer freeze);
}
