package com.uwm.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uwm.onlineshopping.model.CategoryEntity;

// This classs extends JpaReposigory
// helps to support crude function 

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
