package exercicios;
import java.util.Scanner;
public class AreaCirculo {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		System.out.println("Digite o raio da circunferencia: ");
		int raio = in.nextInt();
		
		double area = (Math.PI*(raio*raio));
		
		System.out.printf("%.0f", area);
		
		in.close();

	}

}
