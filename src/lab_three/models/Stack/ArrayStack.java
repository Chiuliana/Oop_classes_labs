package lab_three.models.Stack;

import lab_three.behaviour.Stack;

public class ArrayStack<T> implements Stack<T> {
    private Object[] array;
    private int size;
    private static final int MAX_SIZE = 5;

    public ArrayStack() {
        this.array = new Object[MAX_SIZE];
        this.size = 0;
    }

    @Override
    public void push(T element) {
        if (size < MAX_SIZE) {
            array[size++] = element;
        } else {
            throw new IllegalStateException("Stack is full");
        }
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            return (T) array[--size];
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return (T) array[size - 1];
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == MAX_SIZE;
    }

    // Additional method to get the size of the stack
    public int size() {
        return size;
    }

    // Additional method to clear the stack
    public void clear() {
        size = 0;
    }
}
