package brgccf.q4;

public class Deck {
	private Cards[] cards;

	public Deck (){
		this.cards = new Cards[20];
	}

	public Cards[] getCards(){
		return this.cards;
	}

	//metodo set para criar cartas e suas respectivas copias
	public void setCards(Cards card, int id){
		//verifica se o array de cartas esta cheio. se sim, dobra o tamanho deste.
		if(this.cards[this.cards.length - 1] != null){
			Cards[] aux = new Cards[this.cards.length*2];
			for (int i = 0; i < this.cards.length; i++){
				aux[i] = this.cards[i];
			}
			this.cards = aux;
		}

		this.cards[id-1] = card;
		this.cards[id-1+10] = card;
		//id - 1 pois o usuario digitara a primeira posicao do array como se fosse 1.
		//cria a copia da carta 10 posicoes a frente.
	}

	//comandos da questao:
	//comandos para adicionar cartas
	public void addCardEquipment(int id, String name, int cost, String description, int attack, int life){
		Equipment card = new Equipment (id, name, cost, description, attack, life);
		this.setCards(card, id);

	}

	public void addCardCommonCreature(int id, String name, int cost, String description, int attack, int life){
		CommonCreatures card = new CommonCreatures(id, name, cost, description, attack, life);
		this.setCards(card, id);
	}

	public void addCardSpecialCreature(int id, String name, int cost, String description, int attack, int life, String hability){
		SpecialCreatures card = new SpecialCreatures(id, name, cost, description, attack, life, hability);
		this.setCards(card, id);
	}

	public void addCardAttackMagic(int id, String name, int cost, String description, int attack){
		AttackMagic card = new AttackMagic(id, name, cost, description, attack);
		this.setCards(card, id);
	}

	public void addCardEffectMagic(int id, String name, int cost, String description){
		EffectMagic card = new EffectMagic(id, name, cost, description);
		this.setCards(card, id);
	}

	//comando para remover carta:

	public void removeCard(int id){
		//varre o array de cartas. se encontrar alguma com o id de entrada, remove a carta e sua respectiva cópia.
		boolean erased = false;
		for(int i = 0; !erased && i < this.cards.length; i++){
			if(this.cards[i].getId() == id){
				this.cards[i] = null;
				this.cards[i+10] = null;
				erased = true;
			}
		}

	}

	//comando mostrar informações da carta

	public String showInformation(int id){
		boolean achou = false;
		String information = "Nenhuma carta encontrada para a ID informada.";
		//varre o array para encontrar a carta pelo id de entrada;
		for(int i = 0; i < this.cards.length; i++){
			if(this.cards[i] != null){
				if(this.cards[i].getId() == id){
					achou = true;

				}
			}
		}
		if(achou){
			if(this.cards[id-1] instanceof Equipment){
				Equipment card = (Equipment) this.cards[id-1];
				information = "ID: " + card.getId() + "\n\nNome: " + card.getName() + "\n\nCusto: " + card.getCost() + "\n\nDescrição: " + card.getDescription() 
						+ "\n\nAtaque: " + card.getAttack() + "\n\nVida: " + card.getLife();
			}
			else if (this.cards[id-1] instanceof CommonCreatures){
				CommonCreatures card = (CommonCreatures) this.cards[id-1];
				information = "ID: " + card.getId() + "\n\nNome: " + card.getName() + "\n\nCusto: " + card.getCost() + "Descrição: " + card.getDescription()
						+ "\n\nAtaque: " + card.getAttack() + "\n\nVida: " + card.getLife();
			}
			else if (this.cards[id-1] instanceof SpecialCreatures){
				SpecialCreatures card = (SpecialCreatures) this.cards[id-1];
				information = "ID: " + card.getId() + "\n\nNome: " + card.getName() + "\n\nCusto: " + card.getCost() + "\n\nDescrição: " + card.getDescription()
						+ "\n\nAtaque: " + card.getAttack() + "\n\nVida: " + card.getLife() + "\n\nHabilidade: " + card.getHability();
			}
			else if (this.cards[id-1] instanceof AttackMagic){
				AttackMagic card = (AttackMagic) this.cards[id-1];
				information = "ID: " + card.getId() + "\n\nNome: " + card.getName() + "\n\nCusto: " + card.getCost() + "\n\nDescrição: " + card.getDescription()
						+ "\n\nAtaque: " + card.getAttack();
			}
			else if (this.cards[id-1] instanceof EffectMagic){
				EffectMagic card = (EffectMagic) this.cards[id-1];
				information = "ID: " + card.getId() + "\n\nNome: " + card.getName() + "\n\nCusto: " + card.getCost() + "\n\nDescrição: " + card.getDescription();
			}
			else{
				information = "Problema no metodo de mostrar informacoes";
			}
		}

		return information;

	}



	//metodo para listar todas as cartas, separadas por tipo, ordenadas por custo e em seguida por nome (dispallc)
	public String listCards(){
		int count = 0;
		String list = "Coleção: ";
		
		//varre o array para verificar se ha cartas do tipo Equipamento
		//Obs.: dispallc é um metodo toString de cada carta
		for(int i = 0; i < this.cards.length; i++){
			if(this.cards[i] instanceof Equipment){

				
				Equipment card = (Equipment) this.cards[i];
				if (count == 0){
					list += "\nEquipamentos: ";
					count += 1;
				}
				else{
					list += "\n" + card.dispallc();
					
				}
			}
		}
		
		count = 0;
		//varre o array para verificar se ha cartas do tipo Criaturas:
		for(int i = 0; i < this.cards.length; i++){
			
			if(this.cards[i] instanceof CommonCreatures){

				
				CommonCreatures card1 = (CommonCreatures) this.cards[i];
				if (count == 0){
					list += "\nCriaturas: ";
					count += 1;
				}
				else{
					list += "\n" + card1.dispallc();
					
				}
			}
			
		}
		
		//Criaturas Especiais
		for(int i = 0; i < this.cards.length; i++){
			if (this.cards[i] instanceof SpecialCreatures){
		
				SpecialCreatures card2 = (SpecialCreatures) this.cards[i];

				if(count == 0){
					list += "\nCriaturas: ";
					count += 1;
				}
				else{
					
					
					list += "\n" + card2.dispallc();
				}
			}
		}
		
		
		count = 0;
		//varre o array para verificar se ha cartas do tipo Magica:
		for(int i = 0; i < this.cards.length; i++){
			
			if(this.cards[i] instanceof AttackMagic){


				AttackMagic card1 = (AttackMagic) this.cards[i];
				if (count == 0){
					list += "\nMagias: ";
					count += 1;
				}
				else{
					list += "\n" + card1.dispallc();
					
				}
			}
			
		}
		
		//Magicas de Efeito
		for (int i = 0; i < this.cards.length; i++) {
			if (this.cards[i] instanceof EffectMagic){


				EffectMagic card2 = (EffectMagic) this.cards[i];

				if(count == 0){
					list += "\nMagias: ";
					count += 1;
				}
				else{
					list += "\n" + card2.dispallc();
					
				}
			}
		}

		return list;
	}



}
