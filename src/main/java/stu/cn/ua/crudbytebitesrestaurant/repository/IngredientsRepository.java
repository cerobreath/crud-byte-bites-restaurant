package stu.cn.ua.crudbytebitesrestaurant.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stu.cn.ua.crudbytebitesrestaurant.model.Ingredients;

import javax.sql.DataSource;

@Repository
public class IngredientsRepository {

    @Autowired
    private DataSource dataSource;

    // Отримати всі інгредієнти
    public List<Ingredients> findAll() throws SQLException {
        List<Ingredients> ingredients = new ArrayList<>();
        String query = "SELECT * FROM Ingredients";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Ingredients ingredient = new Ingredients(
                        resultSet.getInt("ingredient_id"),
                        resultSet.getString("name"),
                        resultSet.getInt("quantity"),
                        resultSet.getString("unit")
                );
                ingredients.add(ingredient);
            }
        }
        return ingredients;
    }

    // Додати новий інгредієнт
    public void save(Ingredients ingredient) throws SQLException {
        String query = "INSERT INTO Ingredients (name, quantity, unit) VALUES (?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, ingredient.getName());
            statement.setInt(2, ingredient.getQuantity());
            statement.setString(3, ingredient.getUnit());
            statement.executeUpdate();
        }
    }

    // Оновити інгредієнт
    public void update(Ingredients ingredient) throws SQLException {
        String query = "UPDATE Ingredients SET name=?, quantity=?, unit=? WHERE ingredient_id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, ingredient.getName());
            statement.setInt(2, ingredient.getQuantity());
            statement.setString(3, ingredient.getUnit());
            statement.setInt(4, ingredient.getIngredientId());
            statement.executeUpdate();
        }
    }

    // Видалити інгредієнт
    public void delete(int ingredientId) throws SQLException {
        String query = "DELETE FROM Ingredients WHERE ingredient_id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, ingredientId);
            statement.executeUpdate();
        }
    }
}