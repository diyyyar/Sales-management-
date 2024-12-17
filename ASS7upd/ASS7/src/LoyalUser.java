import java.util.List;
import java.util.ArrayList;

public class LoyalUser extends User {
    public static final double CASHBACK_RATE = 0.06;
    private double cashback;

    public LoyalUser(int id, String name, String surname, double balance) {
        super(id, name, surname, balance);
        this.cashback = 0.0;
    }

    public double getCashback() {
        return cashback;
    }

    public void setCashback(double cashback) {
        this.cashback = cashback;
    }

    @Override
    public void updateBalance(double amount) {
        setBalance(getBalance() - amount + cashback);
    }
    @Override
    public String toString() {
        return "LoyalUser [id=" + getId() + ", name=" + getName() + ", surname=" + getSurname() + ", balance=" + getBalance() + ", cashback=" + cashback + "]";
    }
}