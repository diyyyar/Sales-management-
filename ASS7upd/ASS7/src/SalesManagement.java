import java.util.ArrayList;
import java.util.List;
public class SalesManagement {
    private ArrayList<Product> products;
    private ArrayList<User> users;
    private ArrayList<Order> orders;

    public SalesManagement() {
        this.products = new ArrayList<>();
        this.users = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addOrder(Order order) {
        int userId = order.getUserId();
        String productName = order.getProductName();
        int quantity = order.getQuantity();

        // Find the user and the product
        User user = findUserById(userId);
        Product product = findProductByName(productName);

        // Check if the product is available and the user has enough balance
        if (product != null && product.getQuantity() >= quantity && user != null) {
            double totalPrice = quantity * product.getPrice();

            if (user.getBalance() >= totalPrice) {
                // Update the product quantity and the user balance
                product.setQuantity(product.getQuantity() - quantity);
                user.updateBalance(totalPrice);

                // Create the order and add it to the order history of the user
                Order newOrder = new Order(userId, productName, quantity);
                user.addOrder(newOrder);

                // Apply discounts or cashback if applicable
                if (user instanceof PrimeUser && quantity > 1) {
                    ((PrimeUser) user).updateBalance(totalPrice);
                } else if (user instanceof LoyalUser) {
                    double cashback = totalPrice * LoyalUser.CASHBACK_RATE;
                    ((LoyalUser) user).setCashback(((LoyalUser) user).getCashback() + cashback);
                }

                // Add the order to the orders list
                orders.add(newOrder);
            } else {
                System.out.println("Order failed: not enough balance");
            }
        } else {
            System.out.println("Order failed: product not available or user not found");
        }
    }

    public int countProductsLeft() {
        int count = 0;

        for (Product product : products) {
            count += product.getQuantity();
        }

        return count;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    private User findUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    private Product findProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }

        return null;
    }
}