package stu.cn.ua.crudbytebitesrestaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.cn.ua.crudbytebitesrestaurant.model.DishIngredients;
import stu.cn.ua.crudbytebitesrestaurant.repository.DishIngredientsRepository;

import java.sql.SQLException;
import java.util.List;

@Service
public class DishIngredientsService {

    @Autowired
    private DishIngredientsRepository dishIngredientsRepository;

    public List<DishIngredients> getAllDishIngredients() throws SQLException {
        return dishIngredientsRepository.findAll();
    }

    public void addDishIngredient(DishIngredients dishIngredient) throws SQLException {
        dishIngredientsRepository.save(dishIngredient);
    }

    public void updateDishIngredient(DishIngredients dishIngredient) throws SQLException {
        dishIngredientsRepository.update(dishIngredient);
    }

    public void deleteDishIngredient(int dishId, int ingredientId) throws SQLException {
        dishIngredientsRepository.delete(dishId, ingredientId);
    }
}