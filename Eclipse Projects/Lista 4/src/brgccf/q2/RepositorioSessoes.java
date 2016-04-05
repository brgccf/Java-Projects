package brgccf.q2;

import brgccf.q1.Jogadores;
import brgccf.q1.Mestres;
import brgccf.q1.Sessao;
import brgccf.q3.SessaoAbertaException;
import brgccf.q3.SessaoJaExisteException;
import brgccf.q3.SessaoNaoEncontradaException;

public interface RepositorioSessoes {
	
	public Sessao[] getSessoes();
	//add sessão
	public void setSessao(int dia, String nomeAventura, Mestres mestre, Jogadores[] jogadores) throws SessaoJaExisteException;
	//remover sessão
	public void removerSessao(String loginMestre, String nomeAventura) throws SessaoAbertaException, SessaoNaoEncontradaException;
	//buscar sessão:
	public Sessao buscarSessao(String loginMestre, String nomeAventura) throws SessaoNaoEncontradaException;
	//verificar se existe sessão:
	public boolean existeSessao(String nomeAventura) throws SessaoNaoEncontradaException;
	//abrir sessao:
	public void setSessoesAbertas(String nomeAventura) throws SessaoNaoEncontradaException;
	
	
	

}
