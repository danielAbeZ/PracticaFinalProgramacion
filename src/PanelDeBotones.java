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
    public PanelDeBotones(String archivo){
        botones = new ArrayList<BotonDeProducto>();
        panel = new JPanel();
        crearBotones(archivo);
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
    public void crearBotones(String archivo){
        //TODO: Cambiar el catch por el error correcto.
        try {
            String rutaDeArchivo = "./datos/"+archivo;
            System.out.println(rutaDeArchivo);
            List<String> productos = Files.readAllLines(Paths.get(rutaDeArchivo), Charset.defaultCharset());

            for (String s: productos) {
                String[] segmentos = s.split(":");
                botones.add(new BotonDeProducto(segmentos[0], Double.parseDouble(segmentos[1])));
            }
        } catch (Exception e) {
            System.out.println("Ha habido un problema.");;
        }
    }

    public JPanel getPanel(){
        return panel;
    }

}
