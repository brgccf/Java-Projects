package exercicios;
import java.util.Scanner;
public class Exercicio1 {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		double a, b, soma, subtracao, multiplicacao;
		double divisao;
		char op;
		System.out.println("Digite a: ");
		a = in.nextInt();
		System.out.println("Digite op: ");
		op = in.next().charAt(0);
		System.out.println("Digite b: ");
		b = in.nextInt();
		soma = (a + b);
		subtracao = (a - b);
		multiplicacao = (a * b);
		divisao = (a / b);
		
		switch (op){
		case '+':{
			System.out.println(a + " + " + b + " = " + soma);
			break;
		}
		case '-':{
			System.out.println(a + " - " + b + " = " + subtracao);
			break;
		}
		case '*':{
			System.out.println(a + " * " + b + " = " + multiplicacao);
			break;
		}
		case '/':{
			System.out.println(a + " / " + b + " = " + divisao);
			break;
		}
		default:
			System.out.println("Operador Inválido.");
		
		}
	}

}
