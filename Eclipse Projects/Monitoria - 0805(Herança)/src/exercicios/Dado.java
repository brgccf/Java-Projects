package exercicios;
import java.util.Random;
public class Dado {
	public int jogarDado(){
		Random dado = new Random();
		//nextInt faz o random gerar um numero entre 0 e o valor dado como parametro
		//dados nao possuem valor 0, entao temos que colocar (6) + 1
		return dado.nextInt(6)+1;
	}
}
