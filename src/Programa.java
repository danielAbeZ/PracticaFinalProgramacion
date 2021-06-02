import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Programa extends JPanel{

    public Programa() {
        configurarPanel();
    }

    private void configurarPanel(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5,5,5,5);
        Border borde = BorderFactory.createLineBorder(Color.lightGray);

        PanelDeBotones panelBotones = new PanelDeBotones("canyas.txt");

        constraints.gridx = 0;
        constraints.gridy = 0;
        panelBotones.getPanel().setBorder(borde);
        this.add(panelBotones.getPanel(),constraints);

    }
}
