package brgccf.q1;
import java.util.Scanner;
public class Questao1 {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		//Duas fotos por pagina
		//Altura: Checagem por soma
		//Largura: Checagem por tamanho da foto
		int a, b, c, d, e, f;
		int soma, tamanho1, tamanho2;
		System.out.println("Digite a altura da página: ");
		a = in.nextInt();
		System.out.println("Digite o comprimento: ");
		b = in.nextInt();
		
		System.out.println("Digite a altura da primeira foto: ");
		c = in.nextInt();
		System.out.println("Digite o comprimento dela: ");
		d = in.nextInt();
		
		System.out.println("Digite a altura da segunda foto: ");
		e = in.nextInt();
		System.out.println("Digite o comprimento dela: ");
		f = in.nextInt();
		
		soma = (c + e);
		tamanho1 = d;
		tamanho2 = f;
		
		if ((a <= 0) || (b <=0) || (c <= 0) || (d <= 0) || (e <= 0) || (f <= 0)){
			System.out.println("Não é possível colar as fotos. Insira valores positivos inteiros.");
			System.out.println("Fim de programa.");
		}
		else if ((soma <= 0) || (tamanho2 > b)){
			System.out.println("Não é possível colar as fotos.");
			System.out.println("Fim de programa.");
		}
		else if ((soma > a) || (tamanho1 > b)){
			System.out.println("Não é possível colar as fotos.");
			System.out.println("Fim de programa.");}
		else{
			System.out.println("É possível colar as fotos.");
			System.out.println("Fim de programa.");
		}
		
	}

}
