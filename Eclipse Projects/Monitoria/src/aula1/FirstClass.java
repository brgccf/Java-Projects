package aula1;
import java.util.Scanner;
public class FirstClass {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		//A classe String representa uma cadeia de caracteres, 
		//� criada por java.lang.String
		//Sring nome = "monitoria"
		//Modulo(%) � quando se divide a e b armazenando seu resto
		//Operadores logicos s�o utilizados para direcionar o programa de acordo com a decis�o do usuario
		//receber dois valores do usuario e trocar seus valores
		//
		String artista;
		String album;
		int ano;
		System.out.println("Digite o artista/banda: ");
		artista = in.nextLine();
		System.out.println("Digite o album: ");
		album = in.nextLine();
		System.out.println("Digite o ano de lan�amento: ");
		ano = in.nextInt();
		
		System.out.println("Banda: " + artista + " �lbum: " + album + " Ano de Lan�amento: " + ano);
	}

}
