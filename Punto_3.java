import java.util.Scanner;
import java.util.Stack;

public class Punto_3 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Stack<Integer> pila = new Stack<>();

        System.out.print("¿Cuántos elementos desea ingresar?: ");
        int n = sc.nextInt();

        // Llenar la pila 
        for (int i = 0; i < n; i++) {
            System.out.print("Digite un número: ");
            pila.push(sc.nextInt());     
        }

        // Procesar la pila y creación auxiliar
        Stack<Integer> auxiliar = new Stack<>();

        while (!pila.isEmpty()) {

            int num = pila.pop();
            
            // Condiciones
            if (num < 0) {
                num = 0;       

            } else if (num >= 8 && num <= 20) {
                num = 50;
                
            } else if (num > 60 && num < 62) {
                num = 100;
            }

            auxiliar.push(num);
        }

        while (!auxiliar.isEmpty()) {
            pila.push(auxiliar.pop());
            
        }

        System.out.print("Pila final: " + pila);
    }
    
}
