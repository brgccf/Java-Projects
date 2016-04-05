package brgccf.q1;

@SuppressWarnings("serial")
public class JogadorNaoJogaNoMesmoDiaException extends Exception{
	private Jogadores jogador;
	public JogadorNaoJogaNoMesmoDiaException (Jogadores jogador){
		super("O Jogador abaixo n�o pode jogar no mesmo dia dos demais nesta Sess�o! Tente novamente. Digite o login de outro jogador:");
		this.jogador = jogador;
	}
	public Jogadores getJogador(){
		return this.jogador;
	}
}
