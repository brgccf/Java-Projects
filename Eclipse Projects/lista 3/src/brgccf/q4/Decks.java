package brgccf.q4;

public class Decks {
	private int id;
	private String name;


	private Decks[] decks;
	private int index;
	public Decks (int id, String name){
		this.id = id;
		this.name = name;

		this.decks = new Decks[9];
		this.index = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Decks[] getDecks(){
		return this.decks;
	}

	//metodos set para criar decks:
	public void setDecks(int id, String name){
		//verifica caso o array de decks esteja cheio. se sim, dobra o tamanho do array
		if(this.index >= 9){
			Decks[] aux = new Decks[this.decks.length*2];
			for(int i = 0; i < this.decks.length; i++){
				aux[i] = this.decks[i];
			}
			this.decks = aux;
		}


		Decks deck = new Decks(id, name);
		this.decks[index] = deck;
		this.index += 1;
	}


	//comandos da questao:


	

}
