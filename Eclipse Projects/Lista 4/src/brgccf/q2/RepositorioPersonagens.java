package brgccf.q2;

import brgccf.q1.PersonagemNaoEncontradoException;
import brgccf.q1.PersonagemSendoUtilizadoException;
import brgccf.q1.Personagens;
import brgccf.q3.PersonagemJaExisteException;

public interface RepositorioPersonagens {
	
	public Personagens[] getPersonagens();
	//adicionar personagens
	public void setPersonagens(Personagens personagem) throws PersonagemJaExisteException;
	//buscar personagens
	public Personagens procuraPersonagem(String nome) throws PersonagemNaoEncontradoException, PersonagemSendoUtilizadoException;
	//remover personagens:
	public void removerPersonagem(String nome) throws PersonagemNaoEncontradoException, PersonagemSendoUtilizadoException;
	//verificar se o personagem existe:
	public boolean existePersonagem(String nome) throws PersonagemNaoEncontradoException;
	
	
	
}
