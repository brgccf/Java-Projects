package hierarquia;

public class Triangulo extends FormaBidimensional{
	private double base;
	private double altura;
	
	public Triangulo (double base, double altura){
		this.base = base;
		this.altura = altura;
	}
	
	public double getBase(){
		return this.base;
	}
	
	public double getAltura(){
		return this.altura;
	}

	
	public double obterArea() {
		return (this.getBase()*this.getAltura())/2;
	}
	
	public String toString(){
		return "Forma Bidimensional Triangulo " + "\n¡rea: " + this.obterArea();
	}

}
