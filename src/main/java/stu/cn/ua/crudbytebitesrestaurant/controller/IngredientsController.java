package stu.cn.ua.crudbytebitesrestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu.cn.ua.crudbytebitesrestaurant.model.Ingredients;
import stu.cn.ua.crudbytebitesrestaurant.service.IngredientsService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientsController {

    @Autowired
    private IngredientsService ingredientsService;

    // Отримати всі інгредієнти
    @GetMapping
    public List<Ingredients> getAllIngredients() throws SQLException {
        return ingredientsService.getAllIngredients();
    }

    // Додати новий інгредієнт
    @PostMapping
    public String addIngredient(@RequestBody Ingredients ingredient) throws SQLException {
        ingredientsService.addIngredient(ingredient);
        return "Ingredient added successfully";
    }

    // Оновити інгредієнт
    @PutMapping("/{id}")
    public String updateIngredient(@PathVariable int id, @RequestBody Ingredients ingredient) throws SQLException {
        ingredient.setIngredientId(id);
        ingredientsService.updateIngredient(ingredient);
        return "Ingredient updated successfully";
    }

    // Видалити інгредієнт
    @DeleteMapping("/{id}")
    public String deleteIngredient(@PathVariable int id) throws SQLException {
        ingredientsService.deleteIngredient(id);
        return "Ingredient deleted successfully";
    }
}