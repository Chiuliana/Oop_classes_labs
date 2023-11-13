package lab_three.models.Queue;

public interface Queue<T> {
    void enqueue(T value);
    T dequeue();
    T peek();
    boolean isEmpty();
    boolean isFull();
    void print();
}
