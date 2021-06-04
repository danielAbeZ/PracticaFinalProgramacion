import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PanelDeProductos extends JPanel{
    private ArrayList<BotonDeProducto> botones;

    /**
     * Método constructor que crea la lista de botones correspondiente y los configura en el panel.
     */
    public PanelDeProductos(String archivo, ListaDeProductos lista){
        botones = new ArrayList<BotonDeProducto>();
        crearBotones(archivo, lista);
        configurarPanel();
    }

    /**
     * Método que se encarga de configurar el panel.
     */
    private void configurarPanel(){
        //TODO: Cambiar el /2 por si hubiesen menos productos AKA añade un if o algo.
        GridLayout gridL = new GridLayout(botones.size()/2,0);
        gridL.setHgap(10);
        gridL.setVgap(10);
        this.setLayout(gridL);

        for(BotonDeProducto b: botones){
            this.add(b);
        }
    }

    /**
     * Método encargado de generar todos los botones que habrá en el panel mediante la lectura de un
     * fichero de texto ubicado en los recursos.
     */
    private void crearBotones(String archivo, ListaDeProductos lista){
        //TODO: Cambiar el catch por el error correcto.
        try {
            String rutaDeArchivo = "datos/"+archivo;
            List<String> productos = Files.readAllLines(Paths.get(rutaDeArchivo), Charset.defaultCharset());

            //Para cada una de las líneas, que será un producto, creamos un botón.
            for (String s: productos) {
                String[] segmentos = s.split(":");
                BotonDeProducto botonAux = new BotonDeProducto(segmentos[0], Double.parseDouble(segmentos[1]));
                botonAux.addActionListener( e-> {
                            ESListaDeProductos.insertaProducto(botonAux.getNombre(), botonAux.getPrecio(), lista);
                        });
                botones.add(botonAux);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<BotonDeProducto> getBotones(){
        return botones;
    }

}
