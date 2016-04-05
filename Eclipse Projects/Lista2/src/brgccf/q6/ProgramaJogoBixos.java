package brgccf.q6;
import java.util.Scanner;
public class ProgramaJogoBixos {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		//loop mantem o funcionamento do programa
		boolean loop = true;
		do{

			System.out.println("\nDigite um numero: ");
			String valor = in.nextLine();
			//valor armazena a string inicial
			boolean isNegative = false;
			//isnegative testa se o numero digitado foi negativo

			//teste para ver se o usuario deseja finalizar o programa
			if (valor.equals("quit")){
				loop = false;
			}
			//se o usuario tiver digitado numero negativo, o programa trabalha somente com os numeros para no final
			//imprimir o resultado acrescentando o '-'
			else if (valor.charAt(0) == '-'){
				valor = valor.substring(1, valor.length());
				isNegative = true;
			}
			//tratando das entradas invalidas:
			else if (loop == true){
				for (int i = 0; i <= valor.length() - 1; i++) 

				{

					while (loop == true && valor.charAt(i) < 48 || valor.charAt(i) > 57) 
					{
						valor = "";
						isNegative = false;	
						i = 0;
						System.out.println("Entrada invalida. Tente novamente: ");

						valor = in.nextLine();
						if (valor.equals("quit")){
							loop = false;
							valor = "1";

						}
						else if (valor.charAt(0) == '-'){
							valor = valor.substring(1, valor.length());
							isNegative = true;
						}	
						else{
							i = 0;
						}

					}
				}
			}

			// caso a entrada seja correta, vamos organizar os numeros
			if (loop == true){



				char[] array = new char [valor.length()];
				for (int i = 0; i < array.length; i++){
					array[i] = valor.charAt(i);
				}


				char temp;
				int aux = 0;
				for (int j = 0; j < array.length; j++) {
					aux = j;
					for(int k = aux + 1; k < array.length; k++){
						if (array[k] < array[aux]) {
							aux = k;
						}
						temp = array[aux];
						array[aux] = array[j];
						array[j] = temp;
					}


				}
				//com nosso array em maos, resta organizar os numeros dependendo se for positivo ou negativo
				System.out.println("Resultado: ");
				//condiçao abaixo testa se o numero digitado é positivo ou negativo
				//caso seja negativo, organizamos em ordem crescente
				if(isNegative){
					System.out.print("-");
					for(int i = 0; i < array.length; i++){
						System.out.print(array[i]);
					}
				}
				//caso seja positivo, organizamos em ordem decrescente
				else{
					for(int i = array.length - 1; i >= 0; i--){
						System.out.print(array[i]);
					}
				}

			}

		}while (loop == true);

		System.out.println("Até a próxima.");








		in.close();
	}

}
