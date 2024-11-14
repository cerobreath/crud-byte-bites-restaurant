package stu.cn.ua.crudbytebitesrestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu.cn.ua.crudbytebitesrestaurant.model.DishIngredients;
import stu.cn.ua.crudbytebitesrestaurant.service.DishIngredientsService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/dish-ingredients")
public class DishIngredientsController {

    @Autowired
    private DishIngredientsService dishIngredientsService;

    // Отримати всі записи
    @GetMapping
    public List<DishIngredients> getAllDishIngredients() throws SQLException {
        return dishIngredientsService.getAllDishIngredients();
    }

    // Додати новий запис
    @PostMapping
    public String addDishIngredient(@RequestBody DishIngredients dishIngredient) throws SQLException {
        dishIngredientsService.addDishIngredient(dishIngredient);
        return "Dish ingredient added successfully";
    }

    // Оновити запис
    @PutMapping("/{dishId}/{ingredientId}")
    public String updateDishIngredient(
            @PathVariable int dishId,
            @PathVariable int ingredientId,
            @RequestBody DishIngredients dishIngredient) throws SQLException {
        dishIngredient.setDishId(dishId);
        dishIngredient.setIngredientId(ingredientId);
        dishIngredientsService.updateDishIngredient(dishIngredient);
        return "Dish ingredient updated successfully";
    }

    // Видалити запис
    @DeleteMapping("/{dishId}/{ingredientId}")
    public String deleteDishIngredient(@PathVariable int dishId, @PathVariable int ingredientId) throws SQLException {
        dishIngredientsService.deleteDishIngredient(dishId, ingredientId);
        return "Dish ingredient deleted successfully";
    }
}