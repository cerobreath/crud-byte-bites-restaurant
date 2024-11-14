package stu.cn.ua.crudbytebitesrestaurant.model;

public class Ingredients {
    private int ingredientId;
    private String name;
    private int quantity;
    private String unit;

    // Конструктори
    public Ingredients() {
    }

    public Ingredients(int ingredientId, String name, int quantity, String unit) {
        this.ingredientId = ingredientId;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    // Getters
    public int getIngredientId() {
        return ingredientId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    // Setters
    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    // Метод toString()
    @Override
    public String toString() {
        return "Ingredients{" +
                "ingredientId=" + ingredientId +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}