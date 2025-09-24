
package Libreria;

import java.util.LinkedList;

public class HashTableProductos {
    private LinkedList<Articulo>[] tabla;
    private int tamaño;

    public HashTableProductos(int tamaño) {
        this.tamaño = tamaño;
        tabla = new LinkedList[tamaño];
        for (int i = 0; i < tamaño; i++) {
            tabla[i] = new LinkedList<>();
   

