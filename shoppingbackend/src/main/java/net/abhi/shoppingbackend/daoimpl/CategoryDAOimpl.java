package net.abhi.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.abhi.shoppingbackend.dao.CategoryDAO;
import net.abhi.shoppingbackend.dto.Category;
@Repository("cat")
@Transactional
public class CategoryDAOimpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;


	public CategoryDAOimpl() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings({"unchecked" })
	@Override
	public List<Category> list() {
		String selectActiveCategory = "FROM Category where active= :active";
		org.hibernate.query.Query<Category> query =  sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}

	/**
	 * Returning single category
	 */
	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}
 
	/**
	 * Adding single category
	 */
	@Override
	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;	
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
    
	/**
	 * update single category
	 */
	@Override
	public boolean update(Category category) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/**
	 * Delete single category
	 */
	@Override
	public boolean delete(Category category) {
		category.setActive(false);

		try {
			// delete the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}

