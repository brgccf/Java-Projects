package brgccf.q5;
import java.util.Scanner;
public class ProgramaJubreca {
	public static void main (String [] args){
		Scanner read = new Scanner (System.in);
		Scanner in = new Scanner (System.in);
		int line = 0, column = 0;
		String matrix;
		String answer = "";
		boolean loop = true;
		/*line e column servem para formar o campo de jubreca
		 * matrix é a string que utilizara os valores de line e column para formar o campo
		 * answer é a saída final do programa
		 * loop mantem o funcionamento do programa enquanto calcula a saida final
		 */
		System.out.println("Digite a matriz-campo: ");
		matrix = read.nextLine();
		//matriz que sera utilizada para formar o campo de jubreca
		//o for abaixo é para identificar os inteiros contidos na string formada pela entrada do usuario
		for (int contador = 0; contador < matrix.length(); contador++){
			boolean teste = matrix.charAt(contador) == '0' || matrix.charAt(contador) == '1' || 
					matrix.charAt(contador) == '2' || matrix.charAt(contador) == '3' || matrix.charAt(contador) == '4'
					|| matrix.charAt(contador) == '5' || matrix.charAt(contador) == '6' || matrix.charAt(contador) == '7'
					|| matrix.charAt(contador) == '8' || matrix.charAt(contador) == '9';
			if (teste){
				if (line == 0){
					line = matrix.charAt(contador);
					switch (line){
					case(48):
						line -= 48;
					//verifica valor invalido para matriz
					while (line <= 0){
						System.out.println("Linha invalida. Digite a Linha novamente: ");
						while(!in.hasNextInt()) in.next();
						line = in.nextInt();
					}
					break;
					case (49):
						line -= 48;
					break;
					case (50):
						line -= 48;
					break;
					case (51):
						line -= 48;
					break;
					case(52):
						line -= 48;
					break;
					case (53):
						line -= 48;
					break;
					case (54):
						line -= 48;
					break;
					case(55):
						line -= 48;
					break;
					case(56):
						line -= 48;
					break;
					case(57):
						line -= 48;


					break;
					}
				}

				else if (column == 0){
					column = matrix.charAt(contador);
					switch (column){
					case(48):
						column -= 48;
					//verifica valor invalido para matriz
					while (column <= 0){
						System.out.println("Coluna invalida. Digite a Coluna novamente: ");
						while(!in.hasNextInt()) in.next();
						column = in.nextInt();
					}
					break;
					case (49):
						column -= 48;
					break;
					case (50):
						column -= 48;
					break;
					case (51):
						column -= 48;
					break;
					case(52):
						column -= 48;
					break;
					case (53):
						column -= 48;
					break;
					case (54):
						column -= 48;
					break;
					case(55):
						column -= 48;
					break;
					case(56):
						column -= 48;
					break;
					case(57):
						column -= 48;


					break;
					}
				}

				else {
					continue;
				}


			}

		}
		
		System.out.println(line);
		System.out.println(column);
		
		//cria o objeto campo que sera utilizado para chamar os metodos da classe Campo
		Campo campo = new Campo (line, column);


		//matrizCampo é uma matriz provisoria que servirá para definir o campo chamando o metodo defineCampo
		char[][] matrizCampo = new char [line][column];
		String str = "";
		//str foi o string usado para encontrarmos os valores do tipo char digitados pelo usuario
		System.out.println("Digite os valores para sua matriz-campo: ");
		while(str.length() < line*column){
			str += read.nextLine();
		}
		
		int contador = 0;
		
		for (int i = 0; i < matrizCampo.length; i++)
		{
			for (int j = 0; j < matrizCampo[i].length; j++)
			{
				
				matrizCampo[i][j] = (char)str.charAt(contador);
				contador +=1;
			}
		}
		
		//define o campo e a posiçao inicial de jubreca:
		campo.defineCampo(matrizCampo);
		campo.defineStart();
		//imprime o campo definido
		System.out.println(campo.imprimeCampo());
		//pedindo os comandos do usuario
		System.out.println("Digite os comandos para jubreca: ");
		String aux = read.nextLine();
		String cmd = "";
		
		do{

		
			//o for abaixo le toda a string de comandos e traduz cada comando individual,
			//executando-os em seguida
			for (int count = 0; count < aux.length(); count++){
				
				if (aux.charAt(count) == ' '){
					
					
					cmd = aux.substring(0, count);
					aux = aux.substring(count+1, aux.lastIndexOf(""));
					count = 0;
					switch (cmd){
					case ("W"):
						cmd = "w";
					break;
					case("A"):
						cmd = "a";
					break;
					case ("D"):
						cmd = "d";

					break;
					case("S"):
						cmd = "s";
					break;
					case ("HIT"):
						cmd = "hit";
					break;
					case("QUIT"):
						cmd = "quit";
					break;
					
					}
					
					switch(cmd){
					case("hit"):
						answer += campo.getJubreca();
					break;
					case("w"):
						campo.moveUp();
					break;
					case("a"):
						campo.moveLeft();
					break;
					case("d"):
						campo.moveRight();
					break;
					case("s"):
						campo.moveDown();
					break;
					case("quit"):
						System.out.println(answer);
					loop = false;
					break;
					default:
						System.out.println("Comando invalido.");

					}


				}
			}
			
			if(aux.contentEquals("quit")){	
				loop = false;
			}
			else{
				aux = "";
				System.out.println("Digite os comandos para jubreca: ");
				aux = read.nextLine();
				cmd = "";
			}
		
		}while (loop == true);

		System.out.println(answer);

		in.close();
		read.close();
	}


}
