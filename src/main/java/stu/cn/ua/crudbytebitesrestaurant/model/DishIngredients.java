package stu.cn.ua.crudbytebitesrestaurant.model;

public class DishIngredients {
    private int dishId;
    private int ingredientId;
    private double amount;

    // Конструктори
    public DishIngredients() {
    }

    public DishIngredients(int dishId, int ingredientId, double amount) {
        this.dishId = dishId;
        this.ingredientId = ingredientId;
        this.amount = amount;
    }

    // Getters
    public int getDishId() {
        return dishId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public double getAmount() {
        return amount;
    }

    // Setters
    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Метод toString()
    @Override
    public String toString() {
        return "DishIngredients{" +
                "dishId=" + dishId +
                ", ingredientId=" + ingredientId +
                ", amount=" + amount +
                '}';
    }
}