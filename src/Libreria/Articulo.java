
package Libreria;

public class Articulo {
//  Atributos que describen las propiedades del Articulo
    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private String marca;
    private String presentacion;
    private int stock;
    private String categoria;
//Constructor, inicializa los atributos al crear un nuevo articulo
    public Articulo(String codigo, String nombre, String descripcion, double precio, String marca, String presentacion, int stock, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.marca = marca;
        this.presentacion = presentacion;
        this.stock = stock;
        this.categoria = categoria;
    }
    // Métodos getter: permiten obtener los valores de los atributos
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
    public String getCategoria() { return categoria; }
    public int getStock() { return stock; }
    // Método que reduce el stock según la cantidad vendida
    public void reducirStock(int cantidad) { stock -= cantidad; }
    // Método toString para representar el artículo como texto 
    @Override
    public String toString() {
        return codigo + " - " + nombre + " (S/." + precio + ")";
    }
}

