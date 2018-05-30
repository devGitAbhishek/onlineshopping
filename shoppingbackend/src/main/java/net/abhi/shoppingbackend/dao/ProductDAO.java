package net.abhi.shoppingbackend.dao;

import java.util.List;

import net.abhi.shoppingbackend.dto.Product;

public interface ProductDAO {

	List<Product> list();
	Product get(int id);
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	//Business methods
	List<Product> listActiveProducts();
	List<Product> getlistActiveProductsByCategory(int categoryId);
	List<Product> getlatestActiveProducts(int count);
}
