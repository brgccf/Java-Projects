package exercicios;

public class MeuArray {
	private int [] numeros;
	public MeuArray (){
		this.numeros = new int[5];
		this.numeros[0] = 1;
		this.numeros[1] = 2;
		this.numeros[2] = 3;
		this.numeros[3] = 4;
		this.numeros[4] = 5;
	}
	
	public int getSum (){
		int soma = 0;
		for (int i = 0; i < this.numeros.length ; i++ ){
			soma += this.numeros[i];
		}
		
		return soma;
	}
	
	public int getGreater (){
		int maior = this.numeros[0];
		for (int i = 1; i < this.numeros.length; i++){
			if (this.numeros[i] > maior){
				maior = this.numeros[i];
			}
			else{
				continue;
			}
		}
		return maior;
	}
	
	public int countNumber (int valor){
		int contador = 0;
		for (int i = 0; i < this.numeros.length; i++){
			if (this.numeros[i] == valor){
				contador ++;
			}
		}
		return contador;
	}
	
	public void changePosition (){
		int []troca = new int [this.numeros.length];
		for (int i = 0 ; i < this.numeros.length; i++){
			troca[i] = this.numeros[this.numeros.length-i-1];
		}
		
	}
	
	public int[] getNumeros (){
		return this.numeros;
	}
	
}
