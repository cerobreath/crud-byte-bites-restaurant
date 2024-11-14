package stu.cn.ua.crudbytebitesrestaurant.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import stu.cn.ua.crudbytebitesrestaurant.model.Kitchen;

import java.util.List;

@Repository
public class KitchenRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Kitchen> getAllKitchens() {
        String sql = "SELECT * FROM kitchen";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Kitchen(rs.getInt("kitchen_id"), rs.getString("name"),
                        rs.getString("location"), rs.getInt("capacity")));
    }

    public int addKitchen(Kitchen kitchen) {
        String sql = "INSERT INTO kitchen (name, location, capacity) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, kitchen.getName(), kitchen.getLocation(), kitchen.getCapacity());
    }

    public int deleteKitchen(int id) {
        String sql = "DELETE FROM kitchen WHERE kitchen_id = ?";
        return jdbcTemplate.update(sql, id);
    }
}