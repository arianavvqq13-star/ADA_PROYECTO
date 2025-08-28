package Libreria;
import java.util.*; 
public class Cliente {

    // Atributos privados del cliente
    private String dni;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String distrito;
    private String correo;
    private String celular;
    // Constructor
    public Cliente(String dni, String nombres, String apellidos, String direccion, String distrito, String correo, String celular) {
        StringBuilder errores=new StringBuilder();
        //Validacion del DNI, debe tener 8 digitos numericos
        if(!dni.matches("\\d{8}")){
        errores.append("\nDNI inválido.Debe tener 8 digitos.");
        }
        //Validacion de celular, debe tener 9 digitios 
        if (!celular.matches("\\d{9}")){
        errores.append("\nCelular invalido.Debe tener 9 digitos.");
        }
        //Validacion de correo electronico
        if (!correo.matches("[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
        errores.append("\nCorreo Invalido.");
        }
        //Si se detectaron errores, se lanza una expecion con los mensajes acumulados
        if(errores.length()>0){
            throw new IllegalArgumentException(errores.toString());
        }
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.distrito = distrito;
        this.correo = correo;
        this.celular = celular;
    }
    // Métodos getter para obtener los valores de los atributos
    public String getDni() {return dni;}

    public String getNombres() {return nombres;}

    public String getApellidos() { return apellidos;}

    public String getNombreCompleto(){return nombres+" "+apellidos;}

    public String getDireccion() {return direccion;}

    public String getDistrito() {return distrito;}

    public String getCorreo() {return correo;}

    public String getCelular() { return celular;}
  //Metodo toString para mostrar el cliente en formato: DNI - Nombre Completo
    @Override
    public String toString() {
        return dni+ "-"+getNombreCompleto();
    }
    //Metodo statico para validar el formato 
    public static boolean validarCorreo(String correo){
       return correo.matches("[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$"); 
    }
    //Metodo statico para validar el formato 
    public static boolean validarCelular(String celular){
        return celular.matches("\\d{9}");
    }
}  

