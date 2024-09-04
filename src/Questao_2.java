import java.util.Scanner;

public class Questao_2 {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("Informe um número: ");
	        int numero = scanner.nextInt();
	        
	        if (numero < 0) {
	            System.out.println(numero + " não pertence à sequência de Fibonacci.");
	            scanner.close();
	            return;
	        }
	        
	        int a = 0; 
	        int b = 1;
	        
	        if (numero == a || numero == b) {
	            System.out.println(numero + " pertence à sequência de Fibonacci.");
	            scanner.close();
	            return;
	        }
	        
	        while (b <= numero) {
	            int temp = a + b;
	            a = b;
	            b = temp;

	            if (b == numero) {
	                System.out.println(numero + " pertence à sequência de Fibonacci.");
	                scanner.close();
	                return;
	            }
	        }
	        
	        System.out.println(numero + " não pertence à sequência de Fibonacci.");
	        scanner.close();
	    }
}


