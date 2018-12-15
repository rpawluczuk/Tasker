import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Task implements Serializable {

    String nameOfTask;
    String taskCreationDate = new SimpleDateFormat
            ("yyyy-MM-dd").format(new Date());
    String expectedEndDateOfTheTask;
    String status;
    String comment;

    public Task() {
        this.nameOfTask = "default";
        this.expectedEndDateOfTheTask = "default";
        this.status = "default";
        this.comment = "default";
    }

    public Task(String nameOfTask,
                String expectedEndDateOfTheTask,
                String status,
                String comment) {
        this.nameOfTask = nameOfTask;
        this.expectedEndDateOfTheTask = expectedEndDateOfTheTask;
        this.status = status;
        this.comment = comment;
    }

    public void createTask(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of task");
        this.nameOfTask = sc.nextLine();
        System.out.println("Enter expected end date of the task");
        this.expectedEndDateOfTheTask = sc.nextLine();
        System.out.println("Enter status");
        this.status = sc.nextLine();
        System.out.println("Enter comment");
        this.comment = sc.nextLine();
    }

    @Override
    public String toString() {
        return  "Name of task: " + nameOfTask +
                "\nTask creation date: " + taskCreationDate +
                "\nExpected end date of the task: " + expectedEndDateOfTheTask +
                "\nStatus: " + status +
                "\nComment: " + comment +
                "\n----------------------\n";
    }

}
