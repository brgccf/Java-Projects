package exercicios;

public class AulaMatriz {
	private int[][] matriz;
		public AulaMatriz (int dimensao){
			this.matriz = new int [dimensao][dimensao];
			for (int i = 0; i < dimensao; i++){
				for(int j = 0; j < dimensao; j++){
					this.matriz[i][j] = i + j;
				}
			}
		}
		
		public int[][] getMatriz(){
			return this.matriz;
		}
		
		public int[] getDiagonal(){
			int [] resposta = new int [this.matriz.length];
			for (int i = 0; i< this.matriz.length; i++){
				resposta[i] = this.matriz[i][i];
			}
			return resposta;
		}
		
		public int[] getLinha(int linha){
			int [] resposta = new int[this.matriz.length];
			for (int i =0; i < this.matriz.length; i++){
				resposta [i] = this.matriz[linha][i];
			}
			return resposta;
			
			}
		
		public int[] getColuna(int coluna){
			int[]  resposta = new int [this.matriz.length];
			for (int i =0; i < this.matriz.length; i++){
				resposta[i] = this.matriz[i][coluna];
			}
			return resposta;
		}
		

}
