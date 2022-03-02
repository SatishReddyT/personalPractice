package com.bhavna.order.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhavna.order.api.model.Category;

public interface CategoryRepository extends JpaRepository<Category, String>{

}
