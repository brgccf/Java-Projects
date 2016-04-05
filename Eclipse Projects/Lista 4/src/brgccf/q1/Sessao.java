package brgccf.q1;

public class Sessao {

	private Mestres mestre;
	private Jogadores[] jogadores;
	private int dia;
	private String nomeAventura;

	//Cria a sessao apos definir o numero mininmo de jogadores eum mestre
	public Sessao (int dia, String nomeAventura, Mestres mestre, Jogadores[] jogadores){
		this.mestre = mestre;
		this.jogadores = jogadores;
		this.dia = dia;
		this.nomeAventura = nomeAventura;
	}

	//metodos get e set:
	
	
	
	public Mestres getMestre() {
		return mestre;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public String getNomeAventura() {
		return nomeAventura;
	}

	public void setNomeAventura(String nomeAventura) {
		this.nomeAventura = nomeAventura;
	}

	public void setMestre(Mestres mestre) {
		this.mestre = mestre;
	}

	public Jogadores[] getJogadores() {
		return jogadores;
	}
	
	//metodo para relacionar jogadores com personagens
	public void definePersonagemJogador(Jogadores jogador, Personagens personagem){
		jogador.setPersonagem(personagem);
		
	}
	//metodo para retornar o personagem de maior nivel
	public Personagens maiorNivel(Sessao sessao) throws GrupoBalanceadoException{
		Personagens personagemMaiorNivel = null;
		int[] niveis = new int [sessao.getJogadores().length];
		//armazena no array de niveis cada nivel encontrado nos personagens da sessao
		for (int i = 0; i < sessao.getJogadores().length; i++) {
			niveis[i] = sessao.getJogadores()[i].getPersonagem().getNivel();
		}
		//organizando o array em ordem crescente:
		int[] aux = new int[niveis.length];
		for (int i = 0; i < niveis.length; i++) {
			for (int j = i+1; j < niveis.length; j++) {
				if(niveis[j] > niveis[i]){
					aux[i] = niveis[j];
					niveis[j] = niveis[i];
					niveis[i] = aux[i];
				}
			}
		}
		//se a primeira posiçao for diferente da segunda, entao temos um personagem de maior nivel. se nao, entao
		//é balanceado
		if(niveis[0] != niveis[1]){
			//varre o array de jogadores da sessao ate encontrar aquele de maior nivel
			for (int i = 0; i < sessao.getJogadores().length; i++) {
				if(sessao.getJogadores()[i].getPersonagem().getNivel() == niveis[0]){
					personagemMaiorNivel = sessao.getJogadores()[i].getPersonagem();
				}
			}
		}
		//caso nao haja personagem de maior nivel, lança a exceção:
		else{
			throw new GrupoBalanceadoException();
		}
			
		
		return personagemMaiorNivel;
	}
	
	//metodo para verificar se a sessão está balanceada
	public boolean verificaBalanceamentoSessao(Sessao sessao){
		boolean retorno = true;
		for (int i = 0; i < sessao.getJogadores().length; i++) {
			for (int j = i+1; j < sessao.getJogadores().length; j++) {
				//se tivermos pelo menos alguma classe presente em mais de um personagem, a sessao não está balanceada
				if(sessao.getJogadores()[i].getClasse() == sessao.getJogadores()[j].getClasse()){
					retorno = false;
				}
			}
		}
			
		return retorno;
	}
	
	
	//metodo para procurar um personagem da sessao: - utilizado para modificar algum personagem do programa
	public Personagens procuraPersonagemSessao(String nome, Sessao sessao) throws PersonagemNaoEncontradoException{
		Personagens personagemProcurado = null;
		boolean achou = false;
		//varrendo o array de personagens da sessao
		for (int i = 0; !achou && i < sessao.getJogadores().length; i++) {
			//se a entrada for igual ao nome de algum personagem, entao encontramos o personagem que queremos modificar
			if(nome.equalsIgnoreCase(sessao.getJogadores()[i].getPersonagem().getNome())){
				achou = true;
				personagemProcurado = sessao.getJogadores()[i].getPersonagem();
			}
		}
		//se nao achou, pode ser que a entrada seja o personagem do mestre da sessao:
		
		if(!achou){
			Personagens[] personagensMestreSessao = sessao.getMestre().getPersonagens();
			for (int i = 0; i < personagensMestreSessao.length; i++) {
				//se um dos personagens do mestre for a entrada, entao encontramos o personagem que deve ser modificado
				if(personagensMestreSessao[i].getNome().equalsIgnoreCase(nome)){
					personagemProcurado = personagensMestreSessao[i];
					achou = true;
				}
			}
		}
		//se mesmo assim não achou, então lançamos uma exceção
		if(!achou){
			throw new PersonagemNaoEncontradoException();
		}
		
		return personagemProcurado;
	}
	
	//metodo para encerrar uma sessao
	
	public void encerraSessao(Sessao sessao){
		//verificando os personagens do mestre:
		Personagens[] personagensMestreSessao = sessao.getMestre().getPersonagens();
		//desativando o uso desses personagens:
		for (int i = 0; i < personagensMestreSessao.length; i++) {
			personagensMestreSessao[i].setSendoUtilizadoFalse();
		}
		//verificando os personagens de jogadores:
		for (int i = 0; i < sessao.getJogadores().length; i++) {
			//ampliando em 1 o nivel de cada personagem
			sessao.getJogadores()[i].getPersonagem().setNivel();
			//desativando o uso de cada personagem
			sessao.getJogadores()[i].getPersonagem().setSendoUtilizadoFalse();
		}
		
	}
	




}
