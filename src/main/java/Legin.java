import java.util.Scanner;

public class Legin {
    private static Task[] tasks = new Task[100];
    private static int currentTaskCount = 0;

    public static void horizontalLine() {
        System.out.println("______________________" +
                "______________________________________");
    }
    public static void greet() {
        horizontalLine();
        System.out.println("Hello! I'm Legin, your best online companion!");
        System.out.println("What can I do for you today my friend :D");
        horizontalLine();
    }
    public static void bye() {
        horizontalLine();
        System.out.println("Bye " +
            Character.toString(0x1F44B) +
            ". Hope to see you again really soon! " +
            Character.toString(0x1F608));
        horizontalLine();
    }

    private static void printAddedTaskMessage() {
        horizontalLine();
        System.out.println("Got it. I've added this task:");
        System.out.println(tasks[currentTaskCount]);
        currentTaskCount++;
        System.out.println("Now you have " + currentTaskCount + " tasks in the list.");
        horizontalLine();
    }

    public static void echo(String input) {
        tasks[currentTaskCount] = new Task(input);
        printAddedTaskMessage();
    }

    public static void addTodo(String input) {
        tasks[currentTaskCount] = new Todo(input);
        printAddedTaskMessage();
    }

    public static void addDeadline(String input) {
        tasks[currentTaskCount] = new Deadline(input);
        printAddedTaskMessage();
    }

    public static void addEvent(String input) {
        tasks[currentTaskCount] = new Event(input);
        printAddedTaskMessage();
    }

    public static void list() {
        horizontalLine();
        for (int i = 0; i < currentTaskCount; i++) {
            System.out.print(i + 1 + ". ");
            System.out.println(tasks[i]);
        }
        horizontalLine();
    }

    public static void markTask(int index) {
        horizontalLine();
        tasks[index - 1].markTask();
        System.out.println("Good Job Buddy! I've marked this task as done:");
        System.out.println(tasks[index - 1]);
        horizontalLine();
    }

    public static void unmarkTask(int index) {
        horizontalLine();
        tasks[index - 1].unmarkTask();
        System.out.println("Alright! I've marked this task as not done yet:");
        System.out.println(tasks[index - 1]);
        horizontalLine();
    }

    public static void runBot() {
        boolean saidBye = false;
        String command;
        String input;
        int indexOfTaskToMark;
        Scanner in = new Scanner(System.in);
        while (!saidBye) {
            input = in.nextLine();
            String[] words = input.split(" ");
            command = words[0];
            switch (command) {
            case "bye":
                saidBye = true;
                break;
            case "list":
                list();
                break;
            case "mark":
                indexOfTaskToMark = Integer.parseInt(words[1]);
                markTask(indexOfTaskToMark);
                break;
            case "unmark":
                indexOfTaskToMark = Integer.parseInt(words[1]);
                unmarkTask(indexOfTaskToMark);
                break;
            case "todo":
                addTodo(input);
                break;
            case "deadline":
                addDeadline(input);
                break;
            case "event":
                addEvent(input);
                break;
            default:
                echo(input);
            }
        }
    }

    public static void main(String[] args) {
        greet();
        runBot();
        bye();
    }
}
