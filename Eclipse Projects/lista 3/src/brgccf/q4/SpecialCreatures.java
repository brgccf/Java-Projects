package brgccf.q4;

public class SpecialCreatures extends CommonCreatures {
	private String hability;

	public SpecialCreatures(int id, String name, int cost,
			String description, int attack, int life, String hability) {
		super(id, name, cost, description, attack, life);
		this.hability = hability;

	}

	public String getHability() {
		return hability;
	}

	public void setHability(String hability) {
		this.hability = hability;
	}

	//metodo para o comando de informacoes separadas por tipo, custo e nome
	public String dispallc(){
		return this.getName() + " [Custo=" + this.getCost() + "]" + " [ID=" + this.getId() + "]";
	}



}
