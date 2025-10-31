import java.util.Scanner;

/**
 * Implementación de una pila estática genérica en Java.
 * Usa un arreglo de tamaño fijo para almacenar los elementos.
 */
class PilaEstatica<T> {
    private T[] elementos; // Arreglo para almacenar los datos
    private int tope;      // Índice del último elemento
    private int capacidad; // Tamaño máximo de la pila

    @SuppressWarnings("unchecked")
    public PilaEstatica(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que cero.");
        }
        this.capacidad = capacidad;
        this.elementos = (T[]) new Object[capacidad];
        this.tope = -1; // Pila vacía
    }

    // Verifica si la pila está vacía
    public boolean estaVacia() {
        return tope == -1;
    }

    // Verifica si la pila está llena
    public boolean estaLlena() {
        return tope == capacidad - 1;
    }

    // Inserta un elemento en la pila
    public void apilar(T elemento) {
        if (estaLlena()) {
            throw new IllegalStateException("Error: La pila está llena (overflow).");
        }
        elementos[++tope] = elemento;
    }

    // Elimina y devuelve el elemento en la cima
    public T desapilar() {
        if (estaVacia()) {
            throw new IllegalStateException("Error: La pila está vacía (underflow).");
        }
        T elemento = elementos[tope];
        elementos[tope--] = null; // Limpia la referencia
        return elemento;
    }

    // Devuelve el elemento en la cima sin eliminarlo
    public T cima() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía.");
        }
        return elementos[tope];
    }

    // Muestra el contenido de la pila
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("[Pila vacía]");
            return;
        }
        System.out.print("Pila: ");
        for (int i = tope; i >= 0; i--) {
            System.out.print(elementos[i] + (i > 0 ? " -> " : ""));
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Ingrese la capacidad de la pila: ");
            int capacidad = sc.nextInt();
            PilaEstatica<Integer> pila = new PilaEstatica<>(capacidad);

            // Ejemplo de uso
            pila.apilar(10);
            pila.apilar(20);
            pila.apilar(30);
            pila.mostrar();

            System.out.println("Elemento en la cima: " + pila.cima());

            System.out.println("Desapilando: " + pila.desapilar());
            pila.mostrar();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}