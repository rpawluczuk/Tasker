import javax.swing.*;
import java.awt.*;

public class SwingApplication {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame Mainframe = new SwingMainFrame();
                SwingMainButtonPanel buttonPanel = new SwingMainButtonPanel();

                Mainframe.add(buttonPanel);
                buttonPanel.setBounds(100,100,200,100);
            }
        });

    }
}
