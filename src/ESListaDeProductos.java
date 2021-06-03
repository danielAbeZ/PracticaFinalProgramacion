import java.lang.reflect.Array;
import java.util.ArrayList;

public class ESListaDeProductos {
    public static void insertaProducto(String nombre, double precio, ListaDeProductos lista){
        lista.insertaProducto(nombre, precio);
        lista.actualizaLista();
    }

    public static ArrayList<String> obtenerNombresEnLista(String lista){
        String[] lineasDeLista = lista.split("\r\n");
        ArrayList<String> nombresDeProductos = new ArrayList<String>();

        for (String linea: lineasDeLista) {
            String[] separados = linea.split(" - ");
            String nombreProducto = separados[0];
            nombresDeProductos.add(nombreProducto);
        }

        return nombresDeProductos;
    }
}
