package com.foodproject.menu;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Integer> {
	List<Menu> findByFoodFoodId(Integer id);
	List<Menu> findByRestaurantRestaurantId(Integer id);
}
