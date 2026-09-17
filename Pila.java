public class Pila {

    // Representa el nodo que está en la cima de la pila
    private Nodo cima;

    // Constructor de la pila
    public Pila() {
        this.cima = null;
    }

    // Comprueba si la pila está vacía
    public boolean isEmpty() {
        return cima == null;
    }

    // Agrega una pizza en la cima de la pila
    public void push(Pizza pizza) {
        Nodo nuevo = new Nodo(pizza);

        // El nuevo nodo apunta al nodo que estaba anteriormente en la cima
        nuevo.setSiguiente(cima);

        // El nuevo nodo pasa a ser la nueva cima
        cima = nuevo;
    }

    // Saca y devuelve la pizza que está en la cima
    public Pizza pop() {
        if (isEmpty()) {
            return null;
        }

        // Guarda la pizza que vamos a sacar
        Pizza pizza = cima.getPizza();

        // La cima pasa a ser el siguiente nodo
        cima = cima.getSiguiente();

        return pizza;
    }

    // Consulta la pizza de la cima sin eliminarla
    public Pizza peek() {
        if (isEmpty()) {
            return null;
        }

        return cima.getPizza();
    }

    // Vacía completamente la pila
    public void limpiar() {
        cima = null;
    }
}