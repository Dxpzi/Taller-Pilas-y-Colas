import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Punto_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el tamaño de la matriz: ");
        int n = sc.nextInt();

        int[][] matriz = new int[n][n];

        // Llenar matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Ingrese valor [" + (i + 1) + "][" + (j + 1) + "]: ");
                matriz[i][j] = sc.nextInt();
            }

        }
        // Mostrar matriz
        System.out.println("Matriz ingresada:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("-----MENU------");
        System.out.println("1. Suma de filas (Pila)");
        System.out.println("2. Suma de columnas (Cola)");
        System.out.println("3. Factorial");
        System.out.println("4. Ordenar cola");

        System.out.print("Seleccione una opción: ");
        int op = sc.nextInt();

        // LLamar al método sumaFilasPila
        if (op == 1) {
            sumaFilasPila(matriz);

            // LLamar al método sumaColumnasCola
        } else if (op == 2) {
            sumaColumnasCola(matriz);
            // LLamar al método Factorial
        } else if (op == 3) {
            Factorial(n);
        } else if (op == 4) {
            ordenarCola(matriz);
        }

    }

    // int[][] matriz recibe la matriz como parámetro.
    public static void sumaFilasPila(int[][] matriz) {
        // Crea una pila de enteros.
        Stack<Integer> pila = new Stack<>();
        // matriz.length representa la cantidad de filas
        for (int i = 0; i < matriz.length; i++) {
            int suma = 0;

            // Recorre las columnas de esa fila.
            for (int j = 0; j < matriz[i].length; j++) {
                // Va sumando los valores de la fila.
                suma += matriz[i][j];
            }
            // Guarda la suma de cada fila en la pila.
            pila.push(suma);
        }

        System.out.println("Suma de filas (PILA):");
        while (!pila.isEmpty()) {
            System.out.println(pila.pop());
        }
    }

    public static void sumaColumnasCola(int[][] matriz) {

        // Se crea una cola de enteros.
        // Queue no se puede crear directamente porque es una interfaz.
        // por eso usamos LinkedList que sí implementa Queue.
        Queue<Integer> cola = new LinkedList<>();

        // Recorre las columnas de la matriz.
        // matriz[0].length = cantidad de columnas.
        // j representa el número de columna.
        for (int j = 0; j < matriz[0].length; j++) {

            // Variable donde se guardará la suma de una columna.
            int suma = 0;

            // Recorre las filas de la matriz.
            // matriz.length = cantidad de filas.
            // i representa el número de fila.
            for (int i = 0; i < matriz.length; i++) {

                // Va sumando el valor que está en la fila i y columna j
                // matriz[i][j]
                suma += matriz[i][j];
            }

            // Cuando termina de sumar toda la columna.
            // guarda el resultado en la cola.
            cola.offer(suma);
        }

        System.out.println("Suma de columnas (COLA):");
        // se recorren los elementos de la cola.
        while (!cola.isEmpty()) {
            // remove() saca e imprime cada valor en orden de llegada (FIFO).
            System.out.println(cola.remove());
        }

    }

    public static void Factorial(int n) {

        // Variable donde se guarda el resultado, se inicia en 1 porque el factorial.
        // multiplica
        int fact = 1;

        // Ciclo desde 1 hasta n
        for (int i = 1; i <= n; i++) {
            fact = fact * i; // Multiplica acumulativamente.
        }

        // Mostrar resultado
        System.out.println("Factorial de " + n + " es: " + fact);

    }

    public static void ordenarCola(int[][] matriz) {

        Queue<Integer> cola = new LinkedList<>();

        // Llenar la cola con los valores de la matriz.
        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {
                cola.offer(matriz[i][j]);
            }
        }

        System.out.println("Cola ordenada de mayor a menor:");

        // Mientras la cola tenga elementos.
        while (!cola.isEmpty()) {

            int mayor = cola.peek(); // tomar el primero como referencia.

            // Buscar el mayor.
            for (int num : cola) {
                if (num > mayor) {
                    mayor = num;
                }
            }

            // Imprimir el mayor.
            System.out.println(mayor);

            // Eliminar SOLO una vez ese mayor de la cola.
            boolean eliminado = false;
            int size = cola.size();

            for (int i = 0; i < size; i++) {
                int num = cola.remove();

                if (num == mayor && !eliminado) {
                    eliminado = true; // Elimina solo uno.
                } else {
                    cola.offer(num); // Vuelve a meter los demás.
                }
            }
        }
    }
}
