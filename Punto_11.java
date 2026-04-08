import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Punto_11 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<String> pila = new Stack<>();

        System.out.print("¿Cuántos siniestros desea ingresar?: ");
        int n = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        // Llenar pila
        for (int i = 0; i < n; i++) {
            System.out.print("Digite siniestro: ");
            String s = sc.nextLine();
            pila.push(s);
        }

        // Cola
        Queue<String> cola = new LinkedList<>();

        // Pasar de pila a cola
        while (!pila.isEmpty()) {
            cola.add(pila.pop());
        }

        // Buscar el más repetido
        String mayor = "";
        int max = 0;

        Queue<String> aux1 = new LinkedList<>();

        while (!cola.isEmpty()) {

            String actual = cola.poll();
            int contador = 1;

            Queue<String> aux2 = new LinkedList<>();

            while (!cola.isEmpty()) {
                String otro = cola.poll();

                if (actual.equals(otro)) {
                    contador++;
                }

                aux2.add(otro);
            }

            // comparar con el mayor
            if (contador > max) {
                max = contador;
                mayor = actual;
            }

            aux1.add(actual);

            // devolver elementos
            while (!aux2.isEmpty()) {
                cola.add(aux2.poll());
            }
        }

        // restaurar cola
        while (!aux1.isEmpty()) {
            cola.add(aux1.poll());
        }

        // 🔹 Mostrar resultados
        System.out.println("Siniestros en cola: " + cola);
        System.out.println("Siniestro con mayor ingreso: " + mayor);
    }
}