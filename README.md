# Java Queue Manager

A console application for managing a named queue of string items, built with Java 17 and Maven.

## Features

- **Enqueue** – add items to the back of the queue
- **Dequeue** – remove and return the item at the front
- **Peek** – view the front item without removing it
- **Display** – list all items in order (front → back)
- **Size** – report how many items are in the queue
- **Clear** – remove all items at once

## Requirements

- Java 17+
- Apache Maven 3.6+

## Build

```bash
mvn package
```

The executable JAR will be generated at `target/java-queue-manager-1.0.0.jar`.

## Run

```bash
java -jar target/java-queue-manager-1.0.0.jar
```

You will be prompted to name your queue, then presented with a menu to manage it interactively.

## Test

```bash
mvn test
```

## Project Structure

```
├── pom.xml
└── src/
    ├── main/java/com/queuemanager/
    │   ├── Main.java          # Application entry point
    │   ├── QueueManager.java  # Core queue logic
    │   └── ConsoleUI.java     # Menu-driven console interface
    └── test/java/com/queuemanager/
        └── QueueManagerTest.java  # JUnit 5 unit tests
```