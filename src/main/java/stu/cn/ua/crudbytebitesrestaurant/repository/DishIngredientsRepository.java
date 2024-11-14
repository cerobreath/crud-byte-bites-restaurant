package stu.cn.ua.crudbytebitesrestaurant.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stu.cn.ua.crudbytebitesrestaurant.model.DishIngredients;

import javax.sql.DataSource;

@Repository
public class DishIngredientsRepository {

    @Autowired
    private DataSource dataSource;

    // Отримати всі записи
    public List<DishIngredients> findAll() throws SQLException {
        List<DishIngredients> dishIngredientsList = new ArrayList<>();
        String query = "SELECT * FROM Dish_Ingredients";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                DishIngredients dishIngredient = new DishIngredients(
                        resultSet.getInt("dish_id"),
                        resultSet.getInt("ingredient_id"),
                        resultSet.getDouble("amount")
                );
                dishIngredientsList.add(dishIngredient);
            }
        }
        return dishIngredientsList;
    }

    // Додати новий запис
    public void save(DishIngredients dishIngredient) throws SQLException {
        String query = "INSERT INTO Dish_Ingredients (dish_id, ingredient_id, amount) VALUES (?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, dishIngredient.getDishId());
            statement.setInt(2, dishIngredient.getIngredientId());
            statement.setDouble(3, dishIngredient.getAmount());
            statement.executeUpdate();
        }
    }

    // Оновити запис
    public void update(DishIngredients dishIngredient) throws SQLException {
        String query = "UPDATE Dish_Ingredients SET amount=? WHERE dish_id=? AND ingredient_id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, dishIngredient.getAmount());
            statement.setInt(2, dishIngredient.getDishId());
            statement.setInt(3, dishIngredient.getIngredientId());
            statement.executeUpdate();
        }
    }

    // Видалити запис
    public void delete(int dishId, int ingredientId) throws SQLException {
        String query = "DELETE FROM Dish_Ingredients WHERE dish_id=? AND ingredient_id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, dishId);
            statement.setInt(2, ingredientId);
            statement.executeUpdate();
        }
    }
}