import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Punto_9 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stack<Integer> pila1 = new Stack<>();
        Stack<Integer> pila2 = new Stack<>();

        // Llenar pila 1
        System.out.print("Cantidad de elementos pila 1: ");
        int n1 = sc.nextInt();

        for (int i = 0; i < n1; i++) {
            System.out.print("Digite número: ");
            pila1.push(sc.nextInt());
        }

        // Llenar pila 2
        System.out.print("Cantidad de elementos pila 2: ");
        int n2 = sc.nextInt();

        for (int i = 0; i < n2; i++) {
            System.out.print("Digite número: ");
            pila2.push(sc.nextInt());
        }

        // Colas
        Queue<Integer> colaPares = new LinkedList<>();
        Queue<Integer> colaImpares = new LinkedList<>();

        // Procesar pila 1
        while (!pila1.isEmpty()) {
            int num = pila1.pop();

            if (num % 2 == 0) {
                colaPares.add(num);
            } else {
                colaImpares.add(num);
            }
        }

        // Procesar pila 2
        while (!pila2.isEmpty()) {
            int num = pila2.pop();

            if (num % 2 == 0) {
                colaPares.add(num);
            } else {
                colaImpares.add(num);
            }
        }

        // Mostrar resultados
        System.out.println("Cola de pares: " + colaPares);
        System.out.println("Cola de impares: " + colaImpares);
    }
}