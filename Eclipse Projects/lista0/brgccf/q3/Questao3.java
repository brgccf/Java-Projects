package brgccf.q3;
import java.util.Scanner;
public class Questao3 {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		double real, dolar, peso, libra;
		System.out.println("Digite seu dinheiro em reais: ");
		real = in.nextDouble();
		dolar = (real / 3.25);
		peso = (real / 0.35);
		libra = (real / 4.70);
		System.out.println("Você tem:");
		System.out.println(dolar + " dólar(es)");
		System.out.println(peso + " peso(s) argentino(s)");
		System.out.println(libra + " libra(s)");
	}

}
