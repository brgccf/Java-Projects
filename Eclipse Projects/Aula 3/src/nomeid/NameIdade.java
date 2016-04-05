package nomeid;
import java.util.Scanner;
public class NameIdade {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.println("Digite seu nome: ");
		String nome = in.nextLine();
		System.out.println("Digite sua idade: ");
		int idade = in.nextInt();
		System.out.print("Olá, "); 
		System.out.print(nome);
		System.out.print("! Você tem ");
		System.out.print(idade);
		System.out.print(" anos!");
		

	}

}
