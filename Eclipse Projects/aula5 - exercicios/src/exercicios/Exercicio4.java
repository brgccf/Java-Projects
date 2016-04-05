package exercicios;
import java.util.Scanner;
public class Exercicio4 {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		int N, i;
		int a, resposta;
		a = 0;
		i = 1;
		do {
			System.out.println("Digite um valor inteiro maior que zero: ");
			N = in.nextInt();
			if (N <= 0){
				System.out.println("Valor inválido.");
			}
			else{
				System.out.println("Valor válido.");
			}
		} while (N <= 0);
		System.out.println("Calculando o somatório...");

		while (N > a){
			if (i == 1){
			System.out.print(i);
			}
			N--;
			if (N != a){
				System.out.print(" + ");
			}
			i++;
			resposta = ((int)Math.pow(i, 2));
			System.out.print(resposta);
		}
	}
}

