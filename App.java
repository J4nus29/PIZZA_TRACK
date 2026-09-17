import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Objeto encargado de gestionar las pilas de pedidos
        GestionPedidos gestion = new GestionPedidos();

        // Permite recibir datos ingresados por el usuario
        Scanner entrada = new Scanner(System.in);

        int opcion;

        do {
            // Menú principal del programa
            System.out.println("\n--- GESTION DE PEDIDOS DE PIZZERIA ---");
            System.out.println("1. Registrar Pizza");
            System.out.println("2. Deshacer");
            System.out.println("3. Rehacer");
            System.out.println("4. Mostrar Pedido Actual");
            System.out.println("0. Salir");
            System.out.println("Seleccione una opcion:");

            opcion = entrada.nextInt();

            switch (opcion) {

                // Registrar una nueva pizza
                case 1:
                    System.out.println("Registrar Pizza");

                    System.out.println("Ingrese el nombre de la pizza:");
                    String nombre = entrada.next();

                    // Arreglo fijo de 3 ingredientes
                    String[] ingredientes = new String[3];

                    // Solicita los tres ingredientes
                    for (int i = 0; i < 3; i++) {
                        System.out.println(
                                "Ingrese el ingrediente " + (i + 1) + ":"
                        );

                        ingredientes[i] = entrada.next();
                    }

                    // Crea el objeto Pizza
                    Pizza pizza = new Pizza(nombre, ingredientes);

                    // Registra la pizza en la pila principal
                    gestion.registrarPizza(pizza);

                    System.out.println("Pizza registrada correctamente.");
                    break;

                // Deshacer el último pedido
                case 2:
                    gestion.deshacer();
                    break;

                // Rehacer el último pedido deshecho
                case 3:
                    gestion.rehacer();
                    break;

                // Mostrar el pedido que está actualmente en la cima
                case 4:
                    Pizza pedidoActual = gestion.obtenerPedidoActual();

                    if (pedidoActual == null) {
                        System.out.println("No hay ningun pedido registrado.");
                    } else {
                        pedidoActual.mostrarPizza();
                    }

                    break;

                // Finalizar el programa
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                // Manejar opciones diferentes a las permitidas
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }

        } while (opcion != 0);

        // Cierra el Scanner
        entrada.close();
    }
}