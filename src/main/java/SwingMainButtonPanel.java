import javax.swing.*;

public class SwingMainButtonPanel extends JPanel {
    public SwingMainButtonPanel(){
        super();
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

class MainButton extends JButton{
    MainButton(String title){
        super();
        setSize(300,40);
        setText(title);
    }
}
