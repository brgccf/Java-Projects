package brgccf.q4;
import java.util.Scanner;
import java.text.NumberFormat;
public class Questao4 {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		double x;
		double nota100, nota50, nota20, nota10, nota5, nota2;
		double moeda1, moeda50, moeda25, moeda10, moeda5, moeda01;
		int mod100, mod50, mod20, mod10, mod5, mod2;
		int mda1, mda50, mda25, mda10, mda5, mda01;
		
		System.out.println("Digite o dinheiro: ");
		x = in.nextDouble();
		nf.setMaximumFractionDigits(2);
		
		nota100 = 100.00;
		nota50 = 50.00;
		nota20 = 20.00;
		nota10 = 10.00;
		nota5 = 5.00;
		nota2 = 2.00;
		
		moeda1 = 1.00;
		moeda50 = 0.50;
		moeda25 = 0.25;
		moeda10 = 0.10;
		moeda5 = 0.05;
		moeda01 = 0.01;
		
		mod100 = (int)((x / nota100));
		if (mod100 == 0){
			System.out.println(mod100 + " nota(s) de R$100,00");
		}
		else if (mod100 > 0) {
			System.out.println(mod100 + " nota(s) de R$100,00");
			x = (x - (nota100 * mod100));
		}
		else if (mod100 < 0){
			System.out.println("Valor inválido para dinheiro.");
		}
		mod50 = (int)((x / nota50));
		if (mod50 == 0){
			System.out.println(mod50 + " nota(s) de R$50,00");
		}
		else if (mod50 > 0) {
			System.out.println(mod50 + " nota(s) de R$50,00");
			x = (x - (nota50 * mod50));
		}
		else if (mod50 < 0){
			System.out.println("Valor inválido para dinheiro.");
		}
		
		mod20 = (int)((x / nota20));
		if (mod20 == 0){
			System.out.println(mod20 + " nota(s) de R$20,00");
		}
		else if (mod20 > 0) {
			System.out.println(mod20 + " nota(s) de R$20,00");
			x = (x - (nota20 * mod20));
		}
		else if (mod20 < 0){
			System.out.println("Valor inválido para dinheiro.");
		}
		
		mod10 = (int)((x / nota10));
		if (mod10 == 0){
			System.out.println(mod10 + " nota(s) de R$10,00");
		}
		else if (mod10 > 0) {
			System.out.println(mod10 + " nota(s) de R$10,00");
			x = (x - (nota10 * mod10));
		}
		else if (mod10 < 0){
			System.out.println("Valor inválido para dinheiro.");
		}
		
		mod5 = (int)((x / nota5));
		if (mod5 == 0){
			System.out.println(mod5 + " nota(s) de R$5,00");
		}
		else if (mod5 > 0) {
			System.out.println(mod5 + " nota(s) de R$5,00");
			x = (x - (nota5 * mod5));
		}
		else if (mod5 < 0){
			System.out.println("Valor inválido para dinheiro.");
		}
		
		mod2 = (int)((x / nota2));
		if (mod2 == 0){
			System.out.println(mod2 + " nota(s) de R$2,00");
		}
		else if (mod2 > 0) {
			System.out.println(mod2 + " nota(s) de R$2,00");
			x = (x - (nota2 * mod2));
		}
		else if (mod2 < 0){
			System.out.println("Valor inválido para dinheiro.");
		}
		//Switch so pode ser utilizado para char, byte, short ou int.
		//por isso nao foi utilizado aqui.
		
		System.out.println("MOEDAS: ");
		
		mda1 = (int)(x);
		if (mda1 == 0){
			System.out.println(mda1 + " moeda(s) de R$ 1,00");
		}
		else if (mda1 > 0){
			System.out.println(mda1 + " moeda(s) de R$1,00");
			x = (x - mda1);
		}
		else if (mda1 < 0){
			System.out.println("Valor inválido para dinheiro. ");
		}
		mda50 = (int)(x / moeda50);
		if (mda50 == 0){
			System.out.println(mda50 + " moeda(s) de R$ 0,50");
		}
		else if (mda50 > 0){
			System.out.println(mda50 + " moeda(s) de R$0,50");
			x = (x - (moeda50 * mda50));
		}
		else if (mda50 < 0){
			System.out.println("Valor inválido para dinheiro. ");
		}
		mda25 = (int)((x / moeda25));
		if (mda25 == 0){
			System.out.println(mda25 + " moeda(s) de R$ 0,25");
		}
		else if (mda25 > 0){
			System.out.println(mda25 + " moeda(s) de R$0,25");
			x = (x - (moeda25 * mda25));
		}
		else if (mda25 < 0){
			System.out.println("Valor inválido para dinheiro. ");
		}
		
		x = (x + 0.01);
		//por algum motivo desconhecido, quando a entrada recebe numeros muito quebrados
		//(como 111.85), o java nao calcula os valores de forma correta,
		//subtraindo valores a mais que o necessario.
		mda10 = (int)(x / moeda10);
		if (mda10 == 0){
			System.out.println(mda10 + " moeda(s) de R$ 0,10");
		}
		else if (mda10 > 0){
			System.out.println(mda10 + " moeda(s) de R$0,10");
			x = (x - (moeda10 * mda10));
		
		}
		else if (mda10 < 0){
			System.out.println("Valor inválido para dinheiro. ");
		}
		
		mda5 = (int)(x / moeda5);
		if (mda5 == 0){
			System.out.println(mda5 + " moeda(s) de R$ 0,05");
		}
		else if (mda5 > 0){
			System.out.println(mda5 + " moeda(s) de R$0,05");
			x = (x - (moeda5 * mda5));
		}
		else if (mda5 < 0){
			System.out.println("Valor inválido para dinheiro. ");
		}
		x = (x - 0.001);
		
		mda01 = (int)(x / moeda01);
		if (mda01 == 0){
			System.out.println(mda01 + " moeda(s) de R$ 0,01");
		}
		else if (mda01 > 0){
			System.out.println(mda01 + " moeda(s) de R$0,01");
			x = (x - (moeda01 * mda01));
		}
		else if (mda01 < 0){
			System.out.println("Valor inválido para dinheiro. ");
		}
		//OBS> tentativa de usar NumberFormat não deu certo. Gostaria de saber o motivo.
	}	
}
		
		
	
