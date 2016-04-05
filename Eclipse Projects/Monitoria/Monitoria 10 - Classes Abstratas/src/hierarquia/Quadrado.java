package hierarquia;

public class Quadrado extends FormaBidimensional {
	private double lado;
	
	public Quadrado (double lado){
		this.lado = lado;
	}
	
	public double getLado(){
		return this.lado;
	}
	
	
	public double obterArea() {
		
		return this.getLado()*this.getLado();
	}
	
	public String toString(){
		return "Forma Bidimensional Quadrado " + "\n¡rea: " + this.obterArea();
	}
	

}
