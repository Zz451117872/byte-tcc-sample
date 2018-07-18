package com.zhang.bytetccproduct.dao;

import com.zhang.bytetccproduct.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product , Integer> {

    @Modifying
    @Query("update product set quantity = quantity - ?2 ,freeze = freeze + ?2 where pid = ?1")
    int decreaseQuantity(Integer pid, Integer quantity);

    @Modifying
    @Query("update product set freeze = freeze - ?2 ,amount = amount + ?2 where pid = ?1")
    int increaseQuantity(Integer pid, Integer quantity);

    @Modifying
    @Query("update product set freeze = freeze - ?2 where pid = ?1")
    int updateQuantity(Integer pid, Integer amount);

    @Modifying
    @Query("update product set freeze = freeze - ?2  where pid = ?1")
    int decreaseFreeze(Integer pid, Integer quantity);

    @Modifying
    @Query("update product set freeze = freeze + ?2  where pid = ?1")
    int increaseFreeze(Integer pid, Integer quantity);

    @Modifying
    @Query("update product set amount = amount + ?2 where pid = ?1")
    int updateFreeze(Integer pid, Integer quantity);
}
