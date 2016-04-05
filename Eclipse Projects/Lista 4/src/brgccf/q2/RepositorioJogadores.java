package brgccf.q2;

import brgccf.q1.JogadorNaoEncontradoException;
import brgccf.q1.JogadorNaoJogaNoMesmoDiaException;
import brgccf.q1.Jogadores;
import brgccf.q1.MestreNaoEncontradoException;
import brgccf.q1.MestreNaoJogaNoMesmoDiaException;
import brgccf.q1.Mestres;
import brgccf.q3.JogadorJaExisteException;

public interface RepositorioJogadores {
	//adicionar jogadores
	public void setJogadores(Jogadores jogador) throws JogadorJaExisteException; 
	public void setMestres(Mestres mestre) throws JogadorJaExisteException;
	//buscar jogadores
	public Mestres procuraMestre(String login, int diaSessao) throws MestreNaoEncontradoException, MestreNaoJogaNoMesmoDiaException;
	public Jogadores procuraJogador(String login, int diaSessao) throws JogadorNaoEncontradoException, JogadorNaoJogaNoMesmoDiaException;
	public Jogadores[] getJogadores();
	public Mestres[] getMestres();
	//remover jogadores:
	public void removerMestre(String login)  throws MestreNaoEncontradoException ;
	public void removerJogador(String login) throws JogadorNaoEncontradoException;
	//verificar se existe:
	public boolean existeMestre(String login) throws MestreNaoEncontradoException;
	public boolean existeJogador(String login) throws JogadorNaoEncontradoException;
	
	
	
}
