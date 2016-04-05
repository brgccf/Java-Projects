package brgccf.q2;

public class Familia{

	private Pessoa[] people;
	private int index;

	public Familia(){
		this.people = new Pessoa[100];
		//inicializando com a pessoa inicial "Primeiro" explicitada na questão.
		this.index = 0;
		this.people[0] = new Pessoa ("Primeiro", null, null, 1000000000);
	}
	//metodos get

	public Pessoa[] getPeople(){
		return this.people;
	}

	//metodo para registrar pessoas:
	public void registerPeople(Pessoa person){
		//se o array de pessoas encher, dobramos o tamanho deste.
		if(this.people[this.people.length-1] != null){
			Pessoa[] aux = new Pessoa[this.people.length*2];
			for(int i = 0; i < this.people.length; i++){
				aux[i] = this.people[i];
			}
			this.people = aux;
		}

		//define o pai
		person.setDad(this.people[index]);
		//define o filho
		this.people[index].setSon(person);
		//cadastra a pessoa na proxima posicao do array
		this.people[index+1] = person;
		//altera o indice
		index += 1;


		//diminui em 1 a popularidade de Primeiro
		double subtract = this.people[0].getPartialPopularity() - 1;

		this.people[0].setPartialPopularity(subtract);
	}

	//metodo para encontrar pessoas
	protected Pessoa searchPerson(String name){
		Pessoa person = null;

		for(int i = 0; i < this.people.length; i++){
			//varre o array ate encontrar um nome comum ao que foi digitado
			if(this.people[i] != null){
				if(this.people[i].getName().equalsIgnoreCase(name)){
					person = this.people[i];
					i = this.people.length;
				}
			}
		}
		
		return person;
	}


	//metodo para retornar popularidade total
	public double totalPopularity(String name){
		//procura a pessoa pelo nome 
		Pessoa person = this.searchPerson(name);
		int index = 0;
		double plus = 0;
		//varre o array do programa para encontrar o indice do nome digitado no array
		for(int i = 0; i < this.people.length; i++){
			if(this.people[i].getName().equalsIgnoreCase(name)){
				index = i;
				i = this.people.length;
			}
		}
		//varre o array a partir do indice encontrado para somar todas as popularidades parciais
		for (int j = index+1; j < this.people.length; j++){
			if(this.people[j] == null){
				j = this.people.length;
			}
			else{
				plus += this.people[j].getPartialPopularity();
			}
		}
		//soma tudo
		double result = plus + person.getPartialPopularity();

		//retorna o resultado
		return result;

	}






}
