package lab_three;

import lab_three.behaviour.TestQueue;
import lab_three.behaviour.TestStack;
import lab_three.models.Queue.ArrayDownQueue;
import lab_three.models.Queue.ArrayUpQueue;
import lab_three.models.Queue.LinkedListQueue;
import lab_three.models.Stack.ArrayDownStack;
import lab_three.models.Stack.ArrayUpStack;
import lab_three.models.Stack.LinkedListStack;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = "";

        while (!message.equals("q")) {
            System.out.println("""
                    .................
                    Choose an option:
                    ..................
                    Test Stack  --> 1
                    Test Queue --> 2
                    ..................
                    Quit --> q
                    ..................
                    """);
            System.out.print("> ");
            message = scanner.nextLine();

            switch (message) {
                case "1" -> {
                    System.out.println("""
                            ..............................
                            Choose a stack implementation:
                            ...............................
                            ArrayUpStack --> 1
                            ArrayDownStack --> 2
                            LinkedListStack --> 3
                            ...............................
                            Quit --> q
                            ...............................
                            """);
                    System.out.print("> ");
                    String stackOption = scanner.nextLine();

                    if (stackOption.equals("1")) {
                        TestStack<Integer> arrayUpStackTest = new TestStack<>(new ArrayUpStack<>(5));
                        arrayUpStackTest.run();
                    } else if (stackOption.equals("2")) {
                        TestStack<Integer> arrayDownStackTest = new TestStack<>(new ArrayDownStack<>(5));
                        arrayDownStackTest.run();
                    } else if (stackOption.equals("3")) {
                        TestStack<Integer> linkedListStackTest = new TestStack<>(new LinkedListStack<>(5));
                        linkedListStackTest.run();
                    } else if (!stackOption.equals("q")) {
                        System.out.println("Invalid stack option.");
                    }
                }
                case "2" -> {
                    System.out.println("""
                            ...............................
                            Choose a queue implementation:
                            ...............................
                            ArrayUpQueue --> 1
                            ArrayDownQueue --> 2
                            LinkedListQueue --> 3
                            ...............................
                            Quit --> q
                            ...............................
                            """);
                    System.out.print("> ");
                    String queueOption = scanner.nextLine();

                    if (queueOption.equals("1")) {
                        TestQueue<Integer> arrayUpQueueTest = new TestQueue<>(new ArrayUpQueue<>(5));
                        arrayUpQueueTest.run();
                    } else if (queueOption.equals("2")) {
                        TestQueue<Integer> arrayDownQueueTest = new TestQueue<>(new ArrayDownQueue<>(5));
                        arrayDownQueueTest.run();
                    } else if (queueOption.equals("3")) {
                        TestQueue<Integer> linkedListQueueTest = new TestQueue<>(new LinkedListQueue<>(5));
                        linkedListQueueTest.run();
                    } else if (!queueOption.equals("q")) {
                        System.out.println("Invalid queue option.");
                    }
                }
                case "q" -> System.out.println("Quit");
                default -> System.out.println("Invalid command.");
            }
        }
        scanner.close();
    }
}
