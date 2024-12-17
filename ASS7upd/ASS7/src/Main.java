import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean quit = false;
        try {
            while (!quit) {
                System.out.println("Enter command: ");
                System.out.println("\n1.add product \n 2.add user \n 3.add order \n 4.count products \n 5.list users \n 6.list orders \n 7.quit ");
                String command = scanner.nextLine();
                switch (command) {
                    case "add product":
                        Methods.addProduct();
                        break;
                    case "add user":
                        Methods.addUser();
                        break;
                    case "add order":
                        Methods.addOrder();
                        break;
                    case "count products":
                        Methods.countProducts();
                        break;
                    case "list products":
                        Methods.listProducts();
                        break;
                    case "list users":
                        Methods.listUsers();
                        break;
                    case "list orders":
                        Methods.listOrders();
                        break;
                    case "quit":
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid command");
                }
            }

        }catch (Exception exception){
            System.out.println(exception + " exception!");
        }

    }

}
