import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static List<Product> products = new ArrayList<>();
    private static String PATH_DATA = "data-copy.txt";


    static {
        try (
                FileInputStream fis = new FileInputStream(PATH_DATA);
                ObjectInputStream oos = new ObjectInputStream(fis)
        ) {
            products = (List<Product>) oos.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addProduct(String name, String manufacturer, double price, String description) {
        if (contains(name)) {
            System.out.println("Product exists");
            return;
        }
        products.add(new Product(products.size() + 1, name, manufacturer, price, description));
        update();
    }

    public void showProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void removeProductByID(int id) {
        if (id > products.size() || id <= 0) {
            System.out.println("Index out of range");
            return;
        }
        products.remove(id - 1);
        for (int i = id - 1; i < products.size(); i++) {
            products.get(i).setId(i + 1);
        }
        update();
    }

    public Product searchProduct(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public boolean contains(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private void update() {
        try (
                FileOutputStream fos = new FileOutputStream(PATH_DATA);
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(products);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}