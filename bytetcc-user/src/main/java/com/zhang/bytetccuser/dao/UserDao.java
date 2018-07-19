package com.zhang.bytetccuser.dao;

import com.zhang.bytetccuser.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    @Modifying
    @Query("update user set amount = amount - ?2 , freeze = freeze + ?2 where uid = ?1")
    int tryUpdateAmount( Integer uid , Integer amount);

    @Modifying
    @Query("update user set freeze = freeze - ?2 where uid = ?1")
    int confirmUpdateAmount( Integer uid , Integer amount );

    @Modifying
    @Query("update user set amount = amount + ?2 , freeze = freeze - ?2 where uid = ?1")
    int cancleUpdateAmount( Integer uid , Integer amount );



    @Modifying
    @Query("update user set freeze = freeze - ?2 , amount = amount + ?2 where uid = ?1")
    int tryUpdateFreeze( Integer uid , Integer freeze);

    @Modifying
    @Query("update user set amount = amount - ?2 where uid = ?1")
    int confirmUpdateFreeze( Integer uid , Integer freeze );

    @Modifying
    @Query("update user set freeze = freeze + ?2 , amount = amount - ?2 where uid = ?1")
    int cancleUpdateFreeze( Integer uid , Integer freeze );
}
