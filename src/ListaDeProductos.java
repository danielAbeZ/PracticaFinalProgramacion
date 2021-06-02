import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ListaDeProductos extends JPanel {
    private TreeMap<String, Integer> listaActual;
    private JTextArea areaDeTexto;

    /**
     * Método constructor de la clase. Inicializa las variables de la misma.
     */
    public ListaDeProductos(){
        listaActual = new TreeMap<String, Integer>();
        areaDeTexto = new JTextArea("");
    }

    public void insertaProducto(String nombre, int precio) {

        if(listaActual.get(nombre) == null){
            listaActual.put(nombre, precio);
        }
        else{
            int precioProducto = listaActual.get(nombre);
            precioProducto = precioProducto + precio;
            listaActual.put(nombre, precioProducto);
        }
    }

    /**
     * Método que lee todos los elementos que se encuentran actualmente en la lista de la compra y que
     * los añade a una cadena. Esa cadena será devuelta al final de la ejecución del mismo.
     * @return salida: cadena con todos los productos actuales listados.
     */
    public String imprimeLista(){
        String salida = "";

        for (Map.Entry<String, Integer> entrada : listaActual.entrySet()) {
            salida = salida + entrada.getKey() + " - " + entrada.getValue() + "\r\n";
        }

        return salida;
    }

    /**
     * Método para realizar pruebas de la clase. Será borrado posteriormente.
     * @param args
     */
    public static void main(String[] args) {
        ListaDeProductos miLista = new ListaDeProductos();
        miLista.insertaProducto("Patata", 10);
        miLista.insertaProducto("Manzana", 75);
        miLista.insertaProducto("Patata", 2);
        System.out.println(miLista.imprimeLista());
    }
}
