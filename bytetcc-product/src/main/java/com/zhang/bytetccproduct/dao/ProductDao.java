package com.zhang.bytetccproduct.dao;

import com.zhang.bytetccproduct.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product , Integer> {


    @Modifying
    @Query("update product set freeze = freeze + ?2 ,quantity = quantity - ?2 where pid = ?1")
    int tryUpdateQuantity(Integer pid, Integer quantity);

    @Modifying
    @Query("update product set freeze = freeze - ?2  where pid = ?1")
    int confirmUpdateQuantity(Integer pid, Integer quantity);

    @Modifying
    @Query("update product set freeze = freeze - ?2 ,quantity = quantity + ?2 where pid = ?1")
    int cancleUpdateQuantity(Integer pid, Integer quantity);




    @Modifying
    @Query("update product set quantity = quantity + ?2 ,freeze = freeze - ?2 where pid = ?1")
    int tryUpdateFreeze(Integer pid, Integer freeze);

    @Modifying
    @Query("update product set quantity = quantity - ?2 where pid = ?1")
    int confirmUpdateFreeze(Integer pid, Integer freeze);

    @Modifying
    @Query("update product set quantity = quantity - ?2 ,freeze = freeze + ?2 where pid = ?1")
    int cancleUpdateFreeze(Integer pid, Integer freeze);




    @Modifying
    @Query("update  product set freeze = freeze + ?2 where pid = ?1")
    int tryReleaseQuantity( Integer pid , Integer quantity );

    @Modifying
    @Query("update  product set freeze = freeze - ?2 ,quantity = quantity + ?2 where pid = ?1")
    int confirmReleaseQuantity( Integer pid , Integer quantity);

    @Modifying
    @Query("update  product set freeze = freeze - ?2 where pid = ?1")
    int cancleReleaseQuantity( Integer pid , Integer quantity );


}
