package brgccf.q2;
import java.util.Scanner;
public class Questao2 {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		int x;
		System.out.println("Digite a idade do competidor: ");
		x = in.nextInt();
		
		while (x <= 0){
			System.out.println("Idades s�o n�meros positivos diferentes de zero. Insira um.");
			System.out.println("Digite a idade do competidor: ");
			x = in.nextInt();
		}
		if (x < 14){
			System.out.println("O competidor � uma crian�a.");
		}
		else if ((x >= 14) & (x < 18)){
			System.out.println("O competidor � um adolescente.");
		}
		else if ((x >= 18) & (x < 60)){
			System.out.println("O competidor � um adulto.");
		}
		else if (x > 60){
			System.out.println("O competidor � um idoso.");
		}
		
	}

}
