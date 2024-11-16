package stu.cn.ua.crudbytebitesrestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu.cn.ua.crudbytebitesrestaurant.model.Kitchen;
import stu.cn.ua.crudbytebitesrestaurant.service.KitchenService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/kitchens")
public class KitchenController {

    @Autowired
    private KitchenService kitchenService;

    // Отримати всі кухні
    @GetMapping
    public List<Kitchen> getAllKitchens() throws SQLException {
        return kitchenService.getAllKitchens();
    }

    // Додати нову кухню
    @PostMapping
    public String addKitchen(@RequestBody Kitchen kitchen) throws SQLException {
        kitchenService.addKitchen(kitchen);
        return "Kitchen added successfully";
    }

    // Оновити кухню
    @PutMapping("/{id}")
    public String updateKitchen(@PathVariable int id, @RequestBody Kitchen kitchen) throws SQLException {
        kitchen.setKitchenId(id);
        kitchenService.updateKitchen(kitchen);
        return "Kitchen updated successfully";
    }

    // Видалити кухню
    @DeleteMapping("/{id}")
    public String deleteKitchen(@PathVariable int id) throws SQLException {
        kitchenService.deleteKitchen(id);
        return "Kitchen deleted successfully";
    }
}
