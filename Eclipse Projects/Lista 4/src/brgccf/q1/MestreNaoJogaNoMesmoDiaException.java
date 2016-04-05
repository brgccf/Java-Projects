package brgccf.q1;

@SuppressWarnings("serial")
public class MestreNaoJogaNoMesmoDiaException extends Exception {
	
	public MestreNaoJogaNoMesmoDiaException(){
		super("O mestre digitado não pode jogar no mesmo dia desta sessão! Tente novamente. Digite o login de um mestre: ");
	}

}
