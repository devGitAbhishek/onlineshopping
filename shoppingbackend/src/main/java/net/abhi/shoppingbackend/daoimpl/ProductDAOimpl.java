package net.abhi.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.abhi.shoppingbackend.dao.ProductDAO;
import net.abhi.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOimpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> list() {
		String selectActiveCategory = "FROM Product";
		@SuppressWarnings("unchecked")
		org.hibernate.query.Query<Product> query =  sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		return query.getResultList();
	}

	@Override
	public Product get(int productId) {
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
	}

	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		try {
			// delete the category in the database table
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product where active = :active";
		@SuppressWarnings("unchecked")
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(selectActiveProducts,Product.class);
		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public List<Product> getlistActiveProductsByCategory(int categoryId) {
		String selectActiveProducts = "FROM Product where active = :active AND categoryId = :categoryId";
		@SuppressWarnings("unchecked")
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(selectActiveProducts,Product.class);
		query.setParameter("active", true).setParameter("categoryId", categoryId);
		return query.getResultList();
	}

	@Override
	public List<Product> getlatestActiveProducts(int count) {
		String selectActiveProducts = "FROM Product where active = :active ORDER BY categoryId";
		@SuppressWarnings("unchecked")
		Query<Product> query = sessionFactory.getCurrentSession().createQuery(selectActiveProducts,Product.class);
		query.setParameter("active", true);
		query.setFirstResult(0);
		query.setMaxResults(count);
		return query.getResultList();
	}

}
