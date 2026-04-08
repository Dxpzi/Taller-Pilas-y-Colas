import java.util.Scanner;
import java.util.Stack;

public class Punto_6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Filas: ");
        int n = sc.nextInt();

        System.out.print("Columnas: ");
        int m = sc.nextInt();

        int[][] matriz = new int[n][m];

        // Llenar matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Digite elemento [" + (i + 1)+ "][" + (j + 1) + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }

        // Promedio de filas
        Stack<Double> pilaFilas = new Stack<>();

        for (int i = 0; i < n; i++) {
            int suma = 0;

            for (int j = 0; j < m; j++) {
                suma += matriz[i][j];
            }

            double promedio = (double) suma / m;
            pilaFilas.push(promedio);
        }

        System.out.println("Promedios de filas: " + pilaFilas);

        // 🔹 2. Raíz de suma de columnas
        Stack<Double> pilaColumnas = new Stack<>();

        for (int j = 0; j < m; j++) {
            int suma = 0;

            for (int i = 0; i < n; i++) {
                suma += matriz[i][j];
            }

            double raiz = Math.sqrt(suma);
            pilaColumnas.push(raiz);
        }

        System.out.println("Raíz de columnas: " + pilaColumnas);

        // Multiplicación de matrices A × B

        int[][] A = matriz;
        int[][] B = matriz; // Puedes pedir otra si quieres

        int[][] resultado = new int[n][m];
        Stack<Integer> pilaMultiplicacion = new Stack<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                resultado[i][j] = 0;

                for (int k = 0; k < m; k++) {
                    resultado[i][j] += A[i][k] * B[k][j];
                }

                pilaMultiplicacion.push(resultado[i][j]);
            }
        }

        System.out.println("Multiplicación en pila: " + pilaMultiplicacion);
    }
}