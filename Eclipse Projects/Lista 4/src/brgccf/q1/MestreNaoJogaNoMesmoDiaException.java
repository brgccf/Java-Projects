package brgccf.q1;

@SuppressWarnings("serial")
public class MestreNaoJogaNoMesmoDiaException extends Exception {
	
	public MestreNaoJogaNoMesmoDiaException(){
		super("O mestre digitado n�o pode jogar no mesmo dia desta sess�o! Tente novamente. Digite o login de um mestre: ");
	}

}
