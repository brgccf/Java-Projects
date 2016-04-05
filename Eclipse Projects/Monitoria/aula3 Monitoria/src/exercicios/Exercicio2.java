package exercicios;
import java.util.Random;
public class Exercicio2 {
	public static void main (String [] args){
		Random caracteresAleatorios = new Random ();
		
		for (int i=0; i < 10; i++){
			int porcentagem = caracteresAleatorios.nextInt(4);
			/*o random recebe um valor inteiro n e 
			 * "randomiza" (n-1) variaveis que forem
			 * colocadas.
			 */
			switch (porcentagem){
			case (0):
			case (1):
				System.out.println("-");
				break;
			case (2):
				System.out.println("@");
			case (3):
				System.out.println("*");
			}
		}
	}

}
