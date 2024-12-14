package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DishTest {

    private Stack<Dish> stack; // Test for Dish objects
    private Dish oneDish;
    private Dish twoDish;
    private Dish redDish;
    private Dish blueDish;

    @BeforeEach
    public void setUp() {
        stack = new Stack<>(3);  // Test the stack with a size limit of 3
        oneDish = new Dish("A dish with one fish pattern on it");
        twoDish = new Dish("A dish with two fish patterns on it");
        redDish = new Dish("A dish with a red fish pattern on it");
        blueDish = new Dish("A dish with a blue fish pattern on it");
    }

    @Test
    public void testPushAndSize() {
        stack.push(oneDish);
        stack.push(twoDish);
        stack.push(redDish);
        assertEquals(3, stack.size(), "Stack size should be 3 after pushing 3 dishes");
    }

    @Test
    public void testPushWhenFull() {
        stack.push(oneDish);
        stack.push(twoDish);
        stack.push(redDish);
        stack.push(blueDish);
        assertEquals(3, stack.size(), "Stack size should still be 3 because the stack is full");
    }

    @Test
    public void testPop() {
        stack.push(oneDish);
        stack.push(twoDish);
        Dish poppedDish = stack.pop();
        assertNotNull(poppedDish, "Popped dish should not be null");
        assertEquals("A dish with two fish patterns on it", poppedDish.description, "Popped dish description should match");
        assertEquals(1, stack.size(), "Stack size should be 1 after popping one dish");
    }

    @Test
    public void testPopEmptyStack() {
        Dish poppedDish = stack.pop();
        assertNull(poppedDish, "Popped dish should be null when the stack is empty");
    }

    @Test
    public void testPeek() {
        stack.push(oneDish);
        stack.push(twoDish);
        Dish peekedDish = stack.peek();
        assertNotNull(peekedDish, "Peeked dish should not be null");
        assertEquals("A dish with two fish patterns on it", peekedDish.description, "Peeked dish description should match");
        assertEquals(2, stack.size(), "Stack size should remain the same after peeking");
    }

    @Test
    public void testPeekEmptyStack() {
        Dish peekedDish = stack.peek();
        assertNull(peekedDish, "Peeked dish should be null when the stack is empty");
    }
}
