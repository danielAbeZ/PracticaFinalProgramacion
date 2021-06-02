/*
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Pruebas {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        PanelDeBotones panelDeProductos = new PanelDeBotones("canyas.txt");

        frame.setLayout(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        cs.insets = new Insets(5,5,5,5);

        JPanel panelBotonsitos = new JPanel();
        JButton botonPalos = new JButton("palos");
        JButton botonSedal = new JButton("sedalitso");
        panelBotonsitos.add(botonPalos);
        panelBotonsitos.add(botonSedal);
        Border bordeBotones = BorderFactory.createLineBorder(Color.lightGray);
        panelBotonsitos.setBorder(bordeBotones);

        JTextArea area = new JTextArea("Hey que pasa pilluelos");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridheight = 1;
        frame.add(panelDeProductos.getPanel(),cs);

        cs.insets = new Insets(5,10,5,5);
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridheight = 0;
        frame.add(panelBotonsitos,cs);

        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridheight = 1;
        cs.gridwidth = 1;
        cs.weighty = 1;
        cs.anchor = GridBagConstraints.NORTH;
        cs.fill = GridBagConstraints.VERTICAL;
        frame.add(area,cs);

        //frame.setSize(600,600);
        frame.pack();
        frame.setVisible(true);
    }
}
*/