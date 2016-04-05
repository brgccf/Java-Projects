package brgccf.q4;

import brgccf.q1.JogadorNaoEncontradoException;
import brgccf.q1.JogadorNaoJogaNoMesmoDiaException;
import brgccf.q1.Jogadores;
import brgccf.q1.MestreNaoEncontradoException;
import brgccf.q1.MestreNaoJogaNoMesmoDiaException;
import brgccf.q1.Mestres;
import brgccf.q1.PersonagemNaoEncontradoException;
import brgccf.q1.PersonagemSendoUtilizadoException;
import brgccf.q1.Personagens;
import brgccf.q1.Sessao;
import brgccf.q2.RepositorioJogadoresArray;
import brgccf.q2.RepositorioPersonagensArray;
import brgccf.q2.RepositorioSessoesArray;
import brgccf.q3.JogadorJaExisteException;
import brgccf.q3.NegocioJogadores;
import brgccf.q3.NegocioPersonagens;
import brgccf.q3.NegocioSessoes;
import brgccf.q3.PersonagemJaExisteException;
import brgccf.q3.SessaoAbertaException;
import brgccf.q3.SessaoJaExisteException;
import brgccf.q3.SessaoNaoEncontradaException;

public class Fachada {

	private NegocioJogadores fachadaJogadores;
	private NegocioPersonagens fachadaPersonagens;
	private NegocioSessoes fachadaSessoes;

	public Fachada (){
		this.fachadaJogadores = new NegocioJogadores(new RepositorioJogadoresArray());
		this.fachadaPersonagens = new NegocioPersonagens(new RepositorioPersonagensArray());
		this.fachadaSessoes = new NegocioSessoes(new RepositorioSessoesArray());
	}

	public void setJogadores(Jogadores jogador) throws JogadorJaExisteException{
		this.fachadaJogadores.addJogador(jogador);
	}

	public void setMestres(Mestres mestre) throws JogadorJaExisteException{
		this.fachadaJogadores.addMestre(mestre);
	}

	public void setPersonagens(Personagens personagem) throws PersonagemJaExisteException{
		this.fachadaPersonagens.addPersonagem(personagem);
	}

	public void setSessao(int dia, String nomeAventura, Mestres mestre, Jogadores[] jogadores) throws SessaoJaExisteException{
		this.fachadaSessoes.addSessao(dia, nomeAventura, mestre, jogadores);
	}

	public Mestres procuraMestre(String login, int diaSessao)
			throws MestreNaoEncontradoException,
			MestreNaoJogaNoMesmoDiaException {
		Mestres mestreProcurado = this.fachadaJogadores.procuraMestre(login, diaSessao);
		return mestreProcurado;
	}

	public Jogadores procuraJogador(String login, int diaSessao)
			throws JogadorNaoEncontradoException,
			JogadorNaoJogaNoMesmoDiaException {
		Jogadores jogadorProcurado = this.fachadaJogadores.procuraJogador(login, diaSessao);
		return jogadorProcurado;
	}

	public void removerMestre(String login) throws MestreNaoEncontradoException {
		this.fachadaJogadores.removerMestre(login);
	}

	public void removerJogador(String login) throws JogadorNaoEncontradoException{
		this.fachadaJogadores.removerJogador(login);
	}

	public Personagens procuraPersonagem(String nome)
			throws PersonagemNaoEncontradoException,
			PersonagemSendoUtilizadoException {
		Personagens personagemProcurado = this.fachadaPersonagens.procuraPersonagem(nome);
		return personagemProcurado;
	}

	public void removerPersonagem(String nome)
			throws PersonagemNaoEncontradoException,
			PersonagemSendoUtilizadoException {
		this.fachadaPersonagens.removerPersonagem(nome);
	}

	//metodo para abrir uma sessao
	public void setSessoesAbertas(String nomeAventura) throws SessaoNaoEncontradaException{
		this.fachadaSessoes.setSessoesAbertas(nomeAventura);
	}
	
	public void removerSessao(String loginMestre, String nomeAventura) throws SessaoAbertaException, SessaoNaoEncontradaException{
		this.fachadaSessoes.removerSessao(loginMestre, nomeAventura);
	}
	
	public Sessao buscarSessao(String loginMestre, String nomeAventura) throws SessaoNaoEncontradaException{
		Sessao sessao = this.fachadaSessoes.buscarSessao(loginMestre, nomeAventura);
		return sessao;
	}
	
}
