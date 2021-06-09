import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame programaPrincipal = new JFrame("TPV");
        programaPrincipal.setResizable(false);
        programaPrincipal.add(new Programa());

        programaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        programaPrincipal.pack();
        programaPrincipal.setVisible(true);
    }
}
