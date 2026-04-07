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
}
