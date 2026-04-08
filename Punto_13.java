import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Punto_13 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Tamaño matriz
        System.out.print("Filas (n): ");
        int n = sc.nextInt();

        System.out.print("Columnas (m): ");
        int m = sc.nextInt();

        int[][] matriz = new int[n][m];

        // Llenar matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Elemento [" + (i + 1) + "][" + (j + 1) + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }

        // Pila
        Stack<Integer> pila = new Stack<>();

        System.out.println("Ingrese valores de la pila:");

        for (int i = 0; i < n; i++) {
            pila.push(sc.nextInt());
        }

        // Promedio ANTES
        double suma = 0;
        for (int x : pila) {
            suma += x;
        }
        double promedioAntes = suma / pila.size();

        // Cola resultados
        Queue<Integer> cola = new LinkedList<>();

        // Pila auxiliar
        Stack<Integer> auxiliar = new Stack<>();

        // Procesar
        while (!pila.isEmpty()) {

            int valorPila = pila.pop();

            // multiplicar con cada elemento de la fila
            for (int j = 0; j < m; j++) {

                int resultado = valorPila * matriz[0][j]; // puedes usar cualquier fila

                // Condiciones
                if (resultado > 1000) {
                    resultado = 1000;
                } else if (resultado > 490 && resultado < 500) {
                    resultado = 500;
                }

                cola.add(resultado);
            }

            auxiliar.push(valorPila);
        }

        // Restaurar pila
        while (!auxiliar.isEmpty()) {
            pila.push(auxiliar.pop());
        }

        // Promedio DESPUÉS 
        double suma2 = 0;
        for (int x : pila) {
            suma2 += x;
        }
        double promedioDespues = suma2 / pila.size();

        //  Resultados
        System.out.println("Promedio antes: " + promedioAntes);
        System.out.println("Promedio después: " + promedioDespues);
        System.out.println("Resultados en cola: " + cola);
    }
}