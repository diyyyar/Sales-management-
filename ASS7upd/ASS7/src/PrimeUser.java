public class PrimeUser extends User {
    private static final double DISCOUNT_RATE = 0.05;

    public PrimeUser(int id, String name, String surname, double balance) {
        super(id, name, surname, balance);
    }

    @Override
    public void updateBalance(double amount) {
        setBalance(getBalance() - (1 - DISCOUNT_RATE) * amount);
    }
    public String toString() {
        return "PrimeUser [id=" + getId() + ", name=" + getName() + ", surname=" + getSurname() + ", balance=" + getBalance() + "]";
    }
}