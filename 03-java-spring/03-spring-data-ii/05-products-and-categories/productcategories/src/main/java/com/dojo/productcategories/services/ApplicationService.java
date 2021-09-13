package com.dojo.productcategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dojo.productcategories.models.Connection;
import com.dojo.productcategories.models.Category;
import com.dojo.productcategories.models.Product;
import com.dojo.productcategories.repositories.ConnectionRepoistory;
import com.dojo.productcategories.repositories.CategoryRepository;
import com.dojo.productcategories.repositories.ProductRepository;


@Service
public class ApplicationService {
	private final ProductRepository pRepo;
	private final CategoryRepository cRepo;
	private final ConnectionRepoistory aRepo;
	public ApplicationService(ProductRepository pRepo, CategoryRepository cRepo, ConnectionRepoistory aRepo) {
		this.pRepo = pRepo;
		this.cRepo = cRepo;
		this.aRepo = aRepo;
	}
	public List<Product> findProducts() {
		return this.pRepo.findAll();
	}
	public Product getProduct(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	public List<Category> findCategories() {
		return this.cRepo.findAll();
	}
	public Product createProduct(Product product) {
		return this.pRepo.save(product);
	}
	public Connection createConnection(Connection connect) {
		return this.aRepo.save(connect);
	}
	public List<Category> findCategoriesNotInProduct(Product product) {
		return cRepo.findByProductsNotContains(product);
	}
	public List<Product> findProductsNotInCategory(Category category) {
		return pRepo.findByCategoriesNotContains(category);
	}

}
