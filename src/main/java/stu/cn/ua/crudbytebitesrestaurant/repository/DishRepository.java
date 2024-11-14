package stu.cn.ua.crudbytebitesrestaurant.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stu.cn.ua.crudbytebitesrestaurant.model.Dish;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DishRepository {

    @Autowired
    private DataSource dataSource;

    // Отримати всі страви
    public List<Dish> findAll() throws SQLException {
        List<Dish> dishes = new ArrayList<>();
        String query = "SELECT * FROM Dish";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Dish dish = new Dish(
                        resultSet.getInt("dish_id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("kitchen_id")
                );
                dishes.add(dish);
            }
        }
        return dishes;
    }

    // Додати нову страву
    public void save(Dish dish) throws SQLException {
        String query = "INSERT INTO Dish (name, description, price, kitchen_id) VALUES (?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, dish.getName());
            statement.setString(2, dish.getDescription());
            statement.setDouble(3, dish.getPrice());
            statement.setInt(4, dish.getKitchenId());
            statement.executeUpdate();
        }
    }

    // Оновити страву
    public void update(Dish dish) throws SQLException {
        String query = "UPDATE Dish SET name=?, description=?, price=?, kitchen_id=? WHERE dish_id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, dish.getName());
            statement.setString(2, dish.getDescription());
            statement.setDouble(3, dish.getPrice());
            statement.setInt(4, dish.getKitchenId());
            statement.setInt(5, dish.getDishId());
            statement.executeUpdate();
        }
    }

    // Видалити страву
    public void delete(int dishId) throws SQLException {
        String query = "DELETE FROM Dish WHERE dish_id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, dishId);
            statement.executeUpdate();
        }
    }
}