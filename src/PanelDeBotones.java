import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PanelDeBotones extends JPanel{
    private List<BotonDeProducto> botones;
    private JPanel panel;

    /**
     * Método constructor que crea la lista de botones correspondiente y los configura en el panel.
     */
    public PanelDeBotones(String archivo, ListaDeProductos lista){
        botones = new ArrayList<BotonDeProducto>();
        panel = new JPanel();
        crearBotones(archivo, lista);
        configurarPanel();
    }

    /**
     * Método que se encarga de configurar el panel.
     */
    public void configurarPanel(){
        panel = new JPanel();
        GridLayout gridL = new GridLayout(botones.size()/2,0);
        gridL.setHgap(10);
        gridL.setVgap(10);
        panel.setLayout(gridL);

        for(BotonDeProducto b: botones){
            panel.add(b.getBoton());
        }
    }

    /**
     * Método encargado de generar todos los botones que habrá en el panel mediante la lectura de un
     * fichero de texto ubicado en los recursos.
     */
    private void crearBotones(String archivo, ListaDeProductos lista){
        //TODO: Cambiar el catch por el error correcto.
        try {
            String rutaDeArchivo = "./datos/"+archivo;
            System.out.println(rutaDeArchivo);
            List<String> productos = Files.readAllLines(Paths.get(rutaDeArchivo), Charset.defaultCharset());

            //Para cada una de las líneas, que será un producto, creamos un botón.
            for (String s: productos) {
                String[] segmentos = s.split(":");
                BotonDeProducto botonAux = new BotonDeProducto(segmentos[0], Double.parseDouble(segmentos[1]));
                botonAux.getBoton().addActionListener( e-> {
                            ESAreaDeTexto.insertaProducto(botonAux.getNombre(), botonAux.getPrecio(), lista);
                        });
                botones.add(botonAux);
            }
        } catch (Exception e) {
            System.out.println("Ha habido un problema.");;
        }
    }

    public JPanel getPanel(){
        return panel;
    }

}
