package Exercicios;

public class Multiplicacao {

	public int produto (int a, int b){
		int resposta = 0;
		if (a > 0){
			resposta = b + produto(a-1, b);
		}
		return resposta;
	}
	

}

