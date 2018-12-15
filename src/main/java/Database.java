import java.io.*;
import java.util.*;

public class Database implements Serializable {
    String nameOfDatabase;

    List<Task> listWithTasks = new LinkedList<Task>();


    public void createDatabase() throws IOException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of new database:");
        String newFileName = in.next();
        File file = new File(newFileName + ".dat");
        if (file.isFile() == true) {
            System.out.println("The file already exists");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(newFileName + ".dat"));
            listWithTasks = (List<Task>) ois.readObject();
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("The file can not be created");
            }
        }
        this.nameOfDatabase = newFileName;
    }

    public void addTask(Task task) throws IOException, ClassNotFoundException {
        createDatabase();
        listWithTasks.add(task);
        ObjectOutputStream out = new ObjectOutputStream
                (new FileOutputStream(nameOfDatabase + ".dat"));
        out.writeObject(listWithTasks);
    }

    public void displayDatabase(String file) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file + ".dat"));
        listWithTasks = (LinkedList<Task>) in.readObject();
        for (Task t : listWithTasks) {
            System.out.println(t);
        }
    }

    public void eraseAndAddToDatabase(Task task) throws IOException, ClassNotFoundException {
        createDatabase();
        listWithTasks.clear();
        listWithTasks.add(task);
        ObjectOutputStream out = new ObjectOutputStream
                (new FileOutputStream(nameOfDatabase + ".dat"));
        out.writeObject(listWithTasks);

//        FileWriter saveTask = new FileWriter(nameOfDatabase + ".txt");
//        saveTask.write(task.toString());
//        saveTask.close();
    }

    public void editTask(String file) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file + ".dat"));
        listWithTasks = (LinkedList<Task>) in.readObject();
        String line;
        Scanner sc = new Scanner(System.in);
        System.out.println("Count of created tasks: " + listWithTasks.size());
        System.out.println("Select number of task which you want to edit");
        int numberOfTask = sc.nextInt();
        Task editedTask = listWithTasks.get(numberOfTask);;
        System.out.println("Select which field do you want to edit?");
        System.out.println("[1] Name of task: " + editedTask.nameOfTask +
                "\n[2] Task creation date: " + editedTask.taskCreationDate +
                "\n[3] Expected end date of the task: " + editedTask.expectedEndDateOfTheTask +
                "\n[4] Status: " + editedTask.status +
                "\n{5] Comment: " + editedTask.comment);
        line = sc.next();
        sc.nextLine();
        switch (line){
            case "1":
                System.out.println("enter new content:");
                line = sc.nextLine();

                editedTask.nameOfTask = line;
                break;
            case "2":
                System.out.println("enter new content:");
                line = sc.nextLine();
                editedTask.taskCreationDate = line;
                break;
            case "3":
                System.out.println("enter new content:");
                line = sc.nextLine();
                editedTask.expectedEndDateOfTheTask = line;
                break;
            case "4":
                System.out.println("enter new content:");
                line = sc.nextLine();
                editedTask.status = line;
                break;
            case "5":
                System.out.println("enter new content:");
                line = sc.nextLine();
                editedTask.comment = line;
                break;
        }
        ObjectOutputStream out = new ObjectOutputStream
                (new FileOutputStream(file + ".dat"));
        out.writeObject(listWithTasks);
    }

    public void displayAllTasks(String file) throws NoSuchElementException {
        Scanner in = null;
        try {
            in = new Scanner(new FileInputStream(file + ".txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File is not exist!");
        }
        try {
            String line;
            while ((line = in.nextLine()) != null) {
                System.out.println(line);
            }
        } catch (NoSuchElementException e) {
            System.out.println();
        }
    }
}
