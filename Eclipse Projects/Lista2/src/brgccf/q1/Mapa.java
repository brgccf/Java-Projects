package brgccf.q1;

public class Mapa {
	private char[][] mapa;
	private Personagem p;
	
	
	public Mapa (Personagem P){
		this.mapa = new char [10][10];
		this.p = P;
	}
	
	public char[][] getMapa(){
		return this.mapa;
	}
	
	//definindo posicoes iniciais
	public void defineInicio(){
		this.mapa[0][0] = 'T';
		this.mapa[9][9] = this.p.getP();
	}
	
	//criando o mapa do jogo
	public void defineChao(){
		this.mapa[1][0] = '_';
		this.mapa[1][1] = '_';
		this.mapa[1][2] = '_';
		this.mapa[1][3] = '_';
		this.mapa[2][2] = '_';
		this.mapa[2][5] = '_';
		this.mapa[0][3] = '_';
		this.mapa[0][4] = '_';
		this.mapa[0][5] = '_';
		this.mapa[0][6] = '_';
		this.mapa[0][7] = '_';
		this.mapa[1][7] = '_';
		this.mapa[2][7] = '_';
		this.mapa[3][7] = '_';
		this.mapa[3][4] = '_';
		this.mapa[3][5] = '_';
		this.mapa[3][6] = '_';
		this.mapa[4][2] = '_';
		this.mapa[4][4] = '_';
		this.mapa[4][7] = '_';
		this.mapa[5][4] = '_';
		this.mapa[5][5] = '_';
		this.mapa[5][6] = '_';
		this.mapa[5][7] = '_';
		this.mapa[6][6] = '_';
		this.mapa[6][7] = '_';
		this.mapa[6][8] = '_';
		this.mapa[7][5] = '_';
		this.mapa[7][7] = '_';
		this.mapa[7][8] = '_';
		this.mapa[8][7] = '_';
		this.mapa[9][7] = '_';
		this.mapa[9][8] = '_';
	
	}
	//definindo posicoes das armadilhas
	public void defineArmadilha(){
		this.mapa[0][1] = '*';
		this.mapa[2][1] = '*';
		this.mapa[2][0] = '*';
		this.mapa[3][2] = '*';
		this.mapa[9][5] = '*';
		this.mapa[0][2] = '@';
		this.mapa[2][3] = '@';
		this.mapa[2][4] = '@';
		this.mapa[3][0] = '@';
		this.mapa[4][0] = '@';
		this.mapa[5][1] = '@';
		this.mapa[6][2] = '@';
		this.mapa[6][3] = '@';
		this.mapa[7][2] = '@';
		this.mapa[7][4] = '@';
		this.mapa[1][5] = '#';
		this.mapa[1][6] = '#';
		this.mapa[2][6] = '#';
		this.mapa[3][3] = '#';
		this.mapa[3][1] = '#';
		this.mapa[4][1] = '#';
		this.mapa[5][0] = '#';
		this.mapa[5][3] = '#';
		this.mapa[6][5] = '#';
		this.mapa[7][3] = '#';
		this.mapa[7][9] = '#';
		this.mapa[8][0] = '#';
		this.mapa[8][1] = '#';
		this.mapa[8][2] = '#';
		this.mapa[8][4] = '#';
		this.mapa[8][5] = '#';
		this.mapa[9][0] = '#';
		this.mapa[9][1] = '#';
		this.mapa[9][2] = '#';
		this.mapa[9][3] = '#';
		this.mapa[0][8] = '^';
		this.mapa[0][9] = '^';
		this.mapa[1][4] = '^';
		this.mapa[1][8] = '^';
		this.mapa[1][9] = '^';
		this.mapa[2][8] = '^';
		this.mapa[2][9] = '^';
		this.mapa[3][8] = '^';
		this.mapa[3][9] = '^';
		this.mapa[4][3] = '^';
		this.mapa[4][5] = '^';
		this.mapa[4][6] = '^';
		this.mapa[4][8] = '^';
		this.mapa[4][9] = '^';
		this.mapa[5][2] = '^';
		this.mapa[5][8] = '^';
		this.mapa[5][9] = '^';
		this.mapa[6][0] = '^';
		this.mapa[6][1] = '^';
		this.mapa[6][4] = '^';
		this.mapa[6][9] = '^';
		this.mapa[7][0] = '^';
		this.mapa[7][1] = '^';
		this.mapa[7][6] = '^';
		this.mapa[8][3] = '^';
		this.mapa[8][6] = '^';
		this.mapa[8][8] = '^';
		this.mapa[8][9] = '^';
		this.mapa[9][4] = '^';
		this.mapa[9][6] = '^';
		
	}
	//metodo pra imprimir mapa
	public String printMap(){
		String print = "";
		
		for (int i = 0; i < this.mapa.length; i++){
			for(int j = 0; j < this.mapa[i].length; j++){
				print += this.mapa[i][j];
				if (j == 9){
					print += "\n";
				}
			}
		}
		
		return print;
	}
	//metodo de movimento pra cima
	
	public void moveUp(){
		//os passos abaixo sao validos para todos os metodos de movimento
		//1º passo: varrer o array e encontrar o personagem
		for (int i = 0; i < this.mapa.length; i++){
			for (int j = 0; j < this.mapa[i].length; j++){
				if (this.mapa[i][j] == 'P'){
					/*2º passo: com o personagem em maos,
					 * vamos alterar as posicoes do array de acordo
					 * com o movimento escolhido
					 */
					i -= 1;
					//verifica se está fora dos limites do mapa
					if (i < 0){
						i += 1;
						System.out.println("Movimento invalido.");
					}
					
					else{
						char troca = this.mapa[i][j];
						/*3º Passo: verificar se o personagem caiu
						 * em alguma armadilha
						 */
						switch (troca){
						case('^'):
							this.p.spikes();
							System.out.println("Armadilha de espinhos!");
							break;
						case('#'):
							this.p.arrows();
							System.out.println("Armadilha de flechas!");
							break;
						case('@'):
							this.p.hole();
							System.out.println("Armadilha de buraco!");
							break;
						case('*'):
							this.p.flames();
							System.out.println("Armadilha de chamas!");
							break;
						
						
						}
						
						
						//altera as duas posicoes envolvidas do mapa
						
						this.mapa[i][j] = 'P';
						this.mapa[i+1][j] = troca;
						
						
					}
				}
			}
		}
		//caso tenha chegado no tesouro:
		if (this.mapa[0][0] == 'P'){
			this.p.victory();
		}
	}
	//metodo de movimento para direita
	public void moveRight(){
		for (int i = 0; i < this.mapa.length; i++) {
			for (int j = 0; j < this.mapa[i].length; j++) {
				if (this.mapa[i][j] == 'P'){
					j +=1;
					if (j > 9){
						j -= 1;
						System.out.println("Movimento invalido.");
					}
					else{
						char troca = this.mapa[i][j];
						switch (troca){
						case('^'):
							this.p.spikes();
							System.out.println("Armadilha de espinhos!");
							break;
						case('#'):
							this.p.arrows();
							System.out.println("Armadilha de flechas!");
							break;
						case('@'):
							this.p.hole();
							System.out.println("Armadilha de buraco!");
							break;
						case('*'):
							this.p.flames();
							System.out.println("Armadilha de chamas!");
							break;
					
						
						}
						
						//altera as duas posicoes envolvidas do mapa
						
						this.mapa[i][j] = 'P';
						this.mapa[i][j-1] = troca;
						
						
					}
				}
			}
		}
		//caso tenha chegado no tesouro:
		if (this.mapa[0][0] == 'P'){
			this.p.victory();
		}
	}
	//metodo de movimento para esquerda
	public void moveLeft(){
		for (int i = 0; i < this.mapa.length; i++) {
			for (int j = 0; j < this.mapa[i].length; j++) {
				if (this.mapa[i][j] == 'P'){
					j -=1;
					if (j < 0){
						j += 1;
						System.out.println("movimento invalido.");
					}
					else{
						char troca = this.mapa[i][j];
						
						switch (troca){
						case('^'):
							this.p.spikes();
							System.out.println("Armadilha de espinhos!");
							break;
						case('#'):
							this.p.arrows();
							System.out.println("Armadilha de flechas!");
							break;
						case('@'):
							this.p.hole();
							System.out.println("Armadilha de buraco!");
							break;
						case('*'):
							this.p.flames();
							System.out.println("Armadilha de chamas!");
							break;
						
						
						}
						
						
						//altera as duas posicoes envolvidas do mapa
						
						this.mapa[i][j] = 'P';
						this.mapa[i][j+1] = troca;
						
						
					}
				}
			}
		}
		if (this.mapa[0][0] == 'P'){
			this.p.victory();
		}
	}
	//metodo de movimento pada baixo
	public void moveDown(){
		for (int i = 0; i < this.mapa.length; i++) {
			for (int j = 0; j < this.mapa[i].length; j++) {
				if (this.mapa[i][j] == 'P'){
					i += 1;
					if (i > 9){
						i -= 1;
						System.out.println("Movimento invalido.");
					}
					else{
						char troca = this.mapa[i][j];
						
						switch (troca){
						case('^'):
							this.p.spikes();
							System.out.println("Armadilha de espinhos!");
							break;
						case('#'):
							this.p.arrows();
							System.out.println("Armadilha de flechas!");
							break;
						case('@'):
							this.p.hole();
							System.out.println("Armadilha de buraco!" );
							break;
						case('*'):
							this.p.flames();
							System.out.println("Armadilha de chamas!");
							break;
						
						}
						
					
						//altera as duas posicoes envolvidas do mapa
						
						this.mapa[i][j] = 'P';
						this.mapa[i-1][j] = troca;
						
						
					}
				}
			}
			
		}
		//caso tenha chegado no tesouro:
		if (this.mapa[0][0] == 'P'){
			this.p.victory();
		}
	}
	
		
		
	

}
