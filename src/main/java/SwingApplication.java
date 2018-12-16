import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

public class SwingApplication {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame Mainframe = new SwingMainFrame();
                SwingMainButtonPanel buttonPanel = new SwingMainButtonPanel();

                JPanel jp2 = new JPanel();
                JTextField textField = new JTextField(30);
                JLabel label = new JLabel();
                JButton confirmButton = new JButton("Confirm");
                jp2.setLayout(new GridLayout(4,1));
                Mainframe.add(jp2);
                jp2.add(buttonPanel);
                jp2.add(label);
                jp2.add(textField);
                jp2.add(confirmButton);


            }
        });

    }

    static class SwingMainFrame extends JFrame {
        SwingMainFrame(){
            super("Tasker");
            setSize(400,400);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    static class SwingMainButtonPanel extends JPanel {
        public SwingMainButtonPanel(){
            super();
            setLayout(new GridLayout(1,3));
            JButton buttonAddNewTask = new MainButton("Add new task");
            JButton buttonDisplayAllTasks = new MainButton("Display all tasks");
            JButton buttonEditTask = new MainButton("Edit task");

            add(buttonAddNewTask);
            add(buttonDisplayAllTasks);
            add(buttonEditTask);

            SwingMainButtonAction addNewTask = new SwingMainButtonAction(1);
            SwingMainButtonAction displayAllTask = new SwingMainButtonAction(2);
            SwingMainButtonAction editTask = new SwingMainButtonAction(3);

            buttonAddNewTask.addActionListener(addNewTask);
            buttonDisplayAllTasks.addActionListener(displayAllTask);
            buttonEditTask.addActionListener(editTask);


        }
    }

    static class MainButton extends JButton{
        MainButton(String title){
            super();
            setSize(300,40);
            setText(title);
        }
    }

    static class SwingMainButtonAction implements ActionListener {

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
//                    line = sc.next();

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






}
