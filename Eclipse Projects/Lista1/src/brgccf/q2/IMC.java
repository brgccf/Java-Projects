package brgccf.q2;
import java.util.Scanner;
import java.lang.String;
public class IMC {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		double peso, altura, DIFERENCA1, DIFERENCA2;
		/*DIFERENCA1 E 2 sao variaveis utilizadas para calcular quanto peso
		 * uma pessoa magra precisa ganhar ou uma pessoa obesa
		 * precisa perder. 
		 * os inteiros ganhar e perder abaixo são o resultado desses calculos.
		 */
		
		int ganhar, perder, IMC;
		String RESULTADO1 = null, RESULTADO2 = null, RESULTADO3 = null;
		System.out.println("Ola usuario. Este programa sabe tudo sobre IMC e vai ajudar você.");
		System.out.println("A tabela usada neste programa foi disponibilizada em: Sociedade Brasileira de Endocrinologia e Metabologia.");
		System.out.println("Digite seu peso e altura (em metros), respectivamente: ");
		peso = in.nextDouble(); altura = in.nextDouble();
		while (peso <= 0 || altura <= 0){
			System.out.println("entrada invalida.");
			System.out.println("Digite seu peso e altura (em metros), respectivamente: ");
			peso = in.nextDouble(); altura = in.nextDouble();
	}
		//cálculo do IMC (peso / altura²):
		IMC = (int)(peso / Math.pow(altura, 2));
		
		//Analise de IMC:
		if (IMC < 18.5){
			DIFERENCA1 = ((18.5 - IMC) * Math.pow(altura, 2));
			ganhar = (int)DIFERENCA1;
			RESULTADO1 = "Você nao esta no peso ideal. Precisa ganhar " + ganhar + " Kg.";
			RESULTADO2 = ("IMC = " + IMC + " Underweight (IMC < 18.5)");
			RESULTADO3 = (RESULTADO1 + "\t" + RESULTADO2);
		}
		else if (IMC >= 18.5 & IMC < 24.9){
			RESULTADO1 = "Voce esta no peso ideal.";
			RESULTADO2 = ("IMC = " + IMC + " Idealweight 18.5 to 24.9");
			RESULTADO3 = (RESULTADO1 + "\t" +  RESULTADO2);
		}
		else if (IMC >= 24.9 & IMC < 29.9){
			DIFERENCA2 = ((IMC - 24.9) * Math.pow(altura, 2));
			perder = (int)DIFERENCA2;
			RESULTADO1 = "Voce esta em sobrepeso (grau I). Precisa perder " + perder + " Kg.";
			RESULTADO2 = ("IMC = " + IMC + " Overweight 24.9 to 29.9");
			RESULTADO3 = (RESULTADO1 + "\t" + RESULTADO2);
		}
		else if (IMC >= 29.9 & IMC < 39.9){
			DIFERENCA2 = ((IMC - 24.9) * Math.pow(altura, 2));
			perder = (int)DIFERENCA2;
			RESULTADO1 = "Voce esta Obeso (grau II). Precisa perder " + perder + " Kg.";
			RESULTADO2 = ("IMC = " + IMC + " Overweight 29.9 to 39.9");
			RESULTADO3 = (RESULTADO1 + "\t" + RESULTADO2);
		}
		else if (IMC >= 39.9){
			DIFERENCA2 = ((IMC - 24.9) * Math.pow(altura, 2));
			perder = (int)DIFERENCA2;
			RESULTADO1 = "Voce esta com Obesidade Grave! (grau III). Precisa perder " + perder + " Kg.";
			RESULTADO2 = ("IMC = " + IMC + " Overweight (IMC > 39.9");
			RESULTADO3 = (RESULTADO1 + "\t" + RESULTADO2);
		}
		//Menu do usuario:
		int menu;
		System.out.println("O que você deseja?");
		System.out.println("1- Saber se está no peso ideal.");
		System.out.println("2- Consultar a sua linha na tabela.");
		System.out.println("3- Todas as opções anteriores.");
		menu = in.nextInt();
		//verificacao de comando do usuario:
		switch (menu){
		case (1):
			System.out.println(RESULTADO1);
			break;
		case(2):
			System.out.println(RESULTADO2);
			break;
		case(3):
			System.out.println(RESULTADO3);
			break;
		}
		
		in.close();
		

	}

}
