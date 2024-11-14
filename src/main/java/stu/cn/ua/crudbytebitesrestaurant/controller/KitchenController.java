package stu.cn.ua.crudbytebitesrestaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu.cn.ua.crudbytebitesrestaurant.model.Kitchen;
import stu.cn.ua.crudbytebitesrestaurant.service.KitchenService;

import java.util.List;

@RestController
@RequestMapping("/kitchens")
public class KitchenController {

    @Autowired
    private KitchenService kitchenService;

    @GetMapping
    public List<Kitchen> getAllKitchens() {
        return kitchenService.getAllKitchens();
    }

    @PostMapping
    public void addKitchen(@RequestBody Kitchen kitchen) {
        kitchenService.addKitchen(kitchen);
    }

    @DeleteMapping("/{id}")
    public void deleteKitchen(@PathVariable int id) {
        kitchenService.deleteKitchen(id);
    }
}