package Exercicios;

import java.util.Scanner;

	public class Programa{
		public static void main (String [] args){
			Scanner in = new Scanner (System.in);
			int a, b;
			System.out.println("Digite a: ");
			a = in.nextInt();
			System.out.println("Digite b: ");
			b = in.nextInt();
			Multiplicacao m = new Multiplicacao ();
			
			
			System.out.println(m.produto(a, b));
			
			in.close();
		}

	}
