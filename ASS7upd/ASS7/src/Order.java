public class Order {
    private int userId;
    private String productName;
    private int quantity;

    public Order(int userId, String productName, int quantity) {
        this.userId = userId;
        this.productName = productName;
        this.quantity = quantity;
    }

    public int getUserId() {
        return userId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }
    public String toString() {
        return "Order [userId=" + userId + ", productName=" + productName + ", quantity=" + quantity + "]";
    }

}