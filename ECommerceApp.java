import java.util.*;

public class ECommerceApp {

    static List<Product> products = new ArrayList<>();
    static List<CartItem> cart = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Add some products
        products.add(new Product(1, "Laptop", 15000));
        products.add(new Product(2, "Phone", 8000));
        products.add(new Product(3, "Headphones", 500));

        while (true) {
            System.out.println("\n=== E-Commerce Menu ===");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");

            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> viewProducts();
                case 2 -> addToCart();
                case 3 -> viewCart();
                case 4 -> checkout();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // Show products
    static void viewProducts() {
        System.out.println("\nAvailable Products:");
        for (Product p : products) {
            System.out.println(p.id + ". " + p.name + " - " + p.price + " EGP");
        }
    }

    // Add to cart
    static void addToCart() {
        viewProducts();
        System.out.print("Enter product ID: ");
        int id = sc.nextInt();

        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        for (Product p : products) {
            if (p.id == id) {
                cart.add(new CartItem(p, qty));
                System.out.println("Added to cart!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    // View cart
    static void viewCart() {
        double total = 0;
        System.out.println("\nYour Cart:");
        for (CartItem item : cart) {
            System.out.println(item.product.name + " x " + item.quantity + 
                               " = " + item.getTotalPrice());
            total += item.getTotalPrice();
        }
        System.out.println("Total: " + total + " EGP");
    }

    // Checkout
    static void checkout() {
        viewCart();
        System.out.println("Thank you for shopping!");
        cart.clear();
    }
}
