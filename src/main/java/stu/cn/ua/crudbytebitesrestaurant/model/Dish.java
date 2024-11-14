package stu.cn.ua.crudbytebitesrestaurant.model;

public class Dish {
    private int dishId;
    private String name;
    private String description;
    private double price;
    private int kitchenId;

    // Конструктори
    public Dish() {
    }

    public Dish(int dishId, String name, String description, double price, int kitchenId) {
        this.dishId = dishId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.kitchenId = kitchenId;
    }

    // Getters
    public int getDishId() {
        return dishId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getKitchenId() {
        return kitchenId;
    }

    // Setters
    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setKitchenId(int kitchenId) {
        this.kitchenId = kitchenId;
    }

    // Метод toString()
    @Override
    public String toString() {
        return "Dish{" +
                "dishId=" + dishId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", kitchenId=" + kitchenId +
                '}';
    }
}