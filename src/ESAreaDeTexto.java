public class ESAreaDeTexto {
    public static void insertaProducto(String nombre, double precio, ListaDeProductos lista){
        lista.insertaProducto(nombre, (int)precio);
        lista.actualizaLista();
    }
}
