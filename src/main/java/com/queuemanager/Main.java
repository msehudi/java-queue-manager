package com.queuemanager;

import java.util.Scanner;

/**
 * Entry point for the Java Queue Manager console application.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleUI ui = new ConsoleUI(scanner);
        ui.run();
        scanner.close();
    }
}
