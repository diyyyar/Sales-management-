import java.util.Scanner;

public class Methods extends Main{
    private static Scanner scanner = new Scanner(System.in);
     static SalesManagement salesManagement = new SalesManagement();
    public static void addProduct() {

        System.out.println("Enter product ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter product name: ");
        String name = scanner.nextLine();

        System.out.println("Enter product quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter product price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Product product = new Product(id, name, quantity, price);
        salesManagement.addProduct(product);
    }
    public static void addUser() {
        System.out.println("Enter user type (ordinary, prime, loyal): ");
        String userType = scanner.nextLine();

        System.out.println("Enter user ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter user name: ");
        String name = scanner.nextLine();

        System.out.println("Enter user surname: ");
        String surname = scanner.nextLine();

        System.out.println("Enter user balance: ");
        double balance = Double.parseDouble(scanner.nextLine());

        User user;

        switch (userType) {
            case "ordinary":
                user = new OrdinaryUser(id, name, surname, balance);
                break;
            case "prime":
                user = new PrimeUser(id, name, surname, balance);
                break;
            case "loyal":
                user = new LoyalUser(id, name, surname, balance);
                break;
            default:
                System.out.println("Invalid user type");
                return;
        }

        salesManagement.addUser(user);
    }

    public static void addOrder() {
        System.out.println("Enter user ID: ");
        int userId = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.println("Enter quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        Order order = new Order(userId, productName, quantity);
        salesManagement.addOrder(order);
    }

    public static void countProducts() {
        System.out.println("Total products left: " + salesManagement.countProductsLeft());
    }

    public static void listProducts() {
        for (Product product : salesManagement.getProducts()) {
            System.out.println(product.toString());
        }
    }

    public static void listUsers() {
        for (User user : salesManagement.getUsers()) {
            System.out.println(user.toString());
        }
    }

    public static void listOrders() {
        for (Order order : salesManagement.getOrders()) {
            System.out.println(order.toString());
        }
    }

}
