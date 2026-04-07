package View;

import Controller.CornerStoreController;

import java.util.HashMap;
import java.util.Scanner;

public class CornerStoreView {
    private final CornerStoreController controller;
    private final Scanner scanner;

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
}
