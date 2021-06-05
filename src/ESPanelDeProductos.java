import java.util.ArrayList;

public class ESPanelDeProductos {

    /**
     * Método que, dados una serie de botones y los productos actuales de una lista, obtiene un ArrayList con aquellos
     * botones que correspondan a productos que se encuentren en la lista.
     * @param botones: serie de botones de un PanelDeProductos.
     * @param productosEnLista: información del área de texto de una ListaDeProductos.
     * @return botonesParaActivar: lista de botones correspondientes a los productos que haya en la lista.
     */
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

    /**
     * Método que deja activos únicamente aquellos botones de un PanelDeProductos que hagan referencia
     * a productos que haya en una ListaDeProductos.
     * @param panel: PanelDeProductos del que queremos dejar activos los botones correspondientes.
     * @param lista: ListaDeProductos que contiene información de los productos añadidos actualmente.
     */
    public static void obtenerBotonesDeBorrado(PanelDeProductos panel, ListaDeProductos lista) {
        ArrayList<String> productos = ESListaDeProductos.obtenerNombresEnLista(lista);
        ArrayList<BotonDeProducto> botones = panel.getBotones();
        ArrayList<BotonDeProducto> botonesParaActivar = ESPanelDeProductos.obtenerBotonesDeProductosEnLista(botones, productos);

        ESPanelDeProductos.desactivarBotones(botones);
        ESPanelDeProductos.activarBotones(botonesParaActivar);
    }

    /**
     * Método para activar una serie de BotonDeProducto pasados por parámetro.
     * @param botones: ArrayList con BotonDeProducto que se desean activar.
     */
    public static void activarBotones(ArrayList<BotonDeProducto> botones){
        for (BotonDeProducto boton: botones){
            boton.setEnabled(true);
        }
    }

    /**
     * Método para desactivar una serie de BotonDeProducto pasados por parámetro.
     * @param botones: ArrayList con BotonDeProducto que se desean desactivar.
     */
    public static void desactivarBotones(ArrayList<BotonDeProducto> botones){
        for (BotonDeProducto boton: botones){
            boton.setEnabled(false);
        }
    }
}
