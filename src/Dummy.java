import javax.swing.*;
import java.awt.*;

public class Dummy {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        PanelDeBotones panel = new PanelDeBotones();
        frame.setLayout(new GridLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);

        frame.add(panel.getPanel());

        frame.setVisible(true);
    }
}
