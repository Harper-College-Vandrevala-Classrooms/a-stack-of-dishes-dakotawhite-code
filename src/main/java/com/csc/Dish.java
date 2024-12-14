package com.csc;

class Dish {
    public String description;

    Dish(String description) {
        this.description = description;
    }
}

class Stack<T> {
    private Object[] stack;
    private int top;
    private int maxSize;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new Object[maxSize];
        this.top = -1;
    }

    public void push(T item) {
        if (top == maxSize - 1) {
            System.out.println("Stack is full! Cannot push the item.");
        } else {
            stack[++top] = item;
        }
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (top == -1) {
            System.out.println("Stack is empty! Cannot pop an item.");
            return null;
        } else {
            T poppedItem = (T) stack[top];
            stack[top--] = null;
            return poppedItem;
        }
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (top == -1) {
            System.out.println("Stack is empty! Cannot peek.");
            return null;
        } else {
            return (T) stack[top];
        }
    }

    public int size() {
        return top + 1;
    }
public void clear() {
    for (int i = 0; i <= top; i++) {
        stack[i] = null;
    }
    top = -1;
}


    public static void main(String[] args) {
        Stack<Dish> stack = new Stack<>(3);

        Dish oneDish = new Dish("A dish with one fish pattern on it");
        Dish twoDish = new Dish("A dish with two fish patterns on it");
        Dish redDish = new Dish("A dish with a red fish pattern on it");
        Dish blueDish = new Dish("A dish with a blue fish pattern on it");

        System.out.println("Stack size before any push: " + stack.size());
        Dish dishOne = new Dish("Dish 1");
        Dish dishTwo = new Dish("Dish 2");
        
        stack.push(dishOne);
        stack.push(dishTwo);
        int stackSize = stack.size();
        System.out.println("Stack size after pushes: " + stack.size());
        stack.clear();
        int finalSize = stack.size();
        System.out.println("Stack size after clearing: " + stack.size());

        stack.push(oneDish);
        stack.push(twoDish);
        stack.push(redDish);
        stack.push(blueDish);

        System.out.println("Stack size after pushes: " + stack.size());
        Dish peekedDish = stack.peek();
        System.out.println("Peeked dish: " + (peekedDish != null ? peekedDish.description : "null"));

        Dish poppedDish = stack.pop();
        System.out.println("Popped dish: " + (poppedDish != null ? poppedDish.description : "null"));

        Dish anotherPoppedDish = stack.pop();
        System.out.println("Another popped dish: " + (anotherPoppedDish != null ? anotherPoppedDish.description : "null"));

        System.out.println("Final stack size: " + stack.size());
        
        
    }
}
