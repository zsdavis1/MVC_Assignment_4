package View;

import Controller.CornerStoreController;

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
}
