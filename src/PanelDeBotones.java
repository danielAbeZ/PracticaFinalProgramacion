import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PanelDeBotones {
    private List<BotonDeProducto> botones;
    private JPanel panel;

    /**
     * Método constructor que crea la lista de botones correspondiente y los configura en el panel.
     */
    public PanelDeBotones(){
        botones = new ArrayList<BotonDeProducto>();
        panel = new JPanel();
        crearBotones();
        configurarPanel();
    }

    /**
     * Método que se encarga de configurar el panel.
     */
    public void configurarPanel(){
        panel = new JPanel();
        GridLayout gridL = new GridLayout();
        gridL.setHgap(5);
        gridL.setVgap(5);
        panel.setLayout(gridL);

        for(BotonDeProducto b: botones){
            panel.add(b.getBoton());
        }
    }

    /**
     * Método encargado de generar todos los botones que habrá en el panel mediante la lectura de un
     * fichero de texto ubicado en los recursos.
     */
    public void crearBotones(){
        //TODO: Cambiar el catch por el error correcto.
        try {
            List<String> productos = Files.readAllLines(Paths.get("./datos/productos.txt"), Charset.defaultCharset());

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
