import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ESListaDeProductos {
    /**
     * Método que permite insertar un producto nuevo o ya existente en una ListaDeProductos. Una vez introducido,
     * actualiza la información mostrada al usuario.
     * @param nombre: nombre del producto a insertar.
     * @param precio: precio del producto a insertar.
     * @param lista: ListaDeProductos en la que se quiere introducir el producto.
     */
    public static void insertaProducto(String nombre, double precio, ListaDeProductos lista){
        lista.insertaProducto(nombre, precio);
        lista.actualizaLista();
    }

    /**
     * Método que lee todos los productos que se encuentran actualmente en una ListaDeProductos
     * y que los añade a una cadena. Esa cadena será devuelta al final de la ejecución del mismo.
     * @return salida: cadena con todos los productos actuales de una ListaDeProductos.
     */
    public static String imprimeLista(ListaDeProductos lista){
        String salida = "";
        TreeMap<String, Double> productos = lista.getProductos();

        for (Map.Entry<String, Double> entrada : productos.entrySet()) {
            salida = salida + entrada.getKey() + " - " + entrada.getValue() + "\r\n";
        }

        return salida;
    }

    /**
     * Método que obtiene los nombres de todos los productos que haya actualmente en una ListaDeProductos, y
     * que los devuelve en un ArrayList de Strings.
     * @param lista: ListaDeProductos de la que queremos extraer los nombres de los productos.
     * @return nombresDeProductos: ArrayList con los nombres de los productos en la lista.
     */
    public static ArrayList<String> obtenerNombresEnLista(ListaDeProductos lista){
        String[] lineasDeLista = lista.getTexto().split("\r\n");
        ArrayList<String> nombresDeProductos = new ArrayList<String>();

        for (String linea: lineasDeLista) {
            String[] separados = linea.split(" - ");
            String nombreProducto = separados[0];
            nombresDeProductos.add(nombreProducto);
        }

        return nombresDeProductos;
    }
}
