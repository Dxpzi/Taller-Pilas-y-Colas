import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Punto_12 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese tamaño n: ");
        int n = sc.nextInt();

        int[][] matriz = new int[n][n];

        // Llenar matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Elemento [" + (i + 1) + "][" + (j + 1) + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }

        // Colas
        Queue<Integer> colaPares = new LinkedList<>();
        Queue<Integer> colaImpares = new LinkedList<>();

        // Recorrer matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if ((i + j) % 2 == 0) {
                    colaPares.add(matriz[i][j]);
                } else {
                    colaImpares.add(matriz[i][j]);
                }
            }
        }

        // Mostrar resultados
        System.out.println("Cola de posiciones pares: " + colaPares);
        System.out.println("Cola de posiciones impares: " + colaImpares);
    }
}