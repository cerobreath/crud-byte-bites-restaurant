package stu.cn.ua.crudbytebitesrestaurant.model;

public class Kitchen {
    private int kitchenId;
    private String name;
    private String location;
    private int capacity;

    // Конструктори
    public Kitchen() {
    }

    public Kitchen(int kitchenId, String name, String location, int capacity) {
        this.kitchenId = kitchenId;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
    }

    // Геттери
    public int getKitchenId() {
        return kitchenId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    // Сеттери
    public void setKitchenId(int kitchenId) {
        this.kitchenId = kitchenId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Метод toString()
    @Override
    public String toString() {
        return "Kitchen{" +
                "kitchenId=" + kitchenId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}