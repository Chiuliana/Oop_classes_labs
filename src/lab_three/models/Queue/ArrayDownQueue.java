package lab_three.models.Queue;
public class ArrayDownQueue<T> implements Queue<T> {
    private Object[] queue;
    private int tail;
    private int maxSize;

    public ArrayDownQueue(int maxSize) {
        this.queue = new Object[maxSize];
        this.tail = maxSize - 1;
        this.maxSize = maxSize;
    }

    @Override
    public boolean isEmpty() {
        return tail == maxSize - 1;
    }

    @Override
    public boolean isFull() {
        return tail == -1;
    }

    @Override
    public void enqueue(T value) {
        if (!isFull()) {
            queue[tail--] = value;
        } else {
            System.out.println("Queue is full.");
        }
    }

    @Override
    public T dequeue() {
        if (!isEmpty()) {
            T value = (T) queue[maxSize - 1 - tail];
            queue[maxSize - 1 - tail] = null; // Clear the reference
            tail++;
            return value;
        } else {
            System.out.println("Queue is empty.");
            return null;
        }
    }

    @Override
    public T peek() {
        return isEmpty() ? null : (T) queue[maxSize - 1 - tail];
    }

    @Override
    public void print() {
        System.out.print("[ ");
        for (int i = maxSize - 1; i > tail; i--) {
            System.out.print(queue[i] + " ");
        }
        System.out.println("]\n");
    }
}
