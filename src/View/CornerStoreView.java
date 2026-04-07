package View;

import Controller.CornerStoreController;
import Model.Sale.Sale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CornerStoreView {
    private final CornerStoreController controller;
    private final Scanner scanner;

    public void start() {
        boolean running = true;

        while (running) {
            printMainMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    listProducts();
                    break;
                case "2":
                    processSale();
                    break;
                case "3":
                    listSales();
                    break;
                case "4":
                    addProduct();
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

        System.out.println("Exiting application. Goodbye!");
    }

    public CornerStoreView() {
        this.controller = new CornerStoreController();
        this.scanner = new Scanner(System.in);
    }

    private void printMainMenu() {
        System.out.println("\nThe Corner Store");
        System.out.println("1. List all products");
        System.out.println("2. Process a new sale");
        System.out.println("3. View all sales");
        System.out.println("4. Add a new product");
        System.out.println("5. Exit");
        System.out.print("Please select an option: ");
    }

    private void listProducts() {
        System.out.println("\nAvailable Products");
        System.out.printf("%-5s | %-20s | %-10s | %-10s%n",
                "ID", "Name", "Price", "Stock");
        System.out.println("-------------------------------------------------------");

        HashMap<Integer, String[]> products = controller.getProducts();

        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (int id : products.keySet()) {
                String[] p = products.get(id);
                System.out.printf("%-5s | %-20s | $%-9s | %-10s%n",
                        "p" + id, p[0], p[1], p[2]);
            }
        }

        System.out.println("-------------------------------------------------------");
    }

    private void processSale() {
        System.out.println("\nProcess New Sale");
        System.out.print("Enter Customer ID (e.g., c1): ");
        String customerId = scanner.nextLine();

        if (!controller.customerExists(customerId)) {
            System.out.println("ERROR: Customer ID not found.");
            return;
        }

        System.out.print("Enter Product ID (e.g., p1): ");
        String productId = scanner.nextLine();

        if (!controller.productExists(productId)) {
            System.out.println("ERROR: Product ID not found.");
            return;
        }

        System.out.print("Enter quantity to sell: ");
        int quantity;

        try {
            quantity = Integer.parseInt(scanner.nextLine());
            if (quantity <= 0) {
                System.out.println("ERROR: Quantity must be positive.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Invalid quantity entered.");
            return;
        }

        boolean success = controller.addSale(customerId, productId, quantity);

        if (!success) {
            System.out.println("ERROR: Could not process sale.");
            return;
        }

        System.out.println("SUCCESS: Sale processed successfully!");

        double total = controller.getSaleTotal(productId, quantity);
        System.out.printf("Sale total: $%.2f\n", total);
    }

    private void addProduct() {
        System.out.println("\nAdd New Product");

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter price: ");
        String price = scanner.nextLine();

        System.out.print("Enter initial stock: ");
        String quantity = scanner.nextLine();

        boolean success = controller.addProduct(name, price, quantity);

        if (success) {
            System.out.println("SUCCESS: Product added.");
        } else {
            System.out.println("ERROR: Could not add product. Check inputs.");
        }
    }

    private void listSales() {
        System.out.println("\nAll Sales Records");
        System.out.printf("%-5s | %-20s | %-20s | %-10s%n",
                "ID", "Customer", "Product", "Quantity");
        System.out.println("-----------------------------------------------------------------");

        ArrayList<Sale> sales = controller.getSales();

        if (sales.isEmpty()) {
            System.out.println("No sales have been recorded yet.");
        } else {
            for (Sale sale : sales) {
                System.out.printf("%-5s | %-20s | %-20s | %-10s%n",
                        sale.getSaleId(),
                        sale.getCustomerId(),
                        sale.getProductId(),
                        sale.getQuantity());
            }
        }

        System.out.println("-----------------------------------------------------------------");
    }
}
