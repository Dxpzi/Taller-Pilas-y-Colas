import java.util.Scanner;
import java.util.Stack;

public class Punto_2 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite una cadena: ");
        String texto = sc.nextLine();

        Invertir(texto);

    }

    public static void Invertir(String texto) {

        Stack<Character> pila = new Stack<>();

        int cantidad = texto.length();

        System.out.println("Cantidad de caracteres: " + cantidad);

        for (int i = 0; i < texto.length(); i++) {
            pila.push(texto.charAt(i));

        }

        String invertida = "";

        while (!pila.isEmpty()) {
            invertida += pila.pop();

        }

        System.out.println("Cadena invertida: " + invertida);
    }

}
