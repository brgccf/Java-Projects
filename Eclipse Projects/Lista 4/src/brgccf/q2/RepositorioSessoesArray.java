package brgccf.q2;

import brgccf.q1.Jogadores;
import brgccf.q1.Mestres;
import brgccf.q1.Sessao;
import brgccf.q3.SessaoAbertaException;
import brgccf.q3.SessaoJaExisteException;
import brgccf.q3.SessaoNaoEncontradaException;

public class RepositorioSessoesArray implements RepositorioSessoes {

	private Sessao[] sessoes;

	//atributo para ter controle sobre quais sessoes estao abertas
	private boolean[] sessoesAbertas;

	public RepositorioSessoesArray(){
		this.sessoes = new Sessao[2];
		this.sessoesAbertas = new boolean[2];
	}

	public Sessao[] getSessoes() {
		return this.sessoes;
	}

	public boolean[] getSessoesAbertas(){
		return this.sessoesAbertas;
	}
	//metodo para abrir uma sessao
	public void setSessoesAbertas(String nomeAventura) throws SessaoNaoEncontradaException{
		boolean achou = this.existeSessao(nomeAventura);
		int idSessao = 0;
		if(achou){
			for (int i = 0; i < this.sessoes.length; i++) {
				if(this.sessoes[i].getNomeAventura().equalsIgnoreCase(nomeAventura)){
					idSessao = i;
				}
			}
		}
		this.sessoesAbertas[idSessao] = true;
	}


	public void setSessao(int dia, String nomeAventura, Mestres mestre, Jogadores[] jogadores) throws SessaoJaExisteException {
		//se o array de sessoes estiver cheio, duplicamos seu tamanho:
		if(this.sessoes[this.sessoes.length-1] != null){
			Sessao[] aux = new Sessao [this.sessoes.length*2];
			for (int i = 0; i < sessoes.length; i++) {
				aux[i] = this.sessoes[i];
			}
			this.sessoes = aux;
		}

		boolean existe = false;
		try{
			existe = this.existeSessao(nomeAventura);
		}
		//se houver exceção, então é porque não existe tal sessão, e podemos cadastrá-la.
		catch(SessaoNaoEncontradaException e){
			Sessao sessaoCriada = new Sessao(dia, nomeAventura, mestre, jogadores);
			boolean achou = false;
			for (int i = 0; !achou && i < this.sessoes.length; i++) {
				if(this.sessoes[i] == null){
					achou = true;
					this.sessoes[i] = sessaoCriada;
				}
			}
		}
		//se existe, então já temos uma sessão cadastrada
		if(existe){
			throw new SessaoJaExisteException();
		}
	}


	public void removerSessao(String loginMestre, String nomeAventura) throws SessaoAbertaException, SessaoNaoEncontradaException {
		int idSessao = 0;
		//encontrando a sessao
		boolean existe = this.existeSessao(nomeAventura);
		if(existe){
			for (int i = 0; i < this.sessoes.length; i++) {
				if(this.sessoes[i].getNomeAventura().equalsIgnoreCase(nomeAventura)){
					idSessao = i;
					i = this.sessoes.length;
				}
			}

			//se a sessao encontrada estiver aberta, então lançamos uma exceção.
			if(this.sessoesAbertas[idSessao]){
				throw new SessaoAbertaException();

			}
			//se nao, então removemos esta sessao.
			else{
				this.sessoes[idSessao] = null;
			}
		}


	}


	public Sessao buscarSessao(String loginMestre, String nomeAventura) throws SessaoNaoEncontradaException {
		boolean achou = this.existeSessao(nomeAventura);
		if(!achou){
			throw new SessaoNaoEncontradaException();
		}
		Sessao sessaoBuscada = null;
		for (int i = 0; i < this.sessoes.length; i++) {
			if(this.sessoes[i].getMestre().getLogin().equalsIgnoreCase(loginMestre)){
				sessaoBuscada = this.sessoes[i];
			}
		}

		return sessaoBuscada;
	}


	public boolean existeSessao(String nomeAventura) throws SessaoNaoEncontradaException {
		boolean achou = false;

		//procurando sessao
		for (int i = 0; i < this.sessoes.length; i++) {
			if(this.sessoes[i].getNomeAventura().equalsIgnoreCase(nomeAventura)){
				achou = true;
			}
		}
		if(!achou){
			throw new SessaoNaoEncontradaException();
		}

		return achou;
	}



}
