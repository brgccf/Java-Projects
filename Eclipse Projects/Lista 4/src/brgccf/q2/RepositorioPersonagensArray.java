package brgccf.q2;

import brgccf.q1.PersonagemNaoEncontradoException;
import brgccf.q1.PersonagemSendoUtilizadoException;
import brgccf.q1.Personagens;
import brgccf.q3.PersonagemJaExisteException;

public class RepositorioPersonagensArray implements RepositorioPersonagens{
	private Personagens[] personagens;


	public RepositorioPersonagensArray(){
		this.personagens = new Personagens[2];
	}


	public Personagens[] getPersonagens() {

		return this.personagens;
	}


	public void setPersonagens(Personagens personagem) throws PersonagemJaExisteException {
		//se o array de personagens estiver cheio, dobra seu tamanho
		if(this.personagens[this.personagens.length-1] != null){
			Personagens[] aux = new Personagens [this.personagens.length*2];
			for (int i = 0; i < this.personagens.length; i++) {
				aux[i] = this.personagens[i];
			}
			this.personagens = aux;
		}
		boolean existe = false;
		try{
			existe = this.existePersonagem(personagem.getNome());
		}
		//caso n�o tenha encontrado, podemos adicionar no array
		catch(PersonagemNaoEncontradoException e){
			boolean achou = false;
			for (int i = 0; !achou && i < this.personagens.length; i++) {
				if(this.personagens[i] == null){
					this.personagens[i] = personagem;
					achou = true;
				}
			}
		}
		//caso tenha encontrado, ent�o temos uma exce��o
		if(existe){
			throw new PersonagemJaExisteException();
		}
		

		

	}


	public Personagens procuraPersonagem(String nome)
			throws PersonagemNaoEncontradoException,
			PersonagemSendoUtilizadoException {
		Personagens personagemProcurado = null;
		boolean achou = false;
		//varrendo o array de personagens:
		for (int i = 0; !achou && i < this.personagens.length; i++) {
			if(this.personagens[i].getNome().equalsIgnoreCase(nome)){
				achou = true;
				personagemProcurado = this.personagens[i];
			}
		}

		//lan�ando poss�veis exce��es:
		if(!achou && personagemProcurado == null){
			throw new PersonagemNaoEncontradoException();
		}
		else if(personagemProcurado.getSendoUtilizado()){
			throw new PersonagemSendoUtilizadoException();
		}
		return personagemProcurado;
	}



	public void removerPersonagem(String nome)
			throws PersonagemNaoEncontradoException,
			PersonagemSendoUtilizadoException {
		
		boolean achou = this.existePersonagem(nome);
		if(!achou){
			throw new PersonagemNaoEncontradoException();
		}
		//encontrando o personagem e removendo
		for (int i = 0; i < this.personagens.length; i++) {
			if(this.personagens[i].getNome().equalsIgnoreCase(nome)){
				this.personagens[i] = null;
				i = this.personagens.length;
			}
		}

	}



	public boolean existePersonagem(String nome)
			throws PersonagemNaoEncontradoException {
		boolean achou = false;
		
		//varrendo o array de personagens:
		for (int i = 0; !achou && i < this.personagens.length; i++) {
			if(this.personagens[i].getNome().equalsIgnoreCase(nome)){
				achou = true;
			}
		}
		if(!achou){
			throw new PersonagemNaoEncontradoException();
		}


		return achou;
	}




}
