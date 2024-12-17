public class OrdinaryUser extends User {
    public OrdinaryUser(int id, String name, String surname, double balance) {
        super(id, name, surname, balance);
    }

    @Override
    public void updateBalance(double amount) {
        setBalance(getBalance() - amount);
    }
    @Override
    public String toString() {
        return "OrdinaryUser [id=" + getId() + ", name=" + getName() + ", surname=" + getSurname() + ", balance=" + getBalance() + "]";
    }
}