import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Punto_10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue<Double> colaPagos = new LinkedList<>();

        System.out.print("¿Cuántos empleados?: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("Empleado " + (i + 1));

            System.out.print("Horas trabajadas: ");
            int horas = sc.nextInt();

            System.out.print("Valor por hora: ");
            double valor = sc.nextDouble();

            double pago = calcularPago(horas, valor);

            colaPagos.add(pago);
        }

        // Mostrar resultados
        System.out.println("Pagos en cola: " + colaPagos);
    }

    // Método para calcular pago
    public static double calcularPago(int horas, double valor) {

        double pago = 0;

        if (horas <= 40) {
            pago = horas * valor;

        } else {

            // Horas normales
            pago = 40 * valor;

            int extras = horas - 40;

            if (extras <= 8) {
                pago += extras * valor * 2;

            } else {
                pago += 8 * valor * 2;
                pago += (extras - 8) * valor * 3;
            }
        }

        return pago;
    }
}