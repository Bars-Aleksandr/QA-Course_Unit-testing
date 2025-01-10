package seminars.first.Shop;

public class Product {
    private Integer cost; // Стоимость продукта
    private String title; // Название

    // Геттеры, сеттеры:
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String toString() {
        return "Product{name='" + title + "', price=" + cost + "}";
    }
}