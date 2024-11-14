package stu.cn.ua.crudbytebitesrestaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.cn.ua.crudbytebitesrestaurant.model.Dish;
import stu.cn.ua.crudbytebitesrestaurant.repository.DishRepository;

import java.sql.SQLException;
import java.util.List;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    public List<Dish> getAllDishes() throws SQLException {
        return dishRepository.findAll();
    }

    public void addDish(Dish dish) throws SQLException {
        dishRepository.save(dish);
    }

    public void updateDish(Dish dish) throws SQLException {
        dishRepository.update(dish);
    }

    public void deleteDish(int dishId) throws SQLException {
        dishRepository.delete(dishId);
    }
}