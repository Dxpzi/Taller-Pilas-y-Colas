import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Punto_15 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue<String> cola = new LinkedList<>();

        System.out.print("¿Cuántos materiales ingresará?: ");
        int n = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        // 🔹 Llenar cola
        for (int i = 0; i < n; i++) {
            System.out.print("Digite material: ");
            String material = sc.nextLine();
            cola.add(material);
        }

        //  Buscar el más repetido
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

            // Verificar si es el mayor
            if (contador > max) {
                max = contador;
                mayor = actual;
            }

            aux1.add(actual);

            //  Devolver elementos
            while (!aux2.isEmpty()) {
                cola.add(aux2.poll());
            }
        }

        // Restaurar cola
        while (!aux1.isEmpty()) {
            cola.add(aux1.poll());
        }

        //  Resultados
        System.out.println("Materiales en cola: " + cola);
        System.out.println("Material con mayor ingreso: " + mayor);
        System.out.println("Cantidad: " + max);
    }
}