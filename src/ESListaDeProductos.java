public class ESListaDeProductos {
    public static void insertaProducto(String nombre, double precio, ListaDeProductos lista){
        lista.insertaProducto(nombre, precio);
        lista.actualizaLista();
    }
}
