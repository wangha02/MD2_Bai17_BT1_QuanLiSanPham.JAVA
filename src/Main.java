import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ProductManager manager = new ProductManager();
        manager.showProducts();
        while (true) {
            System.out.println("PRODUCT-MANAGER");
            System.out.println("1. Show product list");
            System.out.println("2. Add new product");
            System.out.println("3. Remove product");
            System.out.println("4. Search by name");
            System.out.println("5. Exit");
            System.out.println("Enter your choice");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    manager.showProducts();
                    break;
                case 2:
                    System.out.println("Enter product's name");
                    String name = sc.nextLine();
                    System.out.println("Enter product's manufacturer");
                    String manufacturer = sc.nextLine();
                    System.out.println("Enter product's price");
                    double price = Double.parseDouble(sc.nextLine());
                    System.out.println("Enter product's description");
                    String description = sc.nextLine();

                    if (name.isEmpty() || manufacturer.isEmpty()) {
                        System.out.println("Invalid product");
                        return;
                    }
                    manager.addProduct(name, manufacturer, price, description);
                    break;
                case 3:
                    System.out.println("Enter product's ID to remove:");
                    int id = Integer.parseInt(sc.nextLine());
                    manager.removeProductByID(id);
                    break;
                case 4:
                    System.out.println("Enter product's name:");
                    String nameSearch = sc.nextLine();
                    System.out.println(manager.searchProduct(nameSearch));
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}