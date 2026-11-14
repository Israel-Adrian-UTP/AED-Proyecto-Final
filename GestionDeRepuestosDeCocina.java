

//Importando La Libreria Scanner
import java.util.Scanner;
// Clase Principal Del Proyecto
public class GestionDeRepuestosDeCocina {
    public static void main(String[] args) {
        // Creando Objeto Scanner para Leer Datos
        Scanner scanner = new Scanner(System.in);
        // Creando Objeto Para La Lista Enlazada
        Lista listaRepuesto = new Lista();
        // Creando Objeto Para La Pila
        PilaDinamica pilaRepuesto = new PilaDinamica();
        // Creando Objeto Para La Cola
        ColaDinamica colaRepuesto = new ColaDinamica();
        // Iniciando Menu Del Sistema
        int opcion = 0;
        do {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("                         GESTION DE REPUESTOS                        ");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("   [1] REGISTRAR REPUESTO ");
            System.out.println("   [2] MOSTRAR REPUESTOS");
            System.out.println("   [3] BUSCAR REPUESTO ");
            System.out.println("   [4] ACTUALIZAR REPUESTO ");
            System.out.println("   [5] ELIMINAR REPUESTO ");
            System.out.println("   [6] ORDENAR REPUESTOS ");
            System.out.println("   [7] CALCULAR STOCK ");
            System.out.println("   [8] REGISTRAR VENTA ");
            System.out.println("   [9] MOSTRAR VENTAS ");
            System.out.println("   [10] CALCULAR GANANCIAS ");
            System.out.println("   [11] AGREGAR PEDIDO ");
            System.out.println("   [12] ATENDER PEDIDO ");
            System.out.println("   [13] VER PEDIDO PENDIENTE ");
            System.out.println("   [14] SALIR ");
            System.out.println("---------------------------------------------------------------------");
            System.out.print("   INGRESE OPCION: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        listaRepuesto.RegistrarRepuesto(scanner);
                        break;
                    case 2:
                        listaRepuesto.MostrarRepuesto();
                        break;
                    case 3:
                        listaRepuesto.BuscarRepuesto(scanner);
                        break;
                    case 4:
                        listaRepuesto.ActualizarRepuesto(scanner);
                        break;
                    case 5:
                        listaRepuesto.EliminarRepuesto(scanner);
                        break;
                    case 6:
                        listaRepuesto.OrdenarRepuesto();
                        break;
                    case 7:
                        listaRepuesto.CalcularStock();
                        break;
                    case 8:
                        pilaRepuesto.RegistrarEnPila(scanner);
                        break;
                    case 9:
                        pilaRepuesto.mostrar();
                        break;
                    case 10:
                        pilaRepuesto.CalcularGanancias();
                        break;
                    case 11:
                        colaRepuesto.enqueue(scanner);
                        break;
                    case 12:
                        colaRepuesto.dequeue();
                        break;
                    case 13:
                        colaRepuesto.peek();
                        break;
                    case 14:
                        System.out.println("   CERRANDO SISTEMA ...");
                        break;
                    default:
                        System.out.println("   OPCION NO VALIDA.");
                }
            } else {
                System.out.println("   INGRESE UNA OPCION VALIDA.");
                scanner.nextLine();
            }
        } while (opcion != 14);
        scanner.close();
    }
}
// Clase Nodo Lista Para Lista Enlazada
class NodoLista {
    // Atributos
    int Id;
    String Nombre;
    double Precio;
    int Stock;
    NodoLista Siguiente;
    // Constructores
    public NodoLista(int Id, String Nombre, double Precio, int Stock) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Stock = Stock;
        this.Siguiente = null;
    }
}
// Clase Lista Para Crear La Lista Enlazada
class Lista {
    // Atributo
    NodoLista Cabeza;
    // Constructor
    public Lista() {
        Cabeza = null;
    }
    // Metodo Registrar Repuesto
    public void RegistrarRepuesto(Scanner scanner) {
        System.out.print("   Ingrese ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("   INGRESE NOMBRE: ");
        String nombre = scanner.nextLine();
        System.out.print("   INGRESE PRECIO: ");
        double precio = scanner.nextDouble();
        System.out.print("   INGRESE STOCK: ");
        int stock = scanner.nextInt();
        scanner.nextLine();
        NodoLista Nuevo = new NodoLista(id, nombre, precio, stock);
        if (Cabeza == null) {
            Cabeza = Nuevo;
        } else {
            NodoLista Auxiliar = Cabeza;
            while (Auxiliar.Siguiente != null) {
                Auxiliar = Auxiliar.Siguiente;
            }
            Auxiliar.Siguiente = Nuevo;
        }
        System.out.println("   REPUESTO REGISTRADO.");
    }
    // Metodo Mostrar Repuesto
    public void MostrarRepuesto() {
        if (Cabeza == null) {
            System.out.println("   NO EXISTEN REPUESTOS REGISTRADOS.");
            return;
        }
        System.out.println("---------------------------------------------------------------------");
        System.out.println("                        LISTA DE REPUESTOS                           ");
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("%-5s | %-35s | %-12s | %-6s%n", "ID", "NOMBRE", "PRECIO", "STOCK");
        System.out.println("---------------------------------------------------------------------");
        
        NodoLista Auxiliar = Cabeza;
        while (Auxiliar != null) {
            System.out.printf("%-5d | %-35s | S/. %-8.2f | %-6d%n", 
                Auxiliar.Id, 
                Auxiliar.Nombre, 
                Auxiliar.Precio, 
                Auxiliar.Stock);
            Auxiliar = Auxiliar.Siguiente;
        }
        System.out.println("---------------------------------------------------------------------");
    }
    // Metodo Buscar Repuesto
    public void BuscarRepuesto(Scanner scanner){
        if (Cabeza == null) {
            System.out.println("   NO EXISTEN REPUESTOS REGISTRADOS.");
            return;
        }
        System.out.print("   INGRESE ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        NodoLista Auxiliar = Cabeza;
        while(Auxiliar != null) {
            if(Auxiliar.Id == id) {
                System.out.println("   REPUESTO ENCONTRADO:");
                System.out.println("---------------------------------------------------------------------");
                System.out.printf("%-5s | %-35s | %-12s | %-6s%n", "ID", "NOMBRE", "PRECIO", "STOCK");
                System.out.println("---------------------------------------------------------------------");
                System.out.printf("%-5d | %-35s | S/. %-8.2f | %-6d%n", 
                    Auxiliar.Id, Auxiliar.Nombre, Auxiliar.Precio, Auxiliar.Stock);
                System.out.println("---------------------------------------------------------------------");
                return;
            }
            Auxiliar = Auxiliar.Siguiente;
        }
        System.out.println("   REPUESTO NO ENCONTRADO.");
    }
    // Metodo Actualizar Repuesto
    public void ActualizarRepuesto(Scanner scanner){
        if (Cabeza == null) {
            System.out.println("   NO EXISTEN REPUESTOS REGISTRADOS.");
            return;
        }
        System.out.print("   INGRESE ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        NodoLista Auxiliar = Cabeza;
        while(Auxiliar != null) {
            if(Auxiliar.Id == id) {
                System.out.print("   INGRESE NUEVO NOMBRE: ");
                Auxiliar.Nombre = scanner.nextLine();
                System.out.print("   INGRESE NUEVO PRECIO: ");
                Auxiliar.Precio = scanner.nextDouble();
                System.out.print("   INGRESE NUEVO STOCK: ");
                Auxiliar.Stock = scanner.nextInt();
                scanner.nextLine();
                System.out.println("   DATOS ACTUALIZADOS.");
                return;
            }
            Auxiliar = Auxiliar.Siguiente;
        }
        System.out.println("   REPUESTO NO ENCONTRADO.");
    }
    // Metodo Eliminar Repuesto
    public void EliminarRepuesto(Scanner scanner){
        if(Cabeza == null) {
            System.out.println("   NO EXISTEN REPUESTOS REGISTRADOS.");
            return;
        }
        System.out.print("   INGRESE ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if(Cabeza.Id == id) {
            Cabeza = Cabeza.Siguiente;
            System.out.println("   REPUESTO ELIMINADO.");
            return;
        }
        NodoLista Actual = Cabeza;
        NodoLista Anterior = null;
        while(Actual != null && Actual.Id != id) {
            Anterior = Actual;
            Actual = Actual.Siguiente;
        }
        if(Actual != null) {
            Anterior.Siguiente = Actual.Siguiente;
            System.out.println("   REPUESTO ELIMINADO.");
        } else {
            System.out.println("   REPUESTO NO ENCONTRADO.");
        }
    }
    // Metodo Ordenar Repuesto
    public void OrdenarRepuesto(){
        if (Cabeza == null || Cabeza.Siguiente == null) {
            System.out.println("   NO EXISTEN REPUESTOS REGISTRADOS.");
            return;
        }
        boolean cambiado;
        do {
            cambiado = false;
            NodoLista actual = Cabeza;
            while (actual.Siguiente != null) {
                if (actual.Id > actual.Siguiente.Id) {
                    int tempId = actual.Id;
                    String tempNombre = actual.Nombre;
                    double tempPrecio = actual.Precio;
                    int tempStock = actual.Stock;

                    actual.Id = actual.Siguiente.Id;
                    actual.Nombre = actual.Siguiente.Nombre;
                    actual.Precio = actual.Siguiente.Precio;
                    actual.Stock = actual.Siguiente.Stock;

                    actual.Siguiente.Id = tempId;
                    actual.Siguiente.Nombre = tempNombre;
                    actual.Siguiente.Precio = tempPrecio;
                    actual.Siguiente.Stock = tempStock;

                    cambiado = true;
                }
                actual = actual.Siguiente;
            }
        } while (cambiado);
        System.out.println("   REPUESTOS ORDENADOS POR ID.");
    }
    // Metodo Calcular Stock
    public void CalcularStock() {
        if (Cabeza == null) {
            System.out.println("   NO EXISTEN REPUESTOS REGISTRADOS.");
            return;
        }
        int stockTotalUnidades = 0;
        NodoLista auxiliar = Cabeza;
        while (auxiliar != null) {
            stockTotalUnidades += auxiliar.Stock;
            auxiliar = auxiliar.Siguiente;
        }
        System.out.println("   STOCK TOTAL: " + stockTotalUnidades + " UNIDADES.");
    }
}
// Clase Pila Dinamica Para La Creacion De La Pila
class PilaDinamica {
    public class NodoPila {
        // Atributos
        String Fecha;
        int Id;
        int Cantidad;
        double Precio;
        NodoPila siguiente;
        // Constructores
        public NodoPila(String fecha, int id, int cantidad, double precio) {
            this.Fecha = fecha;
            this.Id = id;
            this.Cantidad = cantidad;
            this.Precio = precio;
            this.siguiente = null;
        }
    }
    private NodoPila cima;
    // Metodo Registrar En Pila
    public void RegistrarEnPila(Scanner scanner) {
        System.out.print("   INGRESE FECHA: ");
        String fecha = scanner.nextLine();
        System.out.print("   INGRESE ID: ");
        int id = scanner.nextInt();
        System.out.print("   INGRESE CANTIDAD: ");
        int cantidad = scanner.nextInt();
        System.out.print("   INGRESE PRECIO: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); 
        push(fecha, id, cantidad, precio);
    }
    public void push(String fecha, int id, int cantidad, double precio) {
        NodoPila nuevo = new NodoPila(fecha, id, cantidad, precio);
        nuevo.siguiente = cima;
        cima = nuevo;
        System.out.println("   VENTA REGISTRADA.");
    }
    // Metodo Mostrar 
    public void mostrar() {
        if (cima == null) {
            System.out.println("   REGISTRO VACIO.");
            return;
        }
        System.out.println("---------------------------------------------------------------------");
        System.out.println("                          VENTAS REALIZADAS                          ");
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("%-12s | %-5s | %-10s | %-12s%n", "FECHA", "ID", "CANTIDAD", "PRECIO");
        System.out.println("---------------------------------------------------------------------");
        NodoPila actual = cima;
        while (actual != null) {
            System.out.printf("%-12s | %-5d | %-10d | S/. %-8.2f%n", 
                actual.Fecha, 
                actual.Id, 
                actual.Cantidad, 
                actual.Precio);
            actual = actual.siguiente;
        }
        System.out.println("---------------------------------------------------------------------");
    }
    // Metodo Calcular Ganancias
    public void CalcularGanancias() {
        if (cima == null) {
            System.out.println("   REGISTRO VACIO.");
            return;
        }

        double gananciaTotal = 0.0;
        NodoPila actual = cima;
        while (actual != null) {
            gananciaTotal += (actual.Precio * actual.Cantidad);
            actual = actual.siguiente;
        }

        System.out.println("---------------------------------------------------------------------");
        System.out.printf("   GANANCIA TOTAL DE VENTAS : S/. %.2f%n", gananciaTotal);
        System.out.println("---------------------------------------------------------------------");
    }
}
// Clase Cola Dinamica Para La Creacion De La Cola
class ColaDinamica {
    class Nodo {
        // Atributos
        int id;
        int cantidad;
        String estado;
        Nodo siguiente;
        // Constructores
        Nodo(int id, int cantidad, String estado) {
            this.id = id;
            this.cantidad = cantidad;
            this.estado = estado;
            this.siguiente = null;
        }
    }
    Nodo frente, fin;
    // Metodo Enqueue
    public void enqueue(Scanner scanner) {
        System.out.print("   INGRESE ID: ");
        int id = scanner.nextInt();
        System.out.print("   INGRESE CANTIDAD: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); 
        String estado = "PENDIENTE";
        Nodo nuevo = new Nodo(id, cantidad, estado);
        if (fin == null) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        System.out.println("   PEDIDO AGREGADO.");
    }
    // Metodo Dequeue
    public void dequeue() {
        if (frente == null) {
            System.out.println("   SIN PEDIDOS");
            return;
        }
        Nodo atendido = frente;
        atendido.estado = "ATENDIENDO";
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        System.out.println("---------------------------------------------------------------------");
        System.out.println("                          ATENDER PEDIDO                             ");
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("   ID: %d | Cantidad: %d | Estado: %s%n", atendido.id, atendido.cantidad, atendido.estado);
        System.out.println("---------------------------------------------------------------------");
    }
    // Metodo Peek
    public void peek() {
        if (frente == null) {
            System.out.println("   SIN PEDIDOS.");
            return;
        }
        System.out.println("---------------------------------------------------------------------");
        System.out.println("                        PEDIDO PENDIENTE                           ");
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("   ID: %d | Cantidad: %d | Estado: %s%n", frente.id, frente.cantidad, frente.estado);
        System.out.println("---------------------------------------------------------------------");
    }
}


