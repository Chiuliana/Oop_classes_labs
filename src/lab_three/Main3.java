// Main.java
package lab_three;

import java.util.Scanner;

import lab_three.models.Queue.Queue;
import lab_three.models.Queue.Queue.ArrayQueue;
import lab_three.models.Queue.Queue.CustomQueue;
import lab_three.models.Queue.Queue.LinkedQueue;
import lab_three.models.Stack.Stack;
import lab_three.models.Stack.Stack.ArrayStack;
import lab_three.models.Stack.Stack.CustomStack;
import lab_three.models.Stack.Stack.LinkedStack;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Test ArrayQueue
        System.out.println("Testing ArrayQueue:");
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        testQueue(arrayQueue, scanner);

        // Test CustomQueue
        System.out.println("\nTesting CustomQueue:");
        CustomQueue<Integer> customQueue = new CustomQueue<>();
        testQueue(customQueue, scanner);

        // Test LinkedQueue
        System.out.println("\nTesting LinkedQueue:");
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        testQueue(linkedQueue, scanner);

        // Test ArrayStack
        System.out.println("\nTesting ArrayStack:");
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        testStack(arrayStack, scanner);

        // Test CustomStack
        System.out.println("\nTesting CustomStack:");
        CustomStack<Integer> customStack = new CustomStack<>();
        testStack(customStack, scanner);

        // Test LinkedStack
        System.out.println("\nTesting LinkedStack:");
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        testStack(linkedStack, scanner);

        // Close the scanner
        scanner.close();
    }

    private static void testQueue(Queue<Integer> queue, Scanner scanner) {
        try {
            System.out.print("Enter numbers to enqueue (space-separated): ");
            String[] input = scanner.nextLine().split("\\s+");
            for (String num : input) {
                queue.enqueue(Integer.parseInt(num));
            }

            System.out.println("Front element: " + queue.peek());
            System.out.println("Dequeued element: " + queue.dequeue());
            System.out.println("Dequeued element: " + queue.dequeue());

            System.out.println("Is the queue empty? " + queue.isEmpty());

            System.out.print("Enter more numbers to enqueue (space-separated): ");
            input = scanner.nextLine().split("\\s+");
            for (String num : input) {
                queue.enqueue(Integer.parseInt(num));
            }

            System.out.println("Is the queue full? " + queue.isFull());

            System.out.println("Remaining elements in the queue:");
            while (!queue.isEmpty()) {
                System.out.println(queue.dequeue());
            }
        } catch (IllegalStateException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void testStack(Stack<Integer> stack, Scanner scanner) {
        try {
            System.out.print("Enter numbers to push onto the stack (space-separated): ");
            String[] input = scanner.nextLine().split("\\s+");
            for (String num : input) {
                stack.push(Integer.parseInt(num));
            }

            System.out.println("Top element: " + stack.peek());
            System.out.println("Popped element: " + stack.pop());
            System.out.println("Popped element: " + stack.pop());

            System.out.println("Is the stack empty? " + stack.isEmpty());

            System.out.print("Enter more numbers to push onto the stack (space-separated): ");
            input = scanner.nextLine().split("\\s+");
            for (String num : input) {
                stack.push(Integer.parseInt(num));
            }

            System.out.println("Is the stack full? " + stack.isFull());

            System.out.println("Remaining elements in the stack:");
            while (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
        } catch (IllegalStateException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
