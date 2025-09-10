
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
        System.out.println("Lista ordenada por precio de forma ascendente ");
    }
    //Ordenacion Seleccion por stock 
    public static void seleccion (ArrayList<Articulo> lista) {
        for(int i=0; i < lista.size()-1; i++){
            int indiceMin=i;
            for (int j = 0; j < lista.size() ; j++){
                if(lista.get(j).getStock()<lista.get(indiceMin).getStock()){
                    indiceMin=j;
                }
            }
            //INTERCAMBIO
            Articulo temp=lista.get(i);
            lista.set(i,lista.get(indiceMin));
            lista.set(indiceMin,temp);
        }
        System.out.println("Lista ordenada por stock(seleccion)");
        
    }
    //Ordenacion Insercion por Nombre 
    public static void insercion (ArrayList<Articulo> lista) {
        for(int i=1;i<lista.size();i++){
            Articulo key=lista.get(i);
             int j=i-1;
             
             while(j>=0 && lista.get(j).getNombre().compareToIgnoreCase(key.getNombre())>0){
                 lista.set(j+1,lista.get(j));
                 j=j-1;
             }
        lista.set (j+1,key)  ;   
        }
        System.out.println("Lista ordenada por nombre");
    }
}

//Ordenacion por inserccion 
//hacer ordenacion interna , base de datos,sort     