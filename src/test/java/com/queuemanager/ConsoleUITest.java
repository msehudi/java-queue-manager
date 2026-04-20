package com.queuemanager;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleUITest {

    /**
     * Runs the ConsoleUI with the given simulated input lines and returns the captured output.
     */
    private String runWithInput(String... lines) {
        String input = String.join("\n", lines) + "\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));
        try {
            new ConsoleUI(scanner).run();
        } finally {
            System.setOut(originalOut);
        }
        return baos.toString();
    }

    @Test
    void run_blankQueueName_exitsWithError() {
        String output = runWithInput("   ");
        assertTrue(output.contains("Error:"), "Expected error message for blank queue name");
    }

    @Test
    void run_enqueueAndDisplay_showsItemsInOrder() {
        // name queue, enqueue two items, display, exit
        String output = runWithInput("myQueue", "1", "alpha", "1", "beta", "4", "7");
        assertTrue(output.contains("'alpha' added to queue 'myQueue'"));
        assertTrue(output.contains("'beta' added to queue 'myQueue'"));
        assertTrue(output.contains("[1] alpha"));
        assertTrue(output.contains("[2] beta"));
    }

    @Test
    void run_dequeue_removesAndPrintsFrontItem() {
        String output = runWithInput("q", "1", "first", "1", "second", "2", "7");
        assertTrue(output.contains("Dequeued: 'first'"));
    }

    @Test
    void run_dequeueEmptyQueue_showsError() {
        String output = runWithInput("q", "2", "7");
        assertTrue(output.contains("Error:"));
    }

    @Test
    void run_peek_showsFrontItemWithoutRemoving() {
        String output = runWithInput("q", "1", "top", "3", "4", "7");
        assertTrue(output.contains("Front item: 'top'"));
        assertTrue(output.contains("[1] top"));
    }

    @Test
    void run_peekEmptyQueue_showsError() {
        String output = runWithInput("q", "3", "7");
        assertTrue(output.contains("Error:"));
    }

    @Test
    void run_displayEmptyQueue_showsEmptyMessage() {
        String output = runWithInput("q", "4", "7");
        assertTrue(output.contains("is empty"));
    }

    @Test
    void run_size_showsCorrectCount() {
        String output = runWithInput("q", "1", "x", "1", "y", "5", "7");
        assertTrue(output.contains("has 2 item(s)"));
    }

    @Test
    void run_clearQueue_makesQueueEmpty() {
        String output = runWithInput("q", "1", "item", "6", "4", "7");
        assertTrue(output.contains("cleared"));
        assertTrue(output.contains("is empty"));
    }

    @Test
    void run_invalidOption_showsInvalidMessage() {
        String output = runWithInput("q", "9", "7");
        assertTrue(output.contains("Invalid option"));
    }

    @Test
    void run_enqueueBlankItem_showsError() {
        String output = runWithInput("q", "1", "   ", "7");
        assertTrue(output.contains("Error:"));
    }

    @Test
    void run_exit_printsGoodbye() {
        String output = runWithInput("q", "7");
        assertTrue(output.contains("Goodbye!"));
    }
}
