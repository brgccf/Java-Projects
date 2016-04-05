package exercicio;

public class Heroi {
	private String nome;
	private String superPoder;
	private String universo;
	private int poderDestruicao;
	
	public Heroi(String nome, String superPoder, String universo, int poderDestruicao){
		this.nome = nome;
		this.superPoder = superPoder;
		this.universo = universo;
		this.poderDestruicao = poderDestruicao;
	}
	
	public String getNome (){
		return this.nome;
	}
	public String getSuperPoder(){
		return this.superPoder;
	}
	public String getUniverso(){
		return this.universo;
	}
	public int getPoderDestruicao(){
		return this.poderDestruicao;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	public void setSuperPoder(String SuperPoder){
		this.superPoder = SuperPoder;
	}
	public void setUniverso(String universo){
		this.universo = universo;
	}
	public void setPoderDestruicao(int poderDestruicao){
		this.poderDestruicao = poderDestruicao;
	}
	
	
	
}
