package lab_three.models.Stack;

public class ArrayDownStack<T> implements Stack<T> {
    private Object[] stack;
    private int top;
    private int maxSize;

    public ArrayDownStack(int maxSize) {
        this.stack = new Object[maxSize];
        this.top = maxSize - 1;
        this.maxSize = maxSize;
    }

    @Override
    public boolean isEmpty() {
        return top == maxSize - 1;
    }

    @Override
    public boolean isFull() {
        return top == -1;
    }

    @Override
    public void push(T value) {
        if (!isFull()) {
            stack[top--] = value;
        } else {
            System.out.println("Stack is full.");
        }
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            T value = (T) stack[++top];
            stack[top] = null; // Clear the reference
            return value;
        } else {
            System.out.println("Stack is empty.");
            return null;
        }
    }

    @Override
    public T peek() {
        return isEmpty() ? null : (T) stack[top + 1];
    }

    @Override
    public void print() {
        System.out.print("[ ");
        for (int i = maxSize - 1; i > top; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println("]\n");
    }
}
