package brgccf.q4;

public class Equipment extends Cards {
	private int attack;
	private int life;

	public Equipment(int id, String name, int cost, String description, int attack, int life) {
		super(id, name, cost, description);
		this.attack = attack;
		this.life = life;

	}
	//metodos get e set:
	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	

	//metodo para o comando de informacoes separadas por tipo, custo e nome
	public String dispallc(){
		return this.getName() + " [Custo=" + this.getCost() + "]" + " [ID=" + this.getId() + "]";
	}



}
