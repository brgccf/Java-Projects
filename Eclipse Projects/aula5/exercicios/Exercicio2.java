package exercicios;
import java.util.Scanner;
public class Exercicio2 {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		int x;
		do {
			System.out.print("Digite um número inteiro entre 1 e 100: ");
			x = in.nextInt();		
		} while ((x<= 0) || (x > 100));
		
		while (x < 100){
			if (x % 2 != 0){
				System.out.print(x + ",");
				x = (x + 2);
				
				}
			else{
				System.out.print(x + 1 + ",");
				x = (x+2);
			}
			}
		
			
		}
	}

