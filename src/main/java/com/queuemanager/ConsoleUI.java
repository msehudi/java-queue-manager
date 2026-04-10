package com.queuemanager;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Console-based user interface for the Java Queue Manager application.
 * Presents a text menu and delegates actions to {@link QueueManager}.
 */
public class ConsoleUI {

    private static final String SEPARATOR = "-----------------------------";

    private final Scanner scanner;

    public ConsoleUI(Scanner scanner) {
        this.scanner = scanner;
    }

    /** Starts the interactive console loop. */
    public void run() {
        System.out.println("=== Java Queue Manager ===");
        System.out.print("Enter a name for your queue: ");
        String queueName = scanner.nextLine().trim();

        QueueManager qm;
        try {
            qm = new QueueManager(queueName);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        System.out.println("Queue '" + qm.getName() + "' created.\n");

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();
            System.out.println(SEPARATOR);

            switch (choice) {
                case "1" -> handleEnqueue(qm);
                case "2" -> handleDequeue(qm);
                case "3" -> handlePeek(qm);
                case "4" -> handleDisplay(qm);
                case "5" -> handleSize(qm);
                case "6" -> handleClear(qm);
                case "7" -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please enter a number from 1 to 7.");
            }

            if (running) {
                System.out.println();
            }
        }
    }

    private void printMenu() {
        System.out.println(SEPARATOR);
        System.out.println("  Queue Menu");
        System.out.println(SEPARATOR);
        System.out.println("  1. Enqueue (add item)");
        System.out.println("  2. Dequeue (remove front item)");
        System.out.println("  3. Peek (view front item)");
        System.out.println("  4. Display all items");
        System.out.println("  5. Show size");
        System.out.println("  6. Clear queue");
        System.out.println("  7. Exit");
        System.out.println(SEPARATOR);
        System.out.print("Choose an option: ");
    }

    private void handleEnqueue(QueueManager qm) {
        System.out.print("Enter item to enqueue: ");
        String item = scanner.nextLine().trim();
        try {
            qm.enqueue(item);
            System.out.println("'" + item + "' added to queue '" + qm.getName() + "'.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void handleDequeue(QueueManager qm) {
        try {
            String item = qm.dequeue();
            System.out.println("Dequeued: '" + item + "'");
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void handlePeek(QueueManager qm) {
        try {
            String item = qm.peek();
            System.out.println("Front item: '" + item + "'");
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void handleDisplay(QueueManager qm) {
        if (qm.isEmpty()) {
            System.out.println("Queue '" + qm.getName() + "' is empty.");
            return;
        }
        System.out.println("Queue '" + qm.getName() + "' (front → back):");
        String[] items = qm.toArray();
        for (int i = 0; i < items.length; i++) {
            System.out.printf("  [%d] %s%n", i + 1, items[i]);
        }
    }

    private void handleSize(QueueManager qm) {
        System.out.println("Queue '" + qm.getName() + "' has " + qm.size() + " item(s).");
    }

    private void handleClear(QueueManager qm) {
        qm.clear();
        System.out.println("Queue '" + qm.getName() + "' cleared.");
    }
}
