import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame programaPrincipal = new JFrame("TPV");
        programaPrincipal.add(new Programa());

        //frame.setSize(600,600);
        programaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        programaPrincipal.pack();
        programaPrincipal.setVisible(true);
    }
}
