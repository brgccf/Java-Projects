package brgccf.q3;

import brgccf.q1.Jogadores;
import brgccf.q1.Mestres;
import brgccf.q1.Sessao;
import brgccf.q2.RepositorioSessoes;

public class NegocioSessoes {

	private RepositorioSessoes sessoes;

	public NegocioSessoes (RepositorioSessoes rep){
		this.sessoes = rep;
	}

	public void addSessao(int dia, String nomeAventura, Mestres mestre, Jogadores[] jogadores) throws SessaoJaExisteException{
		boolean existe = false;
		try{
			existe = this.sessoes.existeSessao(nomeAventura);
		}
		//se houver exceção, então é porque não existe tal sessão, e podemos cadastrá-la.
		catch(SessaoNaoEncontradaException e){
			this.sessoes.setSessao(dia, nomeAventura, mestre, jogadores);
		}
		//se existe, então já temos uma sessão cadastrada
		if(existe){
			throw new SessaoJaExisteException();
		}
	}

	public void removerSessao(String loginMestre, String nomeAventura) throws SessaoAbertaException, SessaoNaoEncontradaException {
		//removendo
		this.sessoes.removerSessao(loginMestre, nomeAventura);

	}
	
	public Sessao buscarSessao(String loginMestre, String nomeAventura) throws SessaoNaoEncontradaException{
		Sessao sessao = this.sessoes.buscarSessao(loginMestre, nomeAventura);
		return sessao;
	}
	
	public boolean existeSessao(String nomeAventura) throws SessaoNaoEncontradaException{
		boolean existe = this.sessoes.existeSessao(nomeAventura);
		return existe;
	}
	
	public void setSessoesAbertas(String nomeAventura) throws SessaoNaoEncontradaException{
		this.sessoes.setSessoesAbertas(nomeAventura);
	}


}
