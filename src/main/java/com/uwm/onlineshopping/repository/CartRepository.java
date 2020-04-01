package com.uwm.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uwm.onlineshopping.model.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {

}
