package lab_three.models.Queue;

public class ArrayUpQueue<T> implements Queue<T> {
    private Object[] queue;
    private int tail;
    private int maxSize;

    public ArrayUpQueue(int maxSize) {
        this.queue = new Object[maxSize];
        this.tail = -1;
        this.maxSize = maxSize;
    }

    @Override
    public boolean isEmpty() {
        return tail == -1;
    }

    @Override
    public boolean isFull() {
        return tail == maxSize - 1;
    }

    @Override
    public void enqueue(T value) {
        if (!isFull()) {
            queue[++tail] = value;
        } else {
            System.out.println("Queue is full.");
        }
    }

    @Override
    public T dequeue() {
        if (!isEmpty()) {
            T value = (T) queue[0];
            for (int i = 0; i < tail; i++) {
                queue[i] = queue[i + 1];
            }
            queue[tail--] = null; // Clear the reference
            return value;
        } else {
            System.out.println("Queue is empty.");
            return null;
        }
    }

    @Override
    public T peek() {
        return isEmpty() ? null : (T) queue[0];
    }

    @Override
    public void print() {
        System.out.print("[ ");
        for (int i = 0; i <= tail; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println("]\n");
    }
}
