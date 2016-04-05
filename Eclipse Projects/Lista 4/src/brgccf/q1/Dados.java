package brgccf.q1;

public class Dados {
	private Jogadores[] jogadores;
	private Mestres[] mestres;
	private Personagens[] personagens;

	private Sessao[] sessoes;

	public Dados (){
		this.jogadores = new Jogadores[1];
		this.mestres = new Mestres[1];
		this.personagens = new Personagens[1];
		this.sessoes = new Sessao[1];
	}


	public Jogadores[] getJogadores() {
		return jogadores;
	}


	public void setJogadores(Jogadores jogador) {
		//se o array de jogadores estiver cheio, dobra o tamanho do array.
		if(this.jogadores[this.jogadores.length-1] != null){
			Jogadores[] aux = new Jogadores [this.jogadores.length*2];
			for (int i = 0; i < this.jogadores.length; i++) {
				aux[i] = this.jogadores[i];
			}
			this.jogadores = aux;
		}

		//cadastrando o jogador, caso o array tenha espaço:

		boolean achou = false;
		for (int i = 0; !achou && i < this.jogadores.length; i++) {
			if(this.jogadores[i] == null){
				this.jogadores[i] = jogador;
				achou = true;
			}
		}


	}


	public Mestres[] getMestres() {
		return mestres;
	}


	public void setMestres(Mestres mestre) {
		//se o array de mestres estiver cheio, dobra seu tamanho
		if(this.mestres[this.mestres.length-1] != null){
			Mestres[] aux = new Mestres [this.mestres.length*2];
			for (int i = 0; i < this.mestres.length; i++) {
				aux[i] = this.mestres[i];
			}
			this.mestres = aux;
		}
		//cadastrando o mestre, caso tenha espaço no array

		boolean achou = false;
		for (int i = 0; !achou && i < this.mestres.length; i++) {
			if(this.mestres[i] == null){
				this.mestres[i] = mestre;
				achou = true;
			}
		}

	}


	public Personagens[] getPersonagens() {
		return personagens;
	}


	public void setPersonagens(Personagens personagem) {
		//se o array de personagens estiver cheio, dobra seu tamanho
		if(this.personagens[this.personagens.length-1] != null){
			Personagens[] aux = new Personagens [this.personagens.length*2];
			for (int i = 0; i < this.personagens.length; i++) {
				aux[i] = this.personagens[i];
			}
			this.personagens = aux;
		}
		//cadastrano o personagem no array, caso tenha espaço.

		boolean achou = false;
		for (int i = 0; !achou && i < this.personagens.length; i++) {
			if(this.personagens[i] == null){
				this.personagens[i] = personagem;
				achou = true;
			}
		}

	}

	public Mestres procuraMestre(String login, int diaSessao) throws MestreNaoEncontradoException, MestreNaoJogaNoMesmoDiaException{
		boolean achou = false;
		Mestres mestreProcurado = null;
		//varre o array de mestres e se encontrar, armazena na variavel
		
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

	public Jogadores procuraJogador(String login, int diaSessao) throws JogadorNaoEncontradoException, JogadorNaoJogaNoMesmoDiaException{
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

	public Personagens procuraPersonagem(String nome) throws PersonagemNaoEncontradoException, PersonagemSendoUtilizadoException{
		Personagens personagemProcurado = null;
		boolean achou = false;
		//varrendo o array de personagens:
		for (int i = 0; !achou && i < this.personagens.length; i++) {
			if(this.personagens[i].getNome().equalsIgnoreCase(nome)){
				achou = true;
				personagemProcurado = this.personagens[i];
			}
		}

		//lançando possíveis exceções:
		if(!achou && personagemProcurado == null){
			throw new PersonagemNaoEncontradoException();
		}
		else if(personagemProcurado.getSendoUtilizado()){
			throw new PersonagemSendoUtilizadoException();
		}
		return personagemProcurado;
	}


	public Sessao[] getSessoes() {
		return sessoes;
	}


	public void setSessao(Sessao sessao) {
		//se o array de sessoes estiver cheio, duplicamos seu tamanho:
		if(this.sessoes[this.sessoes.length-1] != null){
			Sessao[] aux = new Sessao [this.sessoes.length*2];
			for (int i = 0; i < sessoes.length; i++) {
				aux[i] = this.sessoes[i];
			}
			this.sessoes = aux;
		}
		//cadastrando a sessao no array, caso tenha espaço:

		boolean achou = false;
		for (int i = 0; !achou && i < this.sessoes.length; i++) {
			if(this.sessoes[i] == null){
				achou = true;
				this.sessoes[i] = sessao;
			}
		}

	}
	//metodo para criar sessao balanceada
	public int criaSessaoBalanceada(int diaSessao, String aventura) throws MestreNaoJogaNoMesmoDiaException{
		int idSessao = 0;
		Dados dados = new Dados();
		Mestres mestreSessaoBalanceada = null;

		//definindo mestre de acordo com o dia da sessao:
		boolean achou = false;
		for (int i = 0; !achou && i < this.mestres.length; i++) {
			//se o mestre puder jogar no dia da sessao, entao temos um mestre para esta sessao.
			if(this.mestres[i].getDias()[diaSessao]){
				mestreSessaoBalanceada = this.mestres[i];
				achou = true;
			}
		}
		//se nenhum mestre foi encontrado, entao devemos levantar uma exceção
		if(!achou){
			throw new MestreNaoJogaNoMesmoDiaException();
		}
		else{
			achou = false;
		}
		Jogadores[] jogadoresSessaoBalanceada = new Jogadores[5];
		//definindo jogadores de acordo com o dia da sessao
		for (int i = 0; i < jogadoresSessaoBalanceada.length; i++) {
			for (int j = 0; !achou && j < this.jogadores.length; j++) {

				if(jogadoresSessaoBalanceada[i] == null){
					if(this.jogadores[j].getDias()[diaSessao]){
						jogadoresSessaoBalanceada[i] = this.jogadores[j];
						achou = true;
					}
				}

			}
		}


		Sessao sessaoBalanceada = new Sessao(diaSessao, aventura, mestreSessaoBalanceada, jogadoresSessaoBalanceada);
		dados.setSessao(sessaoBalanceada);
		idSessao = this.sessoes.length;
		return idSessao;
	}












}
