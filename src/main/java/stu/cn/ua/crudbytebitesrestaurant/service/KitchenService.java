package stu.cn.ua.crudbytebitesrestaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.cn.ua.crudbytebitesrestaurant.model.Kitchen;
import stu.cn.ua.crudbytebitesrestaurant.repository.KitchenRepository;

import java.util.List;

@Service
public class KitchenService {

    @Autowired
    private KitchenRepository kitchenRepository;

    public List<Kitchen> getAllKitchens() {
        return kitchenRepository.getAllKitchens();
    }

    public void addKitchen(Kitchen kitchen) {
        kitchenRepository.addKitchen(kitchen);
    }

    public void deleteKitchen(int id) {
        kitchenRepository.deleteKitchen(id);
    }
}