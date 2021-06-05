import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Programa extends JPanel{

    private static PanelDeProductos panelActivo;
    private static boolean modoAnyadir = true;

    public Programa() {
        configurarPanel();
    }

    private void configurarPanel(){
        //Configuramos el layout del Panel, así como la creación de las constraints y el borde que tendrán
        //los elementos.
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        Insets insets = new Insets(5,5,5,5);
        Border borde = BorderFactory.createLineBorder(Color.lightGray);

        //Configuración del panel con el área de texto que muestra la lista actual de productos.
        ListaDeProductos listaProductos = new ListaDeProductos();
        listaProductos.setBorder(borde);
        constraints = creaConstraints(2,0,2,3, insets, GridBagConstraints.BOTH);
        this.add(listaProductos, constraints);

        //Configuración del panel con los productos de tipo "Canyas".
        PanelDeProductos panelProductosCanyas = new PanelDeProductos("canyas.txt", listaProductos);
        constraints = creaConstraints(0,0,2,2, insets, GridBagConstraints.NONE);
        panelProductosCanyas.setBorder(borde);
        this.add(panelProductosCanyas,constraints);

        panelActivo = panelProductosCanyas;

        //Configuración del panel con los productos de tipo "Sedales".
        PanelDeProductos panelProductosSedales = new PanelDeProductos("sedales.txt", listaProductos);
        panelProductosSedales.setBorder(borde);
        panelProductosSedales.setVisible(false);
        this.add(panelProductosSedales,constraints);

        //Configuración del panel con los productos de tipo "Cebos".
        PanelDeProductos panelProductosCebos = new PanelDeProductos("cebos.txt", listaProductos);
        panelProductosCebos.setBorder(borde);
        panelProductosCebos.setVisible(false);
        this.add(panelProductosCebos,constraints);

        //Configuración del panel con los botones para añadir o quitar productos.
        //TODO: Crear un método para crear y darle funcionalidad al panel.
        JPanel opcionProductos = new JPanel();
        JButton botonAnyadir = new JButton("Añadir");
        JButton botonQuitar = new JButton("Quitar");
        botonAnyadir.setEnabled(false);
        opcionProductos.add(botonAnyadir);
        opcionProductos.add(botonQuitar);
        opcionProductos.setBorder(borde);

        botonAnyadir.addActionListener( e-> {
            ESPanelDeProductos.activarBotones(panelActivo.getBotones());
            botonAnyadir.setEnabled(false);
            botonQuitar.setEnabled(true);
            modoAnyadir = true;
        });

        botonQuitar.addActionListener( e ->{
            ESPanelDeProductos.obtenerBotonesDeBorrado(panelActivo, listaProductos);
            botonAnyadir.setEnabled(true);
            botonQuitar.setEnabled(false);
            modoAnyadir = false;
        });

        constraints = creaConstraints(0,2,2,1, insets, GridBagConstraints.NONE);
        this.add(opcionProductos, constraints);

        //Configuración del panel con los botones para cambiar el tipo de productos mostrados.
        //TODO: Crear un método para crear y darle funcionalidad al panel.
        JPanel tiposDeProductos = new JPanel();
        JButton botonCanya = new JButton("Cañas");
        JButton botonSedal = new JButton("Sedales");
        JButton botonCebo = new JButton("Cebos");
        botonCanya.setEnabled(false);
        tiposDeProductos.add(botonCanya);
        tiposDeProductos.add(botonSedal);
        tiposDeProductos.add(botonCebo);
        tiposDeProductos.setBorder(borde);

        botonCanya.addActionListener( e -> {
            panelProductosCanyas.setVisible(true);
            panelProductosSedales.setVisible(false);
            panelProductosCebos.setVisible(false);

            botonCanya.setEnabled(false);
            botonSedal.setEnabled(true);
            botonCebo.setEnabled(true);

            panelActivo = panelProductosCanyas;
            ESPanelDeProductos.activarBotones(panelActivo.getBotones());
            if(!modoAnyadir){
                ESPanelDeProductos.obtenerBotonesDeBorrado(panelActivo, listaProductos);
            }
        });

        botonSedal.addActionListener( e -> {
            panelProductosCanyas.setVisible(false);
            panelProductosSedales.setVisible(true);
            panelProductosCebos.setVisible(false);

            panelActivo = panelProductosSedales;

            botonCanya.setEnabled(true);
            botonSedal.setEnabled(false);
            botonCebo.setEnabled(true);

            panelActivo = panelProductosSedales;
            ESPanelDeProductos.activarBotones(panelActivo.getBotones());
            if(!modoAnyadir){
                ESPanelDeProductos.obtenerBotonesDeBorrado(panelActivo, listaProductos);
            }
        });

        botonCebo.addActionListener( e -> {
            panelProductosCanyas.setVisible(false);
            panelProductosSedales.setVisible(false);
            panelProductosCebos.setVisible(true);
            panelActivo = panelProductosCebos;
            botonCanya.setEnabled(true);
            botonSedal.setEnabled(true);
            botonCebo.setEnabled(false);
            ESPanelDeProductos.activarBotones(panelActivo.getBotones());
            if(!modoAnyadir){
                ESPanelDeProductos.obtenerBotonesDeBorrado(panelActivo, listaProductos);
            }
        });


        constraints = creaConstraints(0,3,2,1, insets, GridBagConstraints.NONE);
        this.add(tiposDeProductos, constraints);

        //Configuración del panel con las opciones adicicionales.
        //TODO: Crear un método para crear y darle funcionalidad al panel.
        JPanel opcionesAdicionales = new JPanel();
        JButton botonMuestra = new JButton("Muestra ticket");
        JButton botonImprime = new JButton("Imprime ticket");
        opcionesAdicionales.add(botonMuestra);
        opcionesAdicionales.add(botonImprime);
        opcionesAdicionales.setBorder(borde);

        constraints = creaConstraints(2,3,2,1, insets, GridBagConstraints.NONE);
        this.add(opcionesAdicionales, constraints);
    }

    private GridBagConstraints creaConstraints(int posx, int posy, int ancho, int alto, Insets insets, int fill){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = posx;
        constraints.gridy = posy;
        constraints.gridwidth = ancho;
        constraints.gridheight = alto;
        constraints.fill = fill;
        constraints.insets = insets;

        return constraints;
    }

    public GridBagConstraints creaConstraints(int posx, int posy, int ancho, int alto, Insets insets, int fill, int anchor){
        GridBagConstraints constraints = creaConstraints(posx,posy,ancho,alto,insets,fill);
        constraints.anchor = anchor;

        return constraints;
    }

    public static PanelDeProductos getPanelActivo(){
        return panelActivo;
    }

    public static boolean isModoAnyadir(){
        return modoAnyadir;
    }

}
