package brgccf.q4;

public abstract class Cards {
	private int id;
	private String name;
	private int cost;
	private String description;
	
	public Cards (int id, String name, int cost, String description){
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.description = description;
	}
	
	//metodos get e set:

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

	public double getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
