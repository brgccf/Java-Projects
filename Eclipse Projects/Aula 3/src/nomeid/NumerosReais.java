package nomeid;
import java.text.NumberFormat;
import java.util.Scanner;
public class NumerosReais {
	
	public static void main(String[] args) {
		NumberFormat nf;
		Scanner in = new Scanner (System.in);
		double a, b, c;
		nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		System.out.print("Digite o número a: ");
		a = in.nextDouble();
		System.out.print("Digite o número b: ");
		b = in.nextDouble();
		System.out.print("Digite o número c: ");
		c = in.nextDouble();
		System.out.println("A média aritmética é...");
		double media = (a+b+c)/3;
		System.out.println(media);
		
		
		
	}

}
