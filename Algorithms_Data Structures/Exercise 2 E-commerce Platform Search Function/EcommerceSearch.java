import java.util.Arrays;
import java.util.Comparator;

public class ECommerceSearch {

    static class Product {
        int id;
        String name;
        String category;

        Product(int id, String name, String category) {
            this.id = id;
            this.name = name;
            this.category = category;
        }

        public String toString() {
            return id + " - " + name + " (" + category + ")";
        }
    }

    public static Product linearSearch(Product[] list, int key) {
        for (Product p : list) {
            if (p.id == key) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] list, int key) {
        int low = 0, high = list.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list[mid].id == key) {
                return list[mid];
            } else if (list[mid].id < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] items = {
                new Product(103, "Keyboard", "Electronics"),
                new Product(101, "Laptop", "Electronics"),
                new Product(105, "Shoes", "Footwear"),
                new Product(102, "Mouse", "Electronics"),
                new Product(104, "T-shirt", "Clothing")
        };

        int searchId1 = 105;
        int searchId2 = 106;

        System.out.println("Available Products:");
        for (Product p : items) {
            System.out.println(p);
        }

        System.out.println("\nLinear Search:");
        Product found1 = linearSearch(items, searchId1);
        System.out.println("Searching for ID " + searchId1 + ": " + (found1 != null ? found1 : "Product not found"));

        Product found2 = linearSearch(items, searchId2);
        System.out.println("Searching for ID " + searchId2 + ": " + (found2 != null ? found2 : "Product not found"));

        Arrays.sort(items, Comparator.comparingInt(p -> p.id));

        System.out.println("\nSorted Products (for Binary Search):");
        for (Product p : items) {
            System.out.println(p);
        }

        System.out.println("\nBinary Search:");
        Product found3 = binarySearch(items, searchId1);
        System.out.println("Searching for ID " + searchId1 + ": " + (found3 != null ? found3 : "Product not found"));

        Product found4 = binarySearch(items, searchId2);
        System.out.println("Searching for ID " + searchId2 + ": " + (found4 != null ? found4 : "Product not found"));
    }
}
