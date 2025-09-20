
package Libreria;

import java.util.LinkedList;

public class HashTableProductos {
    private LinkedList<Articulo>[] tabla;
    private int tamaño;

    // Constructor: inicializamos la tabla con listas vacías
    @SuppressWarnings("unchecked")
    public HashTableProductos(int tamaño) {
        this.tamaño = tamaño;
        tabla = new LinkedList[tamaño];
        for (int i = 0; i < tamaño; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    // Función hash (basada en el código del artículo)
    private int hash(String codigo) {
        return Math.abs(codigo.hashCode()) % tamaño;
    }

    // Insertar artículo en la tabla
    public void insertar(Articulo articulo) {
        int indice = hash(articulo.getCodigo());
        tabla[indice].add(articulo);
        System.out.println("Artículo " + articulo.getNombre() + " insertado en índice " + indice);
    }

    // Buscar artículo por código
    public Articulo buscar(String codigo) {
        int indice = hash(codigo);
        for (Articulo art : tabla[indice]) {
            if (art.getCodigo().equals(codigo)) {
                return art;
            }
        }
        return null; // no encontrado
    }

    // Mostrar toda la tabla
    public void mostrarTabla() {
        for (int i = 0; i < tamaño; i++) {
            System.out.print(i + ": ");
            for (Articulo art : tabla[i]) {
                System.out.print("[" + art.getCodigo() + " - " + art.getNombre() + "] ");
            }
            System.out.println();
        }
    }
}   
