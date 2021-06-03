import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ESPanelDeProductos {
    public static void obtenerBotonesDeBorrado(PanelDeProductos panel, String lista) {
        ArrayList<String> productos = ESListaDeProductos.obtenerNombresEnLista(lista);
        ArrayList<BotonDeProducto> botones = panel.getBotones();
        ArrayList<BotonDeProducto> botonesParaActivar = ESPanelDeProductos.obtenerBotonesDeProductosEnLista(botones, productos);

        ESPanelDeProductos.desactivarBotones(botones);
        ESPanelDeProductos.activarBotones(botonesParaActivar);
    }

    private static ArrayList<BotonDeProducto> obtenerBotonesDeProductosEnLista(ArrayList<BotonDeProducto> botones, ArrayList<String> productosEnLista){
        ArrayList<BotonDeProducto> botonesParaActivar = new ArrayList<BotonDeProducto>();

        for (BotonDeProducto boton : botones) {
            for (String nombre: productosEnLista) {
                if (nombre.equals(boton.getNombre())) {
                    botonesParaActivar.add(boton);
                }
            }
        }

        return botonesParaActivar;
    }

    public static void desactivarBotones(ArrayList<BotonDeProducto> botones){
        for (BotonDeProducto boton: botones){
            boton.setEnabled(false);
        }
    }

    public static void activarBotones(ArrayList<BotonDeProducto> botones){
        for (BotonDeProducto boton: botones){
            boton.setEnabled(true);
        }
    }
}
