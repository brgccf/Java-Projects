package brgccf.q3;

import brgccf.q1.JogadorNaoEncontradoException;
import brgccf.q1.JogadorNaoJogaNoMesmoDiaException;
import brgccf.q1.Jogadores;
import brgccf.q1.MestreNaoEncontradoException;
import brgccf.q1.MestreNaoJogaNoMesmoDiaException;
import brgccf.q1.Mestres;
import brgccf.q2.RepositorioJogadores;


public class NegocioJogadores {

	private RepositorioJogadores jogadores;


	public NegocioJogadores(RepositorioJogadores repJogadores){
		this.jogadores = repJogadores;

	}
	//os metodos funcionam da mesma forma dos metodos dos repositorios
	public void addJogador(Jogadores jogador) throws JogadorJaExisteException{
		boolean existe = false;
		try{
			existe = this.jogadores.existeJogador(jogador.getLogin());

		}

		catch(JogadorNaoEncontradoException e){
			this.jogadores.setJogadores(jogador);
		}
		//se existe, entao temos exceçao
		if(existe){
			throw new JogadorJaExisteException();
		}
	}

	public void addMestre(Mestres mestre) throws JogadorJaExisteException{
		boolean existe = false;
		try{
			existe = this.jogadores.existeJogador(mestre.getLogin());

		}

		catch(JogadorNaoEncontradoException e){
			this.jogadores.setMestres(mestre);
		}
		//se existe, entao temos exceçao
		if(existe){
			throw new JogadorJaExisteException();
		}
	}

	public Mestres procuraMestre(String login, int diaSessao)
			throws MestreNaoEncontradoException,
			MestreNaoJogaNoMesmoDiaException {
		boolean achou = false;
		Mestres mestreProcurado = null;
		//buscando o mestre
		achou = this.jogadores.existeMestre(login);

		if(achou){
			mestreProcurado = this.jogadores.procuraMestre(login, diaSessao);
		}
		return mestreProcurado;

	}
	
	public Jogadores procuraJogador(String login, int diaSessao)
			throws JogadorNaoEncontradoException,
			JogadorNaoJogaNoMesmoDiaException {
		boolean achou = false;
		Jogadores jogadorProcurado = null;
		//buscando o jogador:
		achou = this.jogadores.existeJogador(login);
		
		if(achou){
			jogadorProcurado = this.jogadores.procuraJogador(login, diaSessao);
		}

		return jogadorProcurado;
	}
	
	public void removerMestre(String login) throws MestreNaoEncontradoException {
		boolean achou = this.jogadores.existeMestre(login);
		//se não levantar exceção, temos um mestre:
		if(achou){
			this.jogadores.removerMestre(login);
		}
	}
	
	public void removerJogador(String login) throws JogadorNaoEncontradoException {
		boolean achou = this.jogadores.existeJogador(login);
		
		if(achou){
			this.jogadores.removerJogador(login);
		}

	}




}
