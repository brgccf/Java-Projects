package brgccf.q1;

public class Personagem {
	private String nome;
	private int potions;
	private int life;
	private char p;
	private int test;

	
	public Personagem (String nome){
		this.nome = nome;
		this.potions = 3;
		this.life = 100;
		this.p = 'P';
		this.test = 1;
	}
	public int getTest(){
		return this.test;
	}
	
	public String getNome(){
		return this.nome;
	}
	public int getPotions(){
		return this.potions;
	}
	public int getLife(){
		return this.life;
	}
	public char getP(){
		return this.p;
	}
	//Define o nome do personagem
	public void setNome(String nome){
		this.nome = nome;
	}
	//metodo para armadilha espinhos
	public void spikes(){
		life -= 15;
		if (life < 0){
			life = 0;
		}
	}
	//metodo para armadilha flechas
	public void arrows(){
		life -= 25;
		if (life < 0){
			life = 0;
		}
	}
	//metodo para armadilha buraco
	public void hole(){
		life -= 40;
		if (life < 0){
			life = 0;
		}
	}
	//metodo para armadilha de chamas
	public void flames(){
		life -= 60;
		if (life < 0){
			life = 0;
		}
	}
	//metodo para beber porção
	public void usePotion(){
		
		if (this.potions <= 0){
			System.out.println("Não possui mais poções no inventário.");
		}
		else{
			life += 20;
		}
		this.potions -= 1;
		if (life > 100){
			life -= 20;
			System.out.println("Não pode usar Poção no momento. Vida Máx = 100.");
			this.potions += 1;
		}
		
	}
	//metodo executado quando o tesouro é alcançado
	public void victory(){
		this.test = 0;
	}
	

}
