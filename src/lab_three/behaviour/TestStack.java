package lab_three.behaviour;

import lab_three.models.Stack.Stack;

import java.util.Scanner;

public class TestStack<T> {
    private Stack<T> stack;
    private Scanner scanner;

    public TestStack(Stack<T> stack) {
        this.stack = stack;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        String message = "";
        System.out.println("...............\n" + "Stack Test.");
        System.out.println("...............\n" + "For help enter h \n" + "...............\n");
        while (!message.equals("q")) {
            System.out.print("> ");
            String[] input = scanner.nextLine().split(" ");
            message = input[0];
            switch (message) {
                case "h" -> System.out.println("""
                        ....................................
                        push val to stack --> push <value> 
                        pop val from stack --> pop
                        peek val from stack --> peek
                        .....................................
                        quit --> q
                        .....................................
                        """);
                case "push" -> {
                    if (input.length < 2) {
                        System.out.println("No value provided.");
                        break;
                    }
                    T value = parseValue(input[1]);
                    this.stack.push(value);
                    this.stack.print();
                }
                case "pop" -> {
                    T value = this.stack.pop();
                    System.out.println(value);
                    this.stack.print();
                }
                case "peek" -> {
                    T value = this.stack.peek();
                    System.out.println(value);
                    this.stack.print();
                }
                case "q" -> System.out.println("Quit");
                default -> System.out.println("Invalid command.");
            }
        }
        System.out.println(".....................................\n");
    }

    private T parseValue(String input) {
        // Assuming T is Integer for simplicity. You can adjust this for other types.
        return (T) Integer.valueOf(input);
    }
}
