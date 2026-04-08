import java.util.Scanner;
import java.util.Stack;

public class Punto_7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<Integer> pila = new Stack<>();

        System.out.print("¿Cuántos números desea ingresar?: ");
        int n = sc.nextInt();

        // Llenar pila
        for (int i = 0; i < n; i++) {
            System.out.print("Digite número: ");
            pila.push(sc.nextInt());
        }

        Stack<Integer> auxiliar = new Stack<>();

        int contador20_80 = 0;
        int contadorPositivos = 0;
        int suma80_200 = 0;

        // Procesar pila
        while (!pila.isEmpty()) {

            int num = pila.pop();

            // Negativos - cubo
            if (num < 0) {
                num = num * num * num;
            }

            // Contar entre 20 y 80
            if (num >= 20 && num <= 80) {
                contador20_80++;
            }

            // Contar positivos
            if (num > 0) {
                contadorPositivos++;
            }

            // Sumar entre 80 y 200
            if (num >= 80 && num <= 200) {
                suma80_200 += num;
            }

            auxiliar.push(num);
        }

        // Restaurar pila
        while (!auxiliar.isEmpty()) {
            pila.push(auxiliar.pop());
        }

        // Resultados
        System.out.println("Cantidad entre 20 y 80: " + contador20_80);
        System.out.println("Cantidad de positivos: " + contadorPositivos);
        System.out.println("Suma entre 80 y 200: " + suma80_200);
        System.out.println("Pila final: " + pila);
    }
}