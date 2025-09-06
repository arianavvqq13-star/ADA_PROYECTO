
package Libreria;
import java.util.ArrayList;

public class AlgoritmosOrdenacion {
    // Ordenación Burbuja por Precio
    public static void burbujaPorPrecio(ArrayList<Articulo> lista) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lista.get(j).getPrecio() > lista.get(j+1).getPrecio()) {
                    // Intercambio
                    Articulo temp = lista.get(j);
                    lista.set(j, lista.get(j+1));
                    lista.set(j+1, temp);
                }
            }
        }
    }    
}
//hacer ordenacion interna , base de datos,sort  