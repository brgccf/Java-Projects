package hierarquia;

public class Esfera extends FormaTridimensional{
	private double raio;
	private static final double PI = 3.14;
	
	public Esfera (double raio){
		this.raio = raio;
	}

	public double getRaio(){
		return this.raio;
	}
	
	
	public double obterVolume() {
	
		return (4*PI*this.getRaio()*this.getRaio()*this.getRaio())/3;
	}

	
	public double obterArea() {
		
		return 4*PI*this.getRaio()*this.getRaio();
	}
	
	public String toString(){
		return "Forma Tridimensional Esfera " + "\n¡rea: " + this.obterArea() + "\nVolume: " + this.obterVolume();
	}
	
	

}
