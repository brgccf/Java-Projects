package brgccf.q5;

public class Campo {
	private char [][] campo;
	
	private char jubreca;
	
	public Campo (int linha, int coluna){
		this.campo = new char [linha][coluna];
		this.jubreca = this.campo[0][0];
		
	}
	
	public char[][] getCampo(){
		return this.campo;
	}
	
	public char getJubreca(){
		return this.jubreca;
	}
	
	//metodo para imprimir o campo
	public String imprimeCampo(){
		String imprimir = "";
		
		for (int i = 0; i < this.campo.length; i++) {
			for (int j = 0; j < this.campo[i].length; j++) {
				imprimir += this.campo[i][j];
				
				if (j == this.campo[i].length - 1){
					imprimir += "\n";
				}
			}
			
		}
		return imprimir;
	}
	//define o campo de acordo com a matriz provisoria criada no main
	public void defineCampo(char[][] matrizCampo){
		this.campo = matrizCampo;
	}
	//define a posiçao inicial de jubreca
	public void defineStart(){
		this.jubreca = this.campo[0][0];
	}
	//metodo para movimentar para cima
	public void moveUp(){
		for (int i = 0; i < this.campo.length; i++) {
			for (int j = 0; j < this.campo[i].length; j++) {
				if(this.campo[i][j] == this.jubreca){
					i -= 1;
					if (i < 0){
						i+=1;
						System.out.println("Movimento invalido!");
					}
					else{
						this.jubreca = this.campo[i][j];
					}
				}
			}
		}
	}
	//metodo para movimentar para esquerda
	public void moveLeft(){
		for (int i = 0; i < this.campo.length; i++) {
			for (int j = 0; j < this.campo[i].length; j++) {
				if (this.campo[i][j] == this.jubreca) {
					j-=1;
					if(j < 0){
						j += 1;
						System.out.println("Movimento invalido!");
					}
					else{
						this.jubreca = this.campo[i][j];
					}
				}
			}
		}
	}
	//metodo para movimentar para direita
	public void moveRight(){
		for (int i = 0; i < this.campo.length; i++) {
			for (int j = 0; j < this.campo[i].length; j++) {
				if (this.campo[i][j] == this.jubreca) {
					j += 1;
					if (j > this.campo[i].length){
						j -= 1;
						System.out.println("Movimento invalido!");
					}
					else{
						this.jubreca = this.campo[i][j];
					}
				}
			}
		}
	}
	//metodo para movimentar para baixo
	public void moveDown(){
		for (int i = 0; i < this.campo.length; i++) {
			for (int j = 0; j < this.campo[i].length; j++) {
				if (this.campo[i][j] == this.jubreca){
					i += 1;
					if (i > this.campo[i].length){
						i -= 1;
						System.out.println("Movimento invalido!");
					}
					else{
						this.jubreca = this.campo[i][j];
					}
				}
			}
		}
	}
	
	
	

}
