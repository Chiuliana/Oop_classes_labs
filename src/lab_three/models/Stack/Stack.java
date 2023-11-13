package lab_three.models.Stack;

public interface Stack<T> {
    void push(T value);
    T pop();
    T peek();
    boolean isEmpty();
    boolean isFull();
    void print();
}