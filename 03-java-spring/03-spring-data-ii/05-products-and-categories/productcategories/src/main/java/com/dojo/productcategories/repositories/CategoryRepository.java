package com.dojo.productcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojo.productcategories.models.Category;
import com.dojo.productcategories.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	List<Category> findByProductsNotContains(Product product);

}
