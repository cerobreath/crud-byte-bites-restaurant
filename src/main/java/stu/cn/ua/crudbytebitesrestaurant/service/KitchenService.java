package stu.cn.ua.crudbytebitesrestaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.cn.ua.crudbytebitesrestaurant.model.Kitchen;
import stu.cn.ua.crudbytebitesrestaurant.repository.KitchenRepository;

import java.util.List;
import java.util.Optional;

@Service
public class KitchenService {

    @Autowired
    private KitchenRepository kitchenRepository;

    // Отримати всі кухні
    public List<Kitchen> getAllKitchens() {
        return kitchenRepository.getAllKitchens();
    }

    // Додати нову кухню
    public void addKitchen(Kitchen kitchen) {
        kitchenRepository.addKitchen(kitchen);
    }

    // Оновити існуючу кухню
    public void updateKitchen(Kitchen kitchen) {
        if (kitchenRepository.existsById(kitchen.getKitchenId())) {
            kitchenRepository.updateKitchen(kitchen);
        } else {
            throw new RuntimeException("Kitchen with ID " + kitchen.getKitchenId() + " not found");
        }
    }

    // Видалити кухню за ID
    public void deleteKitchen(int id) {
        if (kitchenRepository.existsById(id)) {
            kitchenRepository.deleteKitchen(id);
        } else {
            throw new RuntimeException("Kitchen with ID " + id + " not found");
        }
    }
}
