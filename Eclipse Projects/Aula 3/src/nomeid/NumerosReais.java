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
		System.out.print("Digite o n�mero a: ");
		a = in.nextDouble();
		System.out.print("Digite o n�mero b: ");
		b = in.nextDouble();
		System.out.print("Digite o n�mero c: ");
		c = in.nextDouble();
		System.out.println("A m�dia aritm�tica �...");
		double media = (a+b+c)/3;
		System.out.println(media);
		
		
		
	}

}
