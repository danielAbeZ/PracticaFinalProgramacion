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
     * Método que permite borrar un producto ya existente en una ListaDeProductos. Una vez borrado, actualiza
     * la información mostrada por pantalla al usuario.
     * @param nombre: nombre del producto a borrar.
     * @param precio: precio del producto a borrar.
     * @param lista: lista en la que se desea borrar el producto.
     */
    public static void borraProducto(String nombre, double precio, ListaDeProductos lista){
        lista.borraProducto(nombre, precio);
        lista.actualizaLista();
    }

    /**
     * Método que obtiene el precio total de todos los productos que hayan en una ListaDeProductos.
     * @param lista: ListaDeProductos de la que se quiere obtener el precio total.
     * @return precioTotal: suma del precio de todos los productos de la ListaDeProductos.
     */
    public static double obtenerTotal(ListaDeProductos lista){
        double precioTotal = 0.0;

        for(Map.Entry<String, Double> producto: lista.getProductos().entrySet()){
            precioTotal = precioTotal + producto.getValue();
        }

        return precioTotal;
    }

    /**
     * Método que lee todos los productos que se encuentran actualmente en una ListaDeProductos
     * y que los añade a una cadena, junto a la suma de los precios de todos ellos. Esa cadena
     * será devuelta al final de la ejecución del mismo.
     * @return salida: cadena con todos los productos actuales de una ListaDeProductos.
     */
    public static String imprimeLista(ListaDeProductos lista){
        String salida = "";
        TreeMap<String, Double> productos = lista.getProductos();

        for (Map.Entry<String, Double> entrada : productos.entrySet()) {
            salida = salida + lista.obtenCantidadProducto(entrada.getKey()) + " x " + entrada.getKey() + " - " + entrada.getValue() + "\r\n";
        }
        if(!salida.equals("")){
            salida = salida + "-------------------------------\r\n";
            salida = salida + "Total: " + obtenerTotal(lista);
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
        ArrayList<String> primeraParteLineas = new ArrayList<String>();
        ArrayList<String> nombresDeProductos = new ArrayList<String>();


        for (String linea: lineasDeLista) {
            String[] separados = linea.split(" - ");
            String datosProducto = separados[0];
            primeraParteLineas.add(datosProducto);
        }

        if(primeraParteLineas.size() > 1){
            primeraParteLineas.remove((primeraParteLineas.size()-1));
            primeraParteLineas.remove((primeraParteLineas.size()-1));

            for (String linea: primeraParteLineas) {
                String[] datosSeparados = linea.split(" ");
                String nombreProducto = datosSeparados[2];
                nombresDeProductos.add(nombreProducto);
            }
        }


        return nombresDeProductos;
    }
}
