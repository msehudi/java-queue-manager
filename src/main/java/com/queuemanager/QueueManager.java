package com.queuemanager;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * Manages a named queue of string items with standard queue operations.
 */
public class QueueManager {

    private final String name;
    private final Deque<String> queue;

    public QueueManager(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Queue name must not be blank.");
        }
        this.name = name;
        this.queue = new ArrayDeque<>();
    }

    /** Returns the name of this queue. */
    public String getName() {
        return name;
    }

    /**
     * Adds an item to the back of the queue.
     *
     * @param item the item to enqueue; must not be null or blank
     */
    public void enqueue(String item) {
        if (item == null || item.isBlank()) {
            throw new IllegalArgumentException("Item must not be blank.");
        }
        queue.addLast(item);
    }

    /**
     * Removes and returns the item at the front of the queue.
     *
     * @return the front item
     * @throws NoSuchElementException if the queue is empty
     */
    public String dequeue() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("Queue '" + name + "' is empty.");
        }
        return queue.removeFirst();
    }

    /**
     * Returns the item at the front of the queue without removing it.
     *
     * @return the front item
     * @throws NoSuchElementException if the queue is empty
     */
    public String peek() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("Queue '" + name + "' is empty.");
        }
        return queue.peekFirst();
    }

    /** Returns the number of items currently in the queue. */
    public int size() {
        return queue.size();
    }

    /** Returns {@code true} if the queue contains no items. */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /** Removes all items from the queue. */
    public void clear() {
        queue.clear();
    }

    /**
     * Returns an array of all items in queue order (front to back).
     *
     * @return snapshot of queue contents
     */
    public String[] toArray() {
        return queue.toArray(new String[0]);
    }
}
