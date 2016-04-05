package hierarquia;

public class Tetraedro extends FormaTridimensional{
	private double arestaBase;
	private double alturaBase;
	private double altura;
	private double areaBase;
	
	public Tetraedro (double arestaBase, double alturaBase, double altura){
		this.arestaBase = arestaBase;
		this.alturaBase = alturaBase;
		
		this.altura = altura;
		this.areaBase = obterArea();
	}

	
	public double getArestaBase(){
		return this.arestaBase;
	}
	
	public double getAlturaBase(){
		return this.alturaBase;
	}
	
	public double getAltura(){
		return this.altura;
	}
	
	public double getAreaBase(){
		return this.areaBase;
	}
	
	public double obterVolume() {
		
		return this.areaBase*this.getAltura();
	}

	
	public double obterArea() {
		
		return (this.getArestaBase()*this.getAlturaBase())/2;
	}
	
	
	//retornar informações sem precisar repetir codigo no main
	public String toString(){
		return "Forma Tridimensional Tetraedro" + "\nÁrea: " + this.obterArea() + "\nVolume: " + this.obterVolume();
	}
	
	

}
