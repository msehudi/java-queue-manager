package com.queuemanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueManagerTest {

    private QueueManager qm;

    @BeforeEach
    void setUp() {
        qm = new QueueManager("test-queue");
    }

    // --- Constructor ---

    @Test
    void constructor_validName_createsEmptyQueue() {
        assertEquals("test-queue", qm.getName());
        assertTrue(qm.isEmpty());
        assertEquals(0, qm.size());
    }

    @Test
    void constructor_nullName_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new QueueManager(null));
    }

    @Test
    void constructor_blankName_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new QueueManager("   "));
    }

    // --- Enqueue ---

    @Test
    void enqueue_singleItem_sizeIsOne() {
        qm.enqueue("alpha");
        assertEquals(1, qm.size());
        assertFalse(qm.isEmpty());
    }

    @Test
    void enqueue_multipleItems_maintainsFIFOOrder() {
        qm.enqueue("first");
        qm.enqueue("second");
        qm.enqueue("third");
        assertArrayEquals(new String[]{"first", "second", "third"}, qm.toArray());
    }

    @Test
    void enqueue_nullItem_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> qm.enqueue(null));
    }

    @Test
    void enqueue_blankItem_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> qm.enqueue("  "));
    }

    // --- Dequeue ---

    @Test
    void dequeue_returnsAndRemovesFrontItem() {
        qm.enqueue("first");
        qm.enqueue("second");
        assertEquals("first", qm.dequeue());
        assertEquals(1, qm.size());
        assertEquals("second", qm.peek());
    }

    @Test
    void dequeue_emptyQueue_throwsNoSuchElementException() {
        assertThrows(NoSuchElementException.class, qm::dequeue);
    }

    @Test
    void dequeue_allItems_queueBecomesEmpty() {
        qm.enqueue("a");
        qm.dequeue();
        assertTrue(qm.isEmpty());
    }

    // --- Peek ---

    @Test
    void peek_returnsFrontItemWithoutRemoving() {
        qm.enqueue("front");
        qm.enqueue("back");
        assertEquals("front", qm.peek());
        assertEquals(2, qm.size());
    }

    @Test
    void peek_emptyQueue_throwsNoSuchElementException() {
        assertThrows(NoSuchElementException.class, qm::peek);
    }

    // --- Size ---

    @Test
    void size_afterSeveralOperations_reflectsCorrectCount() {
        assertEquals(0, qm.size());
        qm.enqueue("x");
        assertEquals(1, qm.size());
        qm.enqueue("y");
        assertEquals(2, qm.size());
        qm.dequeue();
        assertEquals(1, qm.size());
    }

    // --- Clear ---

    @Test
    void clear_nonEmptyQueue_becomesEmpty() {
        qm.enqueue("item1");
        qm.enqueue("item2");
        qm.clear();
        assertTrue(qm.isEmpty());
        assertEquals(0, qm.size());
    }

    @Test
    void clear_emptyQueue_remainsEmpty() {
        qm.clear();
        assertTrue(qm.isEmpty());
    }

    // --- ToArray ---

    @Test
    void toArray_emptyQueue_returnsEmptyArray() {
        assertArrayEquals(new String[0], qm.toArray());
    }

    @Test
    void toArray_returnsItemsInFIFOOrder() {
        qm.enqueue("one");
        qm.enqueue("two");
        qm.enqueue("three");
        assertArrayEquals(new String[]{"one", "two", "three"}, qm.toArray());
    }
}
