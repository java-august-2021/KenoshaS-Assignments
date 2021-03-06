package com.dojo.productcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojo.productcategories.models.Category;
import com.dojo.productcategories.models.Product;


public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);

}
