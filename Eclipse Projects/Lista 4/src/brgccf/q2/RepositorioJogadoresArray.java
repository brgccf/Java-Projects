package brgccf.q2;

import brgccf.q1.JogadorNaoEncontradoException;
import brgccf.q1.JogadorNaoJogaNoMesmoDiaException;
import brgccf.q1.Jogadores;
import brgccf.q1.MestreNaoEncontradoException;
import brgccf.q1.MestreNaoJogaNoMesmoDiaException;
import brgccf.q1.Mestres;
import brgccf.q3.JogadorJaExisteException;

public class RepositorioJogadoresArray implements RepositorioJogadores {

	private Jogadores[] jogadores;
	private Mestres[] mestres;

	public RepositorioJogadoresArray (){
		this.jogadores = new Jogadores[2];
		this.mestres = new Mestres[2];
	}
	//adiciona jogador
	public void setJogadores(Jogadores jogador) throws JogadorJaExisteException{
		//se o array de jogadores estiver cheio, dobra o tamanho do array.
		if(this.jogadores[this.jogadores.length-1] != null){
			Jogadores[] aux = new Jogadores [this.jogadores.length*2];
			for (int i = 0; i < this.jogadores.length; i++) {
				aux[i] = this.jogadores[i];
			}
			this.jogadores = aux;
		}
		boolean existe = false;
		//verificando se o jogador ja existe:
		try{
			existe = this.existeJogador(jogador.getLogin());
		}
		//se não foi encontrado, então podemos cadastrar normalmente:
		catch(JogadorNaoEncontradoException e){
			boolean achou = false;
			for (int i = 0; !achou && i < this.jogadores.length; i++) {
				if(this.jogadores[i] == null){
					this.jogadores[i] = jogador;
					achou = true;
				}
			}
		}
		//caso tenha encontrado:
		if(existe){
			throw new JogadorJaExisteException();
		}

	}

	//adiciona mestre
	public void setMestres(Mestres mestre) throws JogadorJaExisteException{
		//se o array de mestres estiver cheio, dobra seu tamanho
		if(this.mestres[this.mestres.length-1] != null){
			Mestres[] aux = new Mestres [this.mestres.length*2];
			for (int i = 0; i < this.mestres.length; i++) {
				aux[i] = this.mestres[i];
			}
			this.mestres = aux;
		}
		boolean existe = false;
		//verificando se o jogador já existe:
		try{
			existe = this.existeJogador(mestre.getLogin());
		}
		//se não encontrou, então podemos cadastra-lo.
		catch(JogadorNaoEncontradoException e){
			boolean achou = false;
			for (int i = 0; !achou && i < this.mestres.length; i++) {
				if(this.mestres[i] == null){
					this.mestres[i] = mestre;
					achou = true;
				}
			}
		}
		//se encontrou, entao temos uma exceção
		if(existe){
			throw new JogadorJaExisteException();
		}



	}

	//buscar mestre
	public Mestres procuraMestre(String login, int diaSessao)
			throws MestreNaoEncontradoException,
			MestreNaoJogaNoMesmoDiaException {
		boolean achou = false;
		Mestres mestreProcurado = null;

		//varre o array de mestres e se encontrar, armazena na variavel mestreProcurado

		for (int i = 0; !achou && i < mestres.length; i++) {
			if(this.mestres[i].getLogin().equalsIgnoreCase(login)){
				achou = true;
				mestreProcurado = this.mestres[i];
			}
		}
		//lançando exceções em caso de mestre não for encontrado ou não poder jogar no mesmo dia da sessao
		if(!achou && mestreProcurado == null){
			throw new MestreNaoEncontradoException();
		}
		else if(mestreProcurado.getDias()[diaSessao] == false){
			throw new MestreNaoJogaNoMesmoDiaException();
		}
		return mestreProcurado;

	}

	//buscar jogador (não mestre)
	public Jogadores procuraJogador(String login, int diaSessao)
			throws JogadorNaoEncontradoException,
			JogadorNaoJogaNoMesmoDiaException {
		boolean achou = false;
		Jogadores jogadorProcurado = null;
		//varrendo o array de jogadores
		for (int i = 0; !achou && i < jogadores.length; i++) {
			if(this.jogadores[i].getLogin().equalsIgnoreCase(login)){
				achou = true;
				jogadorProcurado = this.jogadores[i];
			}
		}

		//lançando exceções possíveis:
		if(!achou && jogadorProcurado == null){
			throw new JogadorNaoEncontradoException();
		}
		else if(jogadorProcurado.getDias()[diaSessao] == false){
			throw new JogadorNaoJogaNoMesmoDiaException(jogadorProcurado);
		}


		return jogadorProcurado;
	}




	public Jogadores[] getJogadores() {

		return this.jogadores;
	}

	public Mestres[] getMestres() {

		return this.mestres;
	}

	public void removerMestre(String login) throws MestreNaoEncontradoException {
		boolean achou = this.existeMestre(login);
		if(!achou){
			throw new MestreNaoEncontradoException();
		}

		//encontrando mestre no repositorio e removendo

		for (int i = 0; i < this.mestres.length; i++) {
			if(this.mestres[i].getLogin().equalsIgnoreCase(login)){
				this.mestres[i] = null;
				i = this.mestres.length;
			}
		}


	}

	public void removerJogador(String login) throws JogadorNaoEncontradoException {
		boolean achou = this.existeJogador(login);
		if(!achou){
			throw new JogadorNaoEncontradoException();
		}

		//encontrando jogador no repositorio e removendo

		for (int i = 0; i < this.jogadores.length; i++) {
			if(this.jogadores[i].getLogin().equalsIgnoreCase(login)){
				this.jogadores[i] = null;
				i = this.jogadores.length;
			}
		}

	}

	public boolean existeMestre(String login) throws MestreNaoEncontradoException{
		boolean achou = false;

		//varre o array de mestres e se encontrar, sinaliza com achou=true;
		for (int i = 0; !achou && i < mestres.length; i++) {
			if(this.mestres[i].getLogin().equalsIgnoreCase(login)){
				achou = true;
			}
		}
		//se nao achou, lança a exceção
		if(!achou){
			throw new MestreNaoEncontradoException();
		}

		return achou;
	}

	public boolean existeJogador(String login) throws JogadorNaoEncontradoException {
		boolean achou = false;

		//varrendo o array de jogadores
		for (int i = 0; !achou && i < jogadores.length; i++) {
			if(this.jogadores[i].getLogin().equalsIgnoreCase(login)){
				achou = true;

			}
		}
		//se não achou, lança a exceção
		if(!achou){
			throw new JogadorNaoEncontradoException();
		}

		return achou;
	}





}
