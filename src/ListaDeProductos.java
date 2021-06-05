import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

public class ListaDeProductos extends JPanel {
    private TreeMap<String, Double> productos;
    private JTextArea areaDeTexto;

    /**
     * Método constructor de la clase. Inicializa las variables de la misma.
     */
    public ListaDeProductos(){
        productos = new TreeMap<String, Double>();
        areaDeTexto = new JTextArea("");
        areaDeTexto.setEditable(false);
        this.setLayout(new BorderLayout());
        this.add(areaDeTexto);
    }

    /**
     * Método para insertar un producto en una ListaDeProductos.
     * @param nombre: nombre del producto a insertar.
     * @param precio: precio del producto a insertar.
     */
    public void insertaProducto(String nombre, double precio) {

        if(productos.get(nombre) == null){
            productos.put(nombre, precio);
        }
        else{
            double precioProducto = productos.get(nombre);
            precioProducto = precioProducto + precio;
            productos.put(nombre, precioProducto);
        }
    }

    /**
     * Método para borrar una unidad de un producto en una ListaDeProductos. Si es la única, se borra directamente el
     * producto entero.
     * @param nombre: nombre del producto que se desea eliminar.
     * @param precioBase: precio base del producto que se desea eliminar.
     */
    public void borraProducto(String nombre, double precioBase){
        if(productos.get(nombre) != null){
            if(productos.get(nombre) > precioBase){
                double precioProducto = productos.get(nombre);
                precioProducto = precioProducto - precioBase;
                productos.put(nombre, precioProducto);
            }
            else {
                productos.remove(nombre);
            }
        }
    }

    /**
     * Método que actualiza el área de texto con los datos actuales de la lista de Productos.
     */
    public void actualizaLista(){
        this.areaDeTexto.setText(ESListaDeProductos.imprimeLista(this));
    }

    /**
     * Método que devuelve el TreeMap con los productos actuales de una ListaDeProductos.
     * @return productos: TreeMap con los productos de una ListaDeProductos.
     */
    public TreeMap<String, Double> getProductos(){
        return productos;
    }

    /**
     * Método que devuelve la información del área de texto de una ListaDeProductos.
     * @return información del área de texto en formato de String.
     */
    public String getTexto(){
        return areaDeTexto.getText();
    }

    /**
     * Método que cambia la información del área de texto de una ListaDeProductos por el texto contenido en un String
     * pasado por parámetro.
     * @param nuevaInformacion: cadena de texto que sustituirá el área de texto de una ListaDeProductos.
     */
    public void setTexto(String nuevaInformacion){
        areaDeTexto.setText(nuevaInformacion);
    }
}
