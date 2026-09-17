public class Nodo {

    // Guarda la pizza almacenada en este nodo
    private Pizza pizza;

    // Guarda la referencia al siguiente nodo de la lista
    private Nodo siguiente;

    // Constructor del nodo
    public Nodo(Pizza pizza) {
        this.pizza = pizza;
        this.siguiente = null;
    }

    // Devuelve la pizza almacenada en el nodo
    public Pizza getPizza() {
        return pizza;
    }

    // Devuelve el siguiente nodo
    public Nodo getSiguiente() {
        return siguiente;
    }

    // Permite establecer cuál será el siguiente nodo
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}