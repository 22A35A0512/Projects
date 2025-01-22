import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;
    private int stockQuantity;

    public Product(String name, double price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}

class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addProduct(Product product) {
        items.add(product);
    }

    public void removeProduct(Product product) {
        items.remove(product);
    }
}

class User {
    private String username;
    private String password;
    private List<ShoppingCart> orderHistory;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.orderHistory = new ArrayList<>();
    }

    public void login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password!");
        }
    }

    public void addToOrderHistory(ShoppingCart cart) {
        orderHistory.add(cart);
    }
}

public class Task3 {
    public static void main(String[] args) {
        // Create some products
        Product product1 = new Product("Phone", 500, 10);
        Product product2 = new Product("Laptop", 1000, 5);

        // Create a shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Add products to the shopping cart
        cart.addProduct(product1);
        cart.addProduct(product2);

        // Remove a product from the shopping cart
        cart.removeProduct(product1);

        // Create a user
        User user = new User("john", "password");

        // Login the user
        user.login("john", "password");

        // Add the shopping cart to the user's order history
        user.addToOrderHistory(cart);
    }
}
