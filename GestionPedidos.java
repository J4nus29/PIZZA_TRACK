public class GestionPedidos {

    // Pila principal: almacena los pedidos activos
    private Pila pilaPrincipal;

    // Pila secundaria: almacena los pedidos deshechos para poder rehacerlos
    private Pila pilaSecundaria;

    // Constructor de GestionPedidos
    public GestionPedidos() {
        pilaPrincipal = new Pila();
        pilaSecundaria = new Pila();
    }

    // Registra una nueva pizza en la pila principal
    public void registrarPizza(Pizza pizza) {
        pilaPrincipal.push(pizza);

        // Al registrar una nueva pizza, se elimina el historial de Redo
        pilaSecundaria.limpiar();
    }

    // Deshace el último pedido realizado
    public void deshacer() {
        Pizza pizza = pilaPrincipal.pop();

        if (pizza != null) {
            // La pizza deshecha pasa a la pila secundaria
            pilaSecundaria.push(pizza);
        } else {
            System.out.println("No hay pedidos para deshacer.");
        }
    }

    // Rehace el último pedido que había sido deshecho
    public void rehacer() {
        Pizza pizza = pilaSecundaria.pop();

        if (pizza != null) {
            // La pizza recuperada vuelve a la pila principal
            pilaPrincipal.push(pizza);
        } else {
            System.out.println("No hay pedidos para rehacer.");
        }
    }

    // Consulta cuál es el pedido que está actualmente en la cima
    public Pizza obtenerPedidoActual() {
        return pilaPrincipal.peek();
    }
}