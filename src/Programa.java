import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Programa extends JPanel{

    public Programa() {
        configurarPanel();
    }

    private void configurarPanel(){
        //Configuramos el layout del Panel, así como la creación de las constraints para permitir un mejor visualizado
        //de los componentes.
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5,5,5,5);
        Border borde = BorderFactory.createLineBorder(Color.lightGray);

        //Configuración del panel con el área de texto que muestra la lista actual de productos.
        ListaDeProductos listaProductos = new ListaDeProductos();
        listaProductos.setBorder(borde);

        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(listaProductos, constraints);

        //Configuración del panel de los botones que hacne referencia a los productos.
        PanelDeBotones panelBotones = new PanelDeBotones("canyas.txt", listaProductos);
        constraints.gridx = 0;
        constraints.gridy = 0;
        panelBotones.getPanel().setBorder(borde);
        this.add(panelBotones.getPanel(),constraints);

        //Configuración del panel con los botones para cambiar el tipo de productos mostrados.
        JPanel tiposDeProductos = new JPanel();
        JButton botonCanya = new JButton("Cañas");
        JButton botonSedal = new JButton("Sedales");
        JButton botonCebo = new JButton("Cebos");
        tiposDeProductos.add(botonCanya);
        tiposDeProductos.add(botonSedal);
        tiposDeProductos.add(botonCebo);
        tiposDeProductos.setBorder(borde);

        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(tiposDeProductos, constraints);
    }
}
