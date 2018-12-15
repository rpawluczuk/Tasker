import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {
    void start() throws IOException, ClassNotFoundException {
        Database database = new Database();
        List<Task> listWithTasks = new LinkedList<Task>();
        Task task = new Task();
        String line = " ";
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, welcome to the Tasker.");
        while (!"Q".equals(line)) {
            System.out.println("Please choose the action.");
            System.out.println("1 - Add new task\t2 - Display all tasks\t" +
                    "3 - Add task and erase text file\t4 - Edit task\tQ - Quit");
            line = sc.next();
            switch (line){
                case "1":
                {
                    task.createTask();
                    database.addTask(task);
                    break;
                }
                case "2":
                {
                    System.out.println("Enter the name of new database:");
                    line = sc.next();
                    database.displayDatabase(line);
                    break;
                }
                case "3":
                {
                    task.createTask();
                    database.eraseAndAddToDatabase(task);
                    break;
                }
                case "4":
                {
                    System.out.println("Enter the name of new database:");
                    line = sc.next();
                    database.editTask(line);
                    break;
                }
            }
        }
    }
}
