package lab_three.models.Stack;

import lab_three.models.Node;

public class LinkedListStack<T> implements Stack<T> {
    private Node<T> top;
    private int maxSize;
    private int size;

    public LinkedListStack(int maxSize) {
        this.maxSize = maxSize;
        this.top = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean isFull() {
        return size == maxSize;
    }

    @Override
    public void push(T value) {
        if (!isFull()) {
            Node<T> newNode = new Node<>(value);
            newNode.next = top;
            top = newNode;
            size++;
        } else {
            System.out.println("Stack is full.");
        }
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            T value = top.data;
            top = top.next;
            size--;
            return value;
        } else {
            System.out.println("Stack is empty.");
            return null;
        }
    }

    @Override
    public T peek() {
        return isEmpty() ? null : top.data;
    }

    @Override
    public void print() {
        Node<T> current = top;
        System.out.print("[ ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("]\n");
    }
}
