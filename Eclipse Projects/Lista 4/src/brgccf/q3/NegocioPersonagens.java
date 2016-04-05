package brgccf.q3;

import brgccf.q1.PersonagemNaoEncontradoException;
import brgccf.q1.PersonagemSendoUtilizadoException;
import brgccf.q1.Personagens;
import brgccf.q2.RepositorioPersonagens;

public class NegocioPersonagens {

	private RepositorioPersonagens personagens;

	public NegocioPersonagens (RepositorioPersonagens rep){
		this.personagens = rep;
	}

	public void addPersonagem(Personagens personagem) throws PersonagemJaExisteException{
		boolean existe = false;
		try {
			existe = this.personagens.existePersonagem(personagem.getNome());
		} catch (PersonagemNaoEncontradoException e) {
			this.personagens.setPersonagens(personagem);
		}
		if(existe){
			throw new PersonagemJaExisteException();
		}
	}
	
	public Personagens procuraPersonagem(String nome)
			throws PersonagemNaoEncontradoException,
			PersonagemSendoUtilizadoException {
		Personagens personagemProcurado = null;
		boolean achou = this.personagens.existePersonagem(nome);
		if(achou){
			personagemProcurado = this.personagens.procuraPersonagem(nome);
		}
		return personagemProcurado;
	}
	
	public void removerPersonagem(String nome)
			throws PersonagemNaoEncontradoException,
			PersonagemSendoUtilizadoException {
		boolean achou = this.personagens.existePersonagem(nome);
		if(achou){
			this.personagens.removerPersonagem(nome);
		}
	}
	
	

}
