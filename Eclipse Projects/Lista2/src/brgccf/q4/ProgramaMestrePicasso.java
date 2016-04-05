package brgccf.q4;
import java.util.Scanner;
public class ProgramaMestrePicasso {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		Scanner ler = new Scanner (System.in);
		//String matriz é o string que lê a entrada do usuario
		String matriz;
		int matriz1 = 0, matriz2 = 0;
		//matriz1 e matriz2 armazenam os inteiros para formar o array inicial
		int posicao00 = 0, posicao01 = 0, posicao02 = 0, posicao03 = 0, posicao04 = 0, posicao05 = 0;
		//posicao00 a posicao05 sao as escolhas do usuario
		int inteiro1, inteiro2, inteiro3;
		//inteiro 1, 2 e 3 sao quem vai imprimir as informações de cada cor
		boolean loop = true;
		//loop mantém o programa funcionando
		System.out.println("Digite a matriz: Obs: Os primeiros inteiros é que serão válidos");
		matriz = ler.nextLine();
		
		
		
		//fazendo a leitura da matriz como String e extraindo os primeiros inteiros:
		
		
		for (int contador = 0; contador < matriz.length(); contador++){
			boolean teste = matriz.charAt(contador) == '0' || matriz.charAt(contador) == '1' || 
					matriz.charAt(contador) == '2' || matriz.charAt(contador) == '3' || matriz.charAt(contador) == '4'
					|| matriz.charAt(contador) == '5' || matriz.charAt(contador) == '6' || matriz.charAt(contador) == '7'
					|| matriz.charAt(contador) == '8' || matriz.charAt(contador) == '9';
			if (teste) {
				
				if (matriz1 == 0){
					matriz1 = matriz.charAt(contador);
					switch (matriz1){
					case(48):
						matriz1 -= 48;
					while (matriz1 <= 0){
						System.out.println("Linha invalida. Digite a Linha novamente: ");
						while(!in.hasNextInt()) in.next();
						matriz1 = in.nextInt();
					}
						break;
					case (49):
						matriz1 -= 48;
						break;
					case (50):
						matriz1 -= 48;
						break;
					case (51):
						matriz1 -= 48;
						break;
					case(52):
						matriz1 -= 48;
						break;
					case (53):
						matriz1 -= 48;
						break;
					case (54):
						matriz1 -= 48;
						break;
					case(55):
						matriz1 -= 48;
						break;
					case(56):
						matriz1 -= 48;
						break;
					case(57):
						matriz1 -= 48;
						break;
					}
				}
				else if (matriz2 == 0){
					matriz2 = matriz.charAt(contador);
					switch (matriz2){
					case(48):
						matriz2 -= 48;
					while (matriz2 <= 0){
						System.out.println("Coluna invalida. Digite a Coluna novamente: ");
						while(!in.hasNextInt()) in.next();
						matriz2 = in.nextInt();
					}
						break;
					case (49):
						matriz2 -= 48;
						break;
					case (50):
						matriz2 -= 48;
						break;
					case (51):
						matriz2 -= 48;
						break;
					case(52):
						matriz2 -= 48;
						break;
					case (53):
						matriz2 -= 48;
						break;
					case (54):
						matriz2 -= 48;
						break;
					case(55):
						matriz2 -= 48;
						break;
					case(56):
						matriz2 -= 48;
						break;
					case(57):
						matriz2 -= 48;
						break;
					}
				}
				
				
				else {
					continue;
				}
				
				
			}
			
		}
		System.out.println("Sua matriz é: " + matriz1 + " x " + matriz2);

		System.out.println("Digite sua grade de referencias a cores: ");
		//array formado a partir da matriz inicial
		int[][] array = new int [matriz1][matriz2];
		for (int i = 0; i < array.length; i++ ){
			for (int j = 0; j < array[i].length; j++){
				while(!in.hasNextInt()) in.next();
				array[i][j] = in.nextInt();
			}
		}
		
		
		//imprime todos os numeros do array acima
		for (int i = 0; i < matriz1; i++){
			for(int j = 0; j < matriz2; j++){
				System.out.print(array[i][j] + " ");
			}
		}
		
		//programa propriamente dito:
		do{
		System.out.println("\nDigite sua escolha: (3 posições)");
		while(!in.hasNextInt()) in.next();
		posicao00 = in.nextInt() - 1;
		while(!in.hasNextInt()) in.next();
		posicao01 = in.nextInt() - 1;
		if (posicao00 < 0 || posicao01 < 0){
			loop = false;
		}
		if (loop == true){
		while(!in.hasNextInt()) in.next();
		posicao02 = in.nextInt() - 1;
		while(!in.hasNextInt()) in.next();
		posicao03 = in.nextInt() - 1;
		if (posicao02 < 0 || posicao03 < 0){
			loop = false;
		}
		}
		if (loop == true){
		while(!in.hasNextInt()) in.next();
		posicao04 = in.nextInt() - 1;
		while(!in.hasNextInt()) in.next();
		posicao05 = in.nextInt() - 1;
		if (posicao04 < 0 || posicao05 < 0){
			loop = false;
		}
		}
		
		if (loop == true){
		//pega valores do array posiçoes da matriz foram escolhidas:
		inteiro1 = array[posicao00][posicao01];
		inteiro2 = array[posicao02][posicao03];
		inteiro3 = array[posicao04][posicao05];
		//define os objetos cores:
		Cor Red = new Cor(255, 0, 0, "Red");
		Cor Orange = new Cor (255, 127, 0, "Orange");
		Cor Yellow = new Cor (255, 255, 0, "Yellow");
		Cor Green = new Cor (0, 255, 0, "Green");
		Cor Blue = new Cor (0, 0, 255, "Blue");
		Cor Indigo = new Cor (75, 0, 130, "Indigo");
		Cor Violet = new Cor (143, 0, 255, "Violet");
		
		
		//verifica e imprime a cor:
				if (inteiro1 == Red.getR() & inteiro2 == Red.getB() && inteiro3 == Red.getG()){
					System.out.println(Red.getNomeCor() + " (" + inteiro1 + ", " + inteiro2 + ", " + inteiro3 + ")");
					
					
				}
				
				else if (inteiro1 == Orange.getR() & inteiro2 == Orange.getB() && inteiro3 == Orange.getG()){
					System.out.println(Orange.getNomeCor() + " (" + inteiro1 + ", " + inteiro2 + ", " + inteiro3 + ")");
					
					
				}
				
				else if (inteiro1 == Yellow.getR() & inteiro2 == Yellow.getB() && inteiro3 == Yellow.getG()){
					System.out.println(Yellow.getNomeCor() + " (" + inteiro1 + ", " + inteiro2 + ", " + inteiro3 + ")");
					
					
				}
				
				else if (inteiro1 == Green.getR() & inteiro2 == Green.getB() && inteiro3 == Green.getG()){
					System.out.println(Green.getNomeCor() + " (" + inteiro1 + ", " + inteiro2 + ", " + inteiro3 + ")");
					
					
				}
				
				else if (inteiro1 == Blue.getR() & inteiro2 == Blue.getB() && inteiro3 == Blue.getG()){
					System.out.println(Blue.getNomeCor() + " (" + inteiro1 + ", " + inteiro2 + ", " + inteiro3 + ")");
					
					
				}
				
				else if (inteiro1 == Indigo.getR() & inteiro2 == Indigo.getB() && inteiro3 == Indigo.getG()){
					System.out.println(Indigo.getNomeCor() + " (" + inteiro1 + ", " + inteiro2 + ", " + inteiro3 + ")");
					
					
				}
				
				else if (inteiro1 == Violet.getR() & inteiro2 == Violet.getB() && inteiro3 == Violet.getG()){
					System.out.println(Violet.getNomeCor() + " (" + inteiro1 + ", " + inteiro2 + ", " + inteiro3 + ")");
					
					
				}
				
				else{
					System.out.println("Black" +  " (" + inteiro1 + ", " + inteiro2 + ", " + inteiro3 + ")");
					
				}
			
				
		
		}
	}while (loop == true);
		
		System.out.println("Fim de programa.");
		
		
		ler.close();
		in.close();
	}
	
	

}
