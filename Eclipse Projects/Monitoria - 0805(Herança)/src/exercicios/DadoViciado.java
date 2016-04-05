package exercicios;
import java.util.Random;
public class DadoViciado extends Dado {
	
	
	public int jogarDado(){
		Random dado = new Random();
		int valor = dado.nextInt(21);
		int retorno = 0;
		if(valor == 0){
			retorno = 1;
			
		}else if (valor == 1 || valor == 2){
			retorno = 2;
		}else if (valor > 2 && valor < 6){
			retorno = 3;
		}else if (valor > 5 && valor < 10){
			retorno = 4;
		}else if (valor > 9 && valor < 15){
			retorno = 5;
		}else{
			retorno = 6;
		}
		return retorno;
	}
}
