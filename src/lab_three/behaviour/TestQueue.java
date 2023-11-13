package lab_three.behaviour;

import lab_three.models.Queue.Queue;

import java.util.Scanner;

public class TestQueue<T> {
    private Queue<T> queue;
    private Scanner scanner;

    public TestQueue(Queue<T> queue) {
        this.queue = queue;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        String message = "";
        System.out.println("Queue Test. Enter 'h' for help.");
        System.out.println("===========================================");
        while (!message.equals("q")) {
            System.out.print("> ");
            String[] input = scanner.nextLine().split(" ");
            message = input[0];
            switch (message) {
                case "h" -> System.out.println("""
                        enqueue <value> - enqueue value to queue
                        dequeue         - dequeue value from queue
                        peek            - peek value from queue
                        q               - quit
                        """);
                case "enqueue" -> {
                    if (input.length < 2) {
                        System.out.println("No value provided.");
                        break;
                    }
                    T value = parseValue(input[1]);
                    this.queue.enqueue(value);
                    this.queue.print();
                }
                case "dequeue" -> {
                    T value = this.queue.dequeue();
                    System.out.println(value);
                    this.queue.print();
                }
                case "peek" -> {
                    T value = this.queue.peek();
                    System.out.println(value);
                    this.queue.print();
                }
                case "q" -> System.out.println("Shutting down...");
                default -> System.out.println("Invalid command.");
            }
        }
        System.out.println("===========================================");
    }

    private T parseValue(String input) {
        // Assuming T is Integer for simplicity. You can adjust this for other types.
        return (T) Integer.valueOf(input);
    }
}

