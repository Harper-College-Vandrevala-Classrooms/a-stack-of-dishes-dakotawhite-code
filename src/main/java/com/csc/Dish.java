package com.csc;

class Dish {
    public String description;

    Dish(String description) {
        this.description = description;
    }
}

class DishStack {
    private Dish[] stack;
    private int top;
    private int maxSize;

    public DishStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new Dish[maxSize];
        this.top = -1;
    }

    public void push(Dish dish) {
        if (top == maxSize - 1) {
            System.out.println("Stack is full! Cannot push the dish.");
        } else {
            stack[++top] = dish;
        }
    }

    public Dish pop() {
        if (top == -1) {
            System.out.println("Stack is empty! Cannot pop a dish.");
            return null;
        } else {
            Dish poppedDish = stack[top];
            stack[top--] = null;
            return poppedDish;
        }
    }

    public Dish peek() {
        if (top == -1) {
            System.out.println("Stack is empty! Cannot peek.");
            return null;
        } else {
            return stack[top];
        }
    }

    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        DishStack stack = new DishStack(3);

        Dish oneDish = new Dish("A dish with one fish pattern on it");
        Dish twoDish = new Dish("A dish with two fish patterns on it");
        Dish redDish = new Dish("A dish with a red fish pattern on it");
        Dish blueDish = new Dish("A dish with a blue fish pattern on it");

        System.out.println("Stack size before any push: " + stack.size());

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
