 
package boticasutp;
import Libreria.*;
import java.util.*;
public class BoticasUTP {
   
   //Declaramos el scanner y listas globales para clientes,articulos y pedidos
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Articulo> articulos = new ArrayList<>();
    static ArrayList<Pedido> pedidos = new ArrayList<>();

    public static void main(String[] args) {
        int op;
        //MENU PRINCIPAL-bucle principal del menu
        do {
            System.out.println("\n--- BOTICAS UTP ---");
            System.out.println("1. Mantenimiento de Clientes");
            System.out.println("2. Mantenimiento de Articulos");
            System.out.println("3. Registrar Pedido");
            System.out.println("4. Imprimir Pedidos");
            System.out.println("5. Ordenamientos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            op = sc.nextInt(); sc.nextLine();//Leemos la ocpion del usuario
            
            //Redirige al sunmenu segun la opcion
            switch (op) {
                case 1: menuClientes(); break;
                case 2: menuArticulos(); break;
                case 3: registrarPedido(); break;
                case 4: imprimirPedido(); break;
                case 5: menuOrdenamientos();break;
            }
        } while (op != 0);//Mientras no eliga salir 
    }
    //--------MENU CLIENTES---------
static void menuClientes() {
    int op;
    do {
        System.out.println("\n--- MENU CLIENTES ---");
        System.out.println("1. Buscar Cliente");
        System.out.println("2. Registrar Cliente");
        System.out.println("3. Modificar Cliente");
        System.out.println("4. Eliminar Cliente");
        System.out.println("5. Mostrar Clientes");
        System.out.println("0. Volver");
        System.out.print("Opción: ");
        op = sc.nextInt(); sc.nextLine();

        switch (op) {
            case 1://BUSCAR CLIENTE POR DNI 
                System.out.print("Ingrese DNI a buscar: ");
                String dniBuscar = sc.nextLine();
                Cliente encontrado = buscarClientePorDNI(dniBuscar);
                if (encontrado != null)
                    System.out.println("Cliente encontrado: " + encontrado);
                else
                    System.out.println("Cliente no encontrado.");
                break;

            case 2://REGISTRAR CLIENTE 
                try{
                System.out.print("DNI: "); String dni = sc.nextLine();
                System.out.print("Nombres: "); String nom = sc.nextLine();
                System.out.print("Apellidos: "); String ape = sc.nextLine();
                System.out.print("Dirección: "); String dir = sc.nextLine();
                System.out.print("Distrito: "); String dis = sc.nextLine();
                System.out.print("Correo: "); String cor = sc.nextLine();
                System.out.print("Celular: "); String cel = sc.nextLine();
                Cliente nuevoCliente=new Cliente(dni, nom, ape, dir, dis, cor, cel);
                clientes.add(nuevoCliente);
                    System.out.println("\nCliente registrado con exito");
                 } catch(IllegalArgumentException e){
                     System.out.println("Error al registrar cliente: "+e.getMessage());
                 }   
                break;
 
            case 3://MODIFICAR CLIENTE
                System.out.print("Ingrese DNI del cliente a modificar: ");
                String dniMod = sc.nextLine();
                Cliente cliMod = buscarClientePorDNI(dniMod);
                if (cliMod != null) {
                    //Pedimos nuevos datos
                    System.out.print("Nuevos nombres (" + cliMod.getNombres() + "): ");
                    String nuevosNombres = sc.nextLine();
                    System.out.print("Nuevos apellidos (" + cliMod.getApellidos() + "): ");
                    String nuevosApellidos = sc.nextLine();
                    System.out.print("Nueva dirección (" + cliMod.getDireccion() + "): ");
                    String nuevaDir = sc.nextLine();
                    System.out.print("Nuevo distrito: ");
                    String nuevoDis = sc.nextLine();
                //Vlidar correo y celular
                    String nuevoCor;
                    while(true){
                        System.out.println("Nuevo correo: ");
                        nuevoCor=sc.nextLine();
                        if(nuevoCor.isEmpty()||Cliente.validarCorreo(nuevoCor))break;
                        System.out.println("Correo invalido.Intente denuevo..");
                    }
                    String nuevoCel;
                    while(true){
                        System.out.println("Nuevo celular: ");
                        nuevoCel=sc.nextLine();
                        if(nuevoCel.isEmpty()||Cliente.validarCelular(nuevoCel))break;
                        System.out.println("Celular inválido.Intente denuevo.");
                    }
                    // Actualizar Cliente 
                    clientes.remove(cliMod);
                    clientes.add(new Cliente(
                        dniMod,
                        nuevosNombres.isEmpty() ? cliMod.getNombres() : nuevosNombres,
                        nuevosApellidos.isEmpty() ? cliMod.getApellidos() : nuevosApellidos,
                        nuevaDir.isEmpty() ? cliMod.getDireccion() : nuevaDir,
                        nuevoDis.isEmpty() ? cliMod.getDistrito(): nuevoDis,
                        nuevoCor.isEmpty() ? cliMod.getCorreo(): nuevoCor,
                        nuevoCel.isEmpty() ? cliMod.getCelular(): nuevoCel
                    ));
                    System.out.println("Cliente modificado.");
                } else {
                    System.out.println("Cliente no encontrado.");
                }
                break;

            case 4://ELIMINAR CLIENTE
                System.out.print("Ingrese DNI del cliente a eliminar: ");
                String dniDel = sc.nextLine();
                Cliente cliDel = buscarClientePorDNI(dniDel);
                if (cliDel != null) {
                    clientes.remove(cliDel);
                    System.out.println("Cliente eliminado.");
                } else {
                    System.out.println("Cliente no encontrado.");
                }
                break;

            case 5://MOSTRAR TODOS LOS CLIENTES 
                for (Cliente c : clientes) {
                    System.out.println(c);
                }
                break;

            case 0://Volver al menu principal
                break;

            default:
                System.out.println("Opción invalida.");
        }
    } while (op != 0);
}
//BUSCAR CLIENTE POR DNI
static Cliente buscarClientePorDNI(String dni) {
    for (Cliente c : clientes) {
        if (c.getDni().equals(dni)) {
            return c;
        }
    }
    return null;
}
//------------MENU ARTICULOS---------------
static void menuArticulos() {
    int op;
    do {
        System.out.println("\n--- MENÚ ARTÍCULOS ---");
        System.out.println("1. Registrar articulo");
        System.out.println("2. Eliminar articulo");
        System.out.println("3. Mostrar articulos");
        System.out.println("0. Volver");
        System.out.print("Opcion: ");
        op = sc.nextInt(); sc.nextLine();

        switch (op) {

            case 1://Registro de nuevo articulo
                System.out.print("Codigo: "); String cod = sc.nextLine();
                System.out.print("Nombre: "); String nom = sc.nextLine();
                System.out.print("Precio: "); double pre = sc.nextDouble(); sc.nextLine();
                System.out.print("Marca: "); String mar = sc.nextLine();
                System.out.print("Presentacion: "); String prese = sc.nextLine();
                System.out.print("Stock: "); int stock = sc.nextInt(); sc.nextLine();
                System.out.print("Categoria: "); String cat = sc.nextLine();
                break;
                

            case 2://ELIMINAR ARTICULO POR CODIGO
                System.out.print("Codigo del artículo a eliminar: ");
                String codDel = sc.nextLine();
                Articulo artDel = buscarArticuloPorCodigo(codDel);
                if (artDel != null) {
                    articulos.remove(artDel);
                    System.out.println("Articulo eliminado.");
                } else {
                    System.out.println("Articulo no encontrado.");
                }
                break;

            case 3://MOSTRAR TODOS LOS ARTICULOS 
                for (Articulo a : articulos) {
                    System.out.println(a);
                }
                break;
                default:
                System.out.println("Opcion invalida.");
        }
    } while (op != 0);
}
static Articulo buscarArticuloPorCodigo(String codigo) {
    for (Articulo a : articulos) {
        if (a.getCodigo().equalsIgnoreCase(codigo)) {
            return a;
        }
    }
    return null;
}
//-------Ordenamiento Interno-------
    @SuppressWarnings("empty-statement")
    static void menuOrdenamientos() {
    int op;
    do {
        System.out.println("\n--- MENU ORDENAMIENTOS ---");
        System.out.println("1. Ordenar Artículos por Precio (Burbuja)");
        System.out.println("2. Ordenar Clientes por Nombre (Inserción)");
        System.out.println("3. Ordenar Pedidos por Total (Selección)");
        System.out.println("4. Ordenacion de Productos ");
        System.out.println("0. Volver");
        System.out.print("Opción: ");
        op = sc.nextInt(); sc.nextLine();

        switch (op) {
            case 1://Burbuja(precio de menor a mayor)
                OrdenamientosInterno.burbujaArticulosPorPrecio(articulos);
                System.out.println("Artículos ordenados por precio:");
                for (Articulo a : articulos) System.out.println(a);
                break;

            case 2://Insercion (ordenar por apellido alfabeticamente A-Z)
                OrdenamientosInterno.insercionClientesPorNombre(clientes);
                System.out.println("Clientes ordenados por nombre:");
                for (Cliente c : clientes) System.out.println(c);
                break;

            case 3://Seleccion(ordenar por total de menor a mayor )
                OrdenamientosInterno.seleccionPedidosPorTotal(pedidos);
                System.out.println("Pedidos ordenados por total:");
                for (Pedido p : pedidos) {
                    System.out.println(p.getNumeroPedido() + " - Total: " + p.calcularTotal());
                }
                break;
            case 4:
                String rutaArchivo = "productos.txt"; 
                // Leer productos
                List<Articulo> productos = LectorArchivo.leerProductos(rutaArchivo);

                System.out.println("Productos cargados:");
                for (Articulo a : productos) {
                    System.out.println(a);
                }
                // Ordenar con Merge Sort por precio
                OrdenamientoExterno.mergeSort(productos);

                System.out.println("\n Productos ordenados por precio:");
                for (Articulo a : productos) {
                    System.out.println(a);
                }
                break;
                case 0: break;
                    default: System.out.println("Opción inválida.");
                }  
            } while (op != 0);
    }         
//-----------REGISTRO DE PEDIDOS-----------------
    static void registrarPedido(){
        System.out.print("DNI del cliente: ");
        String dni = sc.nextLine();
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getDni().equals(dni)) {
                cliente = c; break;
            }
        }
        if (cliente == null) {
            System.out.println("Cliente no encontrado."); return;
        }
        //Generacion automatica de numero de pedido
        String numPedido = "P" + (pedidos.size() + 1);
        Pedido pedido = new Pedido(numPedido, new Date(), cliente);

        while (true) {
            System.out.print("Codigo de artículo (ENTER para terminar): ");
            String cod = sc.nextLine();
            if (cod.isEmpty()) break;
            Articulo art = null;
            for (Articulo a : articulos) {
                if (a.getCodigo().equals(cod)) {
                    art = a; break;
                }
            }
            if (art == null) {
                System.out.println("Articulo no encontrado."); continue;
            }    
        System.out.println("Cantidad");
        int cant=sc.nextInt();sc.nextLine();
        if(cant<=0){
            System.out.println("La cantidad debe ser mayor que cero.");
            continue;
        }        
        if (cant>art.getStock()){
            System.out.println("Stock insuficiente.Solo hay "+art.getStock()+"unidades disponibles.");
        continue;
        //Se agrega el pedido y se actualiza el stock
        }
        pedido.agregarDetalle(new DetallePedido(art,cant));
        art.reducirStock(cant);
            System.out.println("Articulo agregado al pedido.");
        }
        pedidos.add(pedido);
        pedido.imprimirDetalle();//Mostrar resumen del pedido
        }
    static void imprimirPedido(){//MOSTRAR TODOS LOS PEDIDOS CON SUS TOTALESSystem.out.println("\n===============================================================");
    System.out.println("|                  REPORTE DE PEDIDOS                        |");
    System.out.println("===============================================================");
    System.out.printf("| %-12s | %-15s | %-13s | %-12s | %-10s |\n",
            "Cod.Cliente", "Cliente", "N° Pedido", "Fecha", "Total (S/.)");
    System.out.println("---------------------------------------------------------------");

    for (Pedido p : pedidos) {
        System.out.printf("| %-12s | %-15s | %-13s | %-12s | %10.2f |\n",
                p.getCliente().getDni(),
                p.getCliente().getNombreCompleto(),
                p.getNumeroPedido(),
                p.getFecha(),
                p.calcularTotal());
    }

    System.out.println("===============================================================");
    }
}       //aprender el tiempo , espacio medio,averiguar los tiempos del tiempo y del espacio , porque no elegismos los otros , mexcla equilibrada , divide y avanza
