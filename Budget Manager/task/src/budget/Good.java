package budget;

public class Good {
    String name;
    double price;
    Category category;

    public Good(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return name + " $" + price;
    }
}
