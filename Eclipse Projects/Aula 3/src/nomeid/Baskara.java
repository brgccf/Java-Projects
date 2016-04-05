package nomeid;
import java.util.Scanner;
import java.text.NumberFormat;
public class Baskara {
	
	public static void main (String [] args) {
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		Scanner in = new Scanner (System.in);
		double x1;
		double x2;
		double delta;
		System.out.println("Digite o coeficiente a: ");
		double a = in.nextDouble();
		System.out.println("Digite o coeficiente b: ");
		double b = in.nextDouble();
		System.out.println("Digite o coeficiente c: ");
		double c = in.nextDouble();
		System.out.println("Sua equação é: ");
		System.out.print(a);
		System.out.print("x² + ");
		System.out.print(b);
		System.out.print("x + ");
		System.out.print(c);
		System.out.println(" = 0");
		System.out.println(" Calculando...");
		delta = (Math.pow(b, 2)) - (4 * a * c);
		if (delta < 0) {
			System.out.println("A equação não tem raízes reais.");}
			
		
		x1 = (b * (-1) + Math.sqrt(delta)) / 2 * a;
		x2 = (b * (-1) - Math.sqrt(delta)) / 2 * a;
		System.out.println("Resultado: ");
		System.out.print("x1 = ");
		System.out.println(x1);
		System.out.print("x2 = ");
		System.out.println(x2);
		
		System.out.println("Fim de programa...");
		}
		
	
		
		
		
		
	}


