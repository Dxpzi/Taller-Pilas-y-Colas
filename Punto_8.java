import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Punto_8 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese tamaño n: ");
        int n = sc.nextInt();

        int[][] A = new int[n][n];
        int[][] B = new int[n][n];

        // Llenar matrices
        System.out.println("Matriz A:");
        llenarMatriz(sc, A, n);

        System.out.println("Matriz B:");
        llenarMatriz(sc, B, n);

        // Reemplazar negativos por 0
        reemplazarNegativos(A, n);
        reemplazarNegativos(B, n);

        // Multiplicación A × B
        Queue<Integer> cola = new LinkedList<>();
        int[][] resultado = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                resultado[i][j] = 0;

                for (int k = 0; k < n; k++) {
                    resultado[i][j] += A[i][k] * B[k][j];
                }

                cola.add(resultado[i][j]);
            }
        }

        System.out.println("Multiplicación en cola: " + cola);

        // Media de matrices
        double mediaA = calcularMedia(A, n);
        double mediaB = calcularMedia(B, n);

        System.out.println("Media A: " + mediaA);
        System.out.println("Media B: " + mediaB);

        if (mediaA > mediaB) {
            System.out.println("La media mayor es la de A");
        } else {
            System.out.println("La media mayor es la de B");
        }

        // Factorial de la media (convertida a entero)
        int factA = factorial((int) mediaA);
        int factB = factorial((int) mediaB);

        System.out.println("Factorial media A: " + factA);
        System.out.println("Factorial media B: " + factB);
    }

    // Métodos auxiliares

    public static void llenarMatriz(Scanner sc, int[][] matriz, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Elemento [" + (i + 1) + "][" + (j + 1) + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }
    }

    public static void reemplazarNegativos(int[][] matriz, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] < 0) {
                    matriz[i][j] = 0;
                }
            }
        }
    }

    public static double calcularMedia(int[][] matriz, int n) {
        int suma = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                suma += matriz[i][j];
            }
        }

        return (double) suma / (n * n);
    }

    public static int factorial(int num) {
        int fact = 1;

        for (int i = 1; i <= num; i++) {
            fact *= i;
        }

        return fact;
    }
}