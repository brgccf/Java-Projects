package brgccf.q5;
import java.util.Scanner;
public class Questao5 {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		int x;
		System.out.println("Digite um numero inteiro positivo: ");
		x = in.nextInt();
		
		while (x == 0 || x < 0){
			System.out.println("Valor inválido. Tente novamente.");
			System.out.println("Digite um numero inteiro positivo: ");
			x = in.nextInt();			
		}
		if ((x == 2) || (x == 3) || (x == 5) || (x == 7) || (x == 11) || (x == 13)){
			System.out.println(x + " é primo.");
		}
		else if ((x % 2 == 0) || (x % 3 == 0) || (x % 5 == 0) || (x % 7 == 0) || (x % 11 == 0) || (x % 13 == 0)){
			System.out.println(x + " Não é um numero primo. ");
		}
	}
}
