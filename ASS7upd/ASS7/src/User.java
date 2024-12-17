import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private int id;
    private String name;
    private String surname;
    private double balance;
    private ArrayList<Order> orderHistory;

    public User(int id, String name, String surname, double balance) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.orderHistory = new ArrayList<>();
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", balance=" + balance + "]";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public abstract void updateBalance(double amount);

    public void addOrder(Order order) {
        orderHistory.add(order);
    }
}