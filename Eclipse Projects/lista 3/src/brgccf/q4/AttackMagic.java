package brgccf.q4;

public class AttackMagic extends EffectMagic {
	private int attack;

	public AttackMagic(int id, String name, int cost, String description, int attack) {
		super(id, name, cost, description);
		this.attack = attack;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	//metodo para o comando de informacoes separadas por tipo, custo e nome
	public String dispallc(){
		return this.getName() + " [Custo=" + this.getCost() + "]" + " [ID=" + this.getId() + "]";
	}

}
