package brgccf.q4;

public class EffectMagic extends Cards {

	public EffectMagic(int id, String name, int cost, String description) {
		super(id, name, cost, description);

	}

	//metodo para o comando de informacoes separadas por tipo, custo e nome
	public String dispallc(){
		return this.getName() + " [Custo=" + this.getCost() + "]" + " [ID=" + this.getId() + "]";
	}

}
