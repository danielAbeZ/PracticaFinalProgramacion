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
        Insets insets = new Insets(5,15,5,5);
        Border borde = BorderFactory.createLineBorder(Color.lightGray);

        //Configuración del panel con el área de texto que muestra la lista actual de productos.
        JLabel labelLista = new JLabel("Lista Actual");
        constraints = creaConstraints(3,0,3,1, insets, GridBagConstraints.BOTH);
        this.add(labelLista, constraints);

        ListaDeProductos listaProductos = new ListaDeProductos();
        listaProductos.setBorder(borde);
        constraints = creaConstraints(3,1,3,7, insets, GridBagConstraints.BOTH);
        this.add(listaProductos, constraints);


        JLabel labelProductos = new JLabel("Lista de productos");
        constraints = creaConstraints(0,0,3,1, insets, GridBagConstraints.BOTH);
        this.add(labelProductos, constraints);

        //Configuración del panel con los productos de tipo "Canyas".
        PanelDeProductos panelProductosCanyas = new PanelDeProductos("canyas.txt", listaProductos);
        insets = new Insets(5,5,5,5);
        constraints = creaConstraints(0,1,3,5, insets, GridBagConstraints.BOTH);
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

        constraints = creaConstraints(0,6,3,1, insets, GridBagConstraints.VERTICAL);
        this.add(opcionProductos, constraints);

        //Configuración del panel con los botones para cambiar el tipo de productos mostrados.
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


        constraints = creaConstraints(0,8,3,1, insets, GridBagConstraints.VERTICAL);
        this.add(tiposDeProductos, constraints);

        //Configuración del panel con las opciones adicicionales.
        JPanel opcionesAdicionales = new JPanel();
        JButton botonMuestra = new JButton("Muestra ticket");
        JButton botonImprime = new JButton("Imprime ticket");
        opcionesAdicionales.add(botonMuestra);
        opcionesAdicionales.add(botonImprime);
        opcionesAdicionales.setBorder(borde);

        botonMuestra.addActionListener( e -> {
            Programa.muestraTicket(listaProductos);
        });

        botonImprime.addActionListener( e -> {
            Programa.imprimeTicket(listaProductos);
        });

        constraints = creaConstraints(3,8,3,1, insets, GridBagConstraints.BOTH);
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

    /**
     * Método que devuelve el panelActivo del Programa.
     * @return panelActivo: PanelDeProductos actualmente en uso del Programa.
     */
    public static PanelDeProductos getPanelActivo(){
        return panelActivo;
    }

    /**
     * Método que devuelve el booleano para saber si se están añadiendo o borrando productos.
     * @return modoAnyadir: booleano que informa de si se está quitando o poniendo productos.
     */
    public static boolean isModoAnyadir(){
        return modoAnyadir;
    }

    /**
     * Método que permite la función de imprimir tickets.
     * @param lista: listaDeProductos con los datos para imprimir.
     */
    public static void imprimeTicket(ListaDeProductos lista){
        if(lista.getTexto() != null && lista.getTexto() != ""){
            try {
                lista.getAreaDeTexto().print(null, null, true, null, null, true);
            } catch (java.awt.print.PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Método que muestra un ticket por pantalla.
     * @param lista: ListaDeProductos con los datos que se quieren mostrar.
     */
    public static void muestraTicket(ListaDeProductos lista){
        JOptionPane.showMessageDialog(null, lista.getAreaDeTexto().getText());
    }

}
