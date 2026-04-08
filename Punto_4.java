import java.util.Scanner;
import java.util.Stack;

public class Punto_4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<Character> pila = new Stack<>();

        Boolean encontrado = false;

        while (!encontrado) {

            // Si la pila está vacía llenar
            if (pila.isEmpty()) {

                System.out.print("¿Cuántos elementos desea ingresar?: ");
                int n = sc.nextInt();

                for (int i = 0; i < n; i++) {
                    System.out.print("Digite el número: ");
                    char c = sc.next().charAt(0);
                    pila.push(c);

                }
            }

            System.out.print("Digite el valor a buscar: ");
            char buscado = sc.next().charAt(0);

            // Creamos auxiliar

            Stack<Character> auxiliar = new Stack<>();
            int posicion = 0;
            int contador = pila.size(); // Tamaño inicial

            boolean encontradoLocal = false;

            // Buscar
            while (!pila.isEmpty()) {

                char c = pila.pop();

                if (c == buscado) {
                    posicion = contador;
                    encontradoLocal = true;
                    encontrado = true;
                }

                auxiliar.push(c);
                contador--;
            }

            // Restaurar pila
            while (!auxiliar.isEmpty()) {
                pila.push(auxiliar.pop());
            }

            // Resultado

            if (encontradoLocal) {
                System.out.print("Elemento encontrado en la posición: " + posicion);

            } else {
                System.out.println("No se encontró el elemento.");
            }

        }
    }

}
