package brgccf.q2;



public class Pessoa {

	private String name;
	private Pessoa son;
	
	private double partialPopularity;
	
	private Pessoa dad;

	public Pessoa (String name, Pessoa son, Pessoa dad, double partialPopularity){
		this.name = name;
		this.son = son;
		this.dad = dad;
		this.partialPopularity = partialPopularity;

	}



	//metodos get e set:

	public String getName(){
		return this.name;
	}

	public Pessoa getSon(){
		return this.son;
	}

	public double getPartialPopularity() {
		return partialPopularity;
	}

	public void setPartialPopularity(double partialPopularity) {
		this.partialPopularity = partialPopularity;
	}

	public Pessoa getDad() {
		return dad;
	}

	public void setDad(Pessoa dad) {
		this.dad = dad;
	}

	public void setName(String name) {
		this.name = name;
	}

	//metodo set para definir o filho de Pessoa
	public void setSon(Pessoa son){
		this.son = son;
	}
	





}
