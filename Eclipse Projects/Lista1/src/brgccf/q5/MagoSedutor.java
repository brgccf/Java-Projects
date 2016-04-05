package brgccf.q5;
import java.util.Scanner;
public class MagoSedutor {
		public static void main (String [] args){
			Scanner in = new Scanner (System.in);
			char letra, resultado;
			int deslocamento, a;
			int i;
			boolean b = true;
			/*"letra" avalia cada letra digitada pelo usuario
			 * resultado dá o resultado da avaliação feita por "letra"
			 * deslocamento é entrada do usuario para execução do programa
			 * "a" realiza um teste para verificar se, de acordo com o 
			 * deslocamento, o alfabeto terminou ou nao, e reinicia a contagem
			 * de letras.
			 * "i" realiza a contagem para a saida do laço em que a
			 * string digitada é lida.
			 * "b" é responsavel por terminar o programa quando o usuario digitar END.
			 */
			System.out.println("Digite o deslocamento : ");
			deslocamento = in.nextInt();
			while (deslocamento <= 0){
				System.out.println("Valor invalido. Tente novamente: ");
				deslocamento = in.nextInt();
			}
			in.nextLine();
			do{
			System.out.println("\nDigite a frase: ");
			String frase = in.nextLine();
			if (frase.equals("END")){
				b = false;
			}
			if (b == true){
			//laço fazendo ler de uma em uma ate acabar a string
			for (i = 0; i < frase.length(); i++){
				a = (int)frase.charAt(i) + deslocamento;
				letra = (char)frase.charAt(i);
				if (a > 90){
					letra = frase.charAt(i);
					letra -= 26;
				}
				if (letra == 32){
					System.out.print(" ");
				}
				else{
					letra += deslocamento;
					resultado = (char)(letra);
					System.out.print(resultado);
				}
			}
				frase = null;
			}
			}while (b == true);
			System.out.println("\nFim de programa.");
			in.close();
		}

}