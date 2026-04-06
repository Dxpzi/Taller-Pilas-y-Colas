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
        
        // LLamar al método
        if (op == 1) {
            sumaFilasPila(matriz);
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

}