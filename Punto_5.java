import java.util.Scanner;
import java.util.Stack;

public class Punto_5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos elementos tendrá el vector?: ");
        int n = sc.nextInt();

        int[] vector = new int[n];

        // Llenar vector
        for (int i = 0; i < n; i++) {
            System.out.print("Digite número: ");
            vector[i] = sc.nextInt();
        }

        // Crear pila
        Stack<Integer> pila = new Stack<>();

        // Calcular factorial y guardar en pila
        for (int i = 0; i < n; i++) {
            int num = vector[i];
            int factorial = 1;

            for (int j = 1; j <= num; j++) {
                factorial *= j;
            }

            pila.push(factorial);
        }

        // Mostrar pila
        System.out.println("Factoriales en la pila: " + pila);
    }
}

