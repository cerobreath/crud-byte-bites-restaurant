package stu.cn.ua.crudbytebitesrestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu.cn.ua.crudbytebitesrestaurant.model.Dish;
import stu.cn.ua.crudbytebitesrestaurant.service.DishService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    // Отримати всі страви
    @GetMapping
    public List<Dish> getAllDishes() throws SQLException {
        return dishService.getAllDishes();
    }

    // Додати нову страву
    @PostMapping
    public String addDish(@RequestBody Dish dish) throws SQLException {
        dishService.addDish(dish);
        return "Dish added successfully";
    }

    // Оновити страву
    @PutMapping("/{id}")
    public String updateDish(@PathVariable int id, @RequestBody Dish dish) throws SQLException {
        dish.setDishId(id);
        dishService.updateDish(dish);
        return "Dish updated successfully";
    }

    // Видалити страву
    @DeleteMapping("/{id}")
    public String deleteDish(@PathVariable int id) throws SQLException {
        dishService.deleteDish(id);
        return "Dish deleted successfully";
    }
}