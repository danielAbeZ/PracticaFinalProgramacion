import javax.swing.*;

public class BotonDeProducto extends JButton{
    private String nombre;
    private double precio;
    private ImageIcon imagen;

    /**
     * Constructor base de la clase.
     * @param nombre: Nombre del producto
     * @param precio: Precio del producto
     */
    public BotonDeProducto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
        this.setText(nombre);
    }

    /**
     * Constructor de la clase. También se le pasa la dirección que le dará la imagen al botón.
     * @param nombre: Nombre del producto
     * @param precio: Precio del producto
     * @param imagen: Imagen mostrada en el botón que representa al producto
     */
    public BotonDeProducto(String nombre, double precio, String imagen){
        this(nombre, precio);
        this.imagen = new ImageIcon(imagen);
    }

    /**
     * Método que aporta la funcionalidad al botón. Según el modo en el que se encuentre el programa, realizará
     * la acción de añadido o borrado de un producto que reciba por parámetro.
     * @param nombre: nombre del producto sobre el que se quiere realizar la operación.
     * @param precio: precio del producto sobre el que se quiere realizar la operación.
     * @param lista: lista en la que se quiere realizar la acción con el producto.
     */
    public void realizarOperacion(String nombre, double precio, ListaDeProductos lista){
        boolean estaAnyadiendo = Programa.isModoAnyadir();
        if(estaAnyadiendo){
            ESListaDeProductos.insertaProducto(nombre, precio, lista);
        }
        else{
            ESListaDeProductos.borraProducto(nombre, precio, lista);
            ESPanelDeProductos.obtenerBotonesDeBorrado(Programa.getPanelActivo(), lista);
        }
    }

    /**
     * Método para obtener el nombre de un producto.
     * @return nombre: nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para obtener el precio de un producto.
     * @return precio: precio del producto
     */
    public double getPrecio(){
        return precio;
    }

    /**
     * Método para obtener la imagen del botón que representa un producto.
     * @return imagen: un ImageIcon que será el que se vea en la representación del botón
     */
    public ImageIcon getImagen() {
        return imagen;
    }

    /**
     * Método para cambiar la imagen del botón de un producto.
     * @param imagen: dirección de la ubicación de la imagen nueva
     */
    public void setImagen(String imagen) {
        this.imagen = new ImageIcon(imagen);
    }
}
