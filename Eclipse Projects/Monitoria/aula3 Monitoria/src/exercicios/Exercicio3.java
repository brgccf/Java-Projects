package exercicios;
import java.util.Scanner;
public class Exercicio3 {
	public static void main (String [] args){
		//deve verificar se o x é perfeito ou nao
		//numero perfeito todos os divisores deve somados
		//com exceçao dele mesmo deve dar o proprio x
		Scanner in = new Scanner (System.in);
		System.out.println("Digite um numero inteiro positivo: ");
		int numero = in.nextInt();
		int resultado = 0;
		if (numero < 0){
			System.out.println("Numero invalido.");
		}
		for (int i = 1; i <= numero/2; i++){
			if(numero % i == 0){
				resultado += i;
			}
			
		}
		if(resultado == numero){
			System.out.println("é um numero perfeito.");
		}
		else{
			System.out.println("não é um numero perfeito.");
		}
		in.close();
	}

}
