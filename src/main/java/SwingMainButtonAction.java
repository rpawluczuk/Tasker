import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

public class SwingMainButtonAction implements ActionListener {

    private int number;

    public SwingMainButtonAction(int number){
        this.number = number;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Task task = new Task();
        Database database = new Database();
        Scanner sc = new Scanner(System.in);
        String line = " ";
        switch(number) {
            case 1: {
                task.createTask();
                try {
                    database.addTask(task);
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                break;
            }
            case 2: {
                System.out.println("Enter the name of new database:");
                line = sc.next();
                try {
                    database.displayDatabase(line);
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                break;
            }
            case 3: {
                System.out.println("Enter the name of new database:");
                line = sc.next();
                try {
                    database.editTask(line);
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                break;
            }
        }
    }
}
