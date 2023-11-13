package lab_three.models.Queue;

import lab_three.models.Node;

public class LinkedListQueue<T> implements Queue<T> {
    private Node<T> head;
    private int maxSize;
    private int size;

    public LinkedListQueue(int maxSize) {
        this.maxSize = maxSize;
        this.head = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean isFull() {
        return size == maxSize;
    }

    @Override
    public void enqueue(T value) {
        if (!isFull()) {
            Node<T> newNode = new Node<>();
            newNode.setData(value);
            if (isEmpty()) {
                head = newNode;
            } else {
                Node<T> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.setNext(newNode);
            }
            size++;
        } else {
            System.out.println("Queue is full.");
        }
    }

    @Override
    public T dequeue() {
        if (!isEmpty()) {
            T value = head.data;
            head = head.next;
            size--;
            return value;
        } else {
            System.out.println("Queue is empty.");
            return null;
        }
    }

    @Override
    public T peek() {
        return isEmpty() ? null : head.data;
    }

    @Override
    public void print() {
        Node<T> current = head;
        System.out.print("[ ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("]\n");
    }
}
