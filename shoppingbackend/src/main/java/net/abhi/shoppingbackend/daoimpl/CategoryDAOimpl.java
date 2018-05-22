package net.abhi.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.abhi.shoppingbackend.dao.CategoryDAO;
import net.abhi.shoppingbackend.dto.Category;

@Repository("cat")	
public class CategoryDAOimpl implements CategoryDAO {


private static List<Category> categories = new ArrayList<Category>();
	
	public CategoryDAOimpl() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		
		Category category = new Category();
		
		// 1ST category to is done
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is about Television");
		category.setImgUrl("CAT_1.png");
		categories.add(category);
		
		// 2nd category to is done
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is about Mobiles");
		category.setImgUrl("CAT_2.png");
		categories.add(category);
		// 3rd category to is done
		category = new Category();
		category.setId(3);
		category.setName("Referigerator");
		category.setDescription("This is about Referigerator");
		category.setImgUrl("CAT_3.png");
		categories.add(category);
		
	}
	
	@Override
	public List<Category> list() {
		return categories;
	}

	@Override
	public Category get(int id) {
		
		//for each loop to match the category id for product we want with number of products
		
		for(Category category : categories) {
			if(category.getId() == id) {
				return category;
			}
		}
		
		return null;
	}
}
