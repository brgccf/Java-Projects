package exercícios;
import java.util.Scanner;
public class ProgramaMeuArray {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		MeuArray numero = new MeuArray();
		int escolha = 0;
		System.out.println("Bem vindo. Seu primeiro array foi inicializado. Digite comando: "
				+ "\n1) Retornar soma; "
				+ "\n2) Retornar o maior inteiro do array: "
				+ "\n3) Retornar quantidade de ocorrencias de um inteiro especificado: "
				+ "\n4) Trocar posição de todos os elementos do array.");
		
		
		
		System.out.println("Seu array atual é: ");
		for (int i = 0; i < numero.getNumeros().length; i++){
				System.out.print(numero.getNumeros()[i] + " ");
		}
		escolha = in.nextInt();
		
		
		switch (escolha){
		case (1):
			System.out.println(numero.getSum());
			break;
		
		case(2):
			System.out.println(numero.getGreater());
			break;
		case(3):
			System.out.println("Digite um valor: ");
		int x = in.nextInt();
			System.out.println(numero.countNumber(x));
			break;
		case(4):
			numero.changePosition();
			System.out.println("Posições trocadas. Seu novo array é: ");
			int[] troca = numero.getNumeros();
			for (int i = 0; i < troca.length; i++){
				System.out.print(troca[i] + " ");
			}
			break;
			
			
			
			
		}	
		in.close();
		
		
	}

}
