package aula1;
import java.util.Scanner;
public class FilmeTenso {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		int idade;
		String sexo;
		System.out.println("Digite sua idade: ");
		idade = in.nextInt();
		in.nextLine();
		System.out.println("Digite seu sexo (M ou F): ");
		sexo = in.nextLine();
		if ((idade >= 18) & (sexo == "M")){
			System.out.println("True!");}
				
		}
	}

