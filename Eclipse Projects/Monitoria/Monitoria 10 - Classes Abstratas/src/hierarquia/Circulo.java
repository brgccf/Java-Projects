package hierarquia;

public class Circulo extends FormaBidimensional {
	private double raio;
	
	private static final double PI = 3.14;
	
	public Circulo (int raio){
		this.raio = raio;
	}
	
	public double getRaio(){
		return this.raio;
	}


	public double obterArea() {
		
		return this.getRaio()*this.getRaio()*PI;
	}
	
	public String toString(){
		return "Forma Bidimensional: CÌrculo " + "\n¡rea: " + this.obterArea();
	}
	
	

}
