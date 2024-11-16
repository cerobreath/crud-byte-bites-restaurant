package stu.cn.ua.crudbytebitesrestaurant.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import stu.cn.ua.crudbytebitesrestaurant.model.Kitchen;

import java.util.List;
import java.util.Optional;

@Repository
public class KitchenRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Отримати всі кухні
    public List<Kitchen> getAllKitchens() {
        String sql = "SELECT * FROM kitchen";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Kitchen(rs.getInt("kitchen_id"), rs.getString("name"),
                        rs.getString("location"), rs.getInt("capacity")));
    }

    // Додати нову кухню
    public int addKitchen(Kitchen kitchen) {
        String sql = "INSERT INTO kitchen (name, location, capacity) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, kitchen.getName(), kitchen.getLocation(), kitchen.getCapacity());
    }

    // Оновити існуючу кухню
    public int updateKitchen(Kitchen kitchen) {
        String sql = "UPDATE kitchen SET name = ?, location = ?, capacity = ? WHERE kitchen_id = ?";
        return jdbcTemplate.update(sql, kitchen.getName(), kitchen.getLocation(), kitchen.getCapacity(), kitchen.getKitchenId());
    }

    // Видалити кухню за ID
    public int deleteKitchen(int id) {
        String sql = "DELETE FROM kitchen WHERE kitchen_id = ?";
        return jdbcTemplate.update(sql, id);
    }

    // Перевірити наявність кухні за ID
    public boolean existsById(int id) {
        String sql = "SELECT COUNT(*) FROM kitchen WHERE kitchen_id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }
}
