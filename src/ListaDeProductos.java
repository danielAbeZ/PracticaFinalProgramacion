import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ListaDeProductos extends JPanel {
    private TreeMap<String, Double> listaActual;
    private JTextArea areaDeTexto;

    /**
     * Método constructor de la clase. Inicializa las variables de la misma.
     */
    public ListaDeProductos(){
        listaActual = new TreeMap<String, Double>();
        areaDeTexto = new JTextArea("");
        areaDeTexto.setEditable(false);
        this.add(areaDeTexto);
    }

    public void insertaProducto(String nombre, double precio) {

        if(listaActual.get(nombre) == null){
            listaActual.put(nombre, precio);
        }
        else{
            double precioProducto = listaActual.get(nombre);
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

        for (Map.Entry<String, Double> entrada : listaActual.entrySet()) {
            salida = salida + entrada.getKey() + " - " + entrada.getValue() + "\r\n";
        }

        return salida;
    }

    /**
     * Método que actualiza el área de texto con los datos actuales de la lista de Productos.
     */
    public void actualizaLista(){
        this.areaDeTexto.setText(imprimeLista());
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
    }
}
