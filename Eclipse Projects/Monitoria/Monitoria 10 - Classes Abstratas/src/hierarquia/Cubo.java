package hierarquia;

public class Cubo extends FormaTridimensional {
	
	private double aresta;
	private double altura;
	private double areaBase;
	
	public Cubo (double aresta, double altura){
		this.aresta = aresta;
		this.altura = altura;
		this.areaBase = this.obterArea();
	}
	
	public double getAresta(){
		return this.aresta;
	}
	
	public double getAreaBase(){
		return this.areaBase;
	}
	
	public double getAltura(){
		return this.altura;
	}


	public double obterVolume() {
		
		return this.obterArea()*this.altura;
	}

	
	public double obterArea() {
		
		return this.getAresta()*this.getAresta();
	}
	
	public String toString(){
		return "Forma Tridimensional Cubo " + "\n¡rea: " + this.obterArea() + "\nVolume: " + this.obterVolume();
	}
	

}
