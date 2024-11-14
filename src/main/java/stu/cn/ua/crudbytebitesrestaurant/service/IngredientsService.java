package stu.cn.ua.crudbytebitesrestaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.cn.ua.crudbytebitesrestaurant.model.Ingredients;
import stu.cn.ua.crudbytebitesrestaurant.repository.IngredientsRepository;

import java.sql.SQLException;
import java.util.List;

@Service
public class IngredientsService {

    @Autowired
    private IngredientsRepository ingredientsRepository;

    public List<Ingredients> getAllIngredients() throws SQLException {
        return ingredientsRepository.findAll();
    }

    public void addIngredient(Ingredients ingredient) throws SQLException {
        ingredientsRepository.save(ingredient);
    }

    public void updateIngredient(Ingredients ingredient) throws SQLException {
        ingredientsRepository.update(ingredient);
    }

    public void deleteIngredient(int ingredientId) throws SQLException {
        ingredientsRepository.delete(ingredientId);
    }
}