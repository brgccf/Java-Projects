package exercicios;
import java.util.Scanner;
public class Exercicio3 {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		int x, resposta;
		resposta = 1;
		do {
			System.out.println("Digite um numero inteiro maior que zero: ");
			x = in.nextInt();
			if (x < 0){
			System.out.println("Valor inválido.");
			}
			else{
				System.out.println("Valor válido.");
			}
		} while (x < 0);
		
		for (resposta = 1; (x > 0); x--){
			resposta = (resposta * x);
		}
		System.out.println("O fatorial é " + resposta);
		}
	}