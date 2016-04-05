package Exercicio1;

public class Curso {
	private String codigo;
	private String nomecurso;
	public Curso (String codigo, String nome){
		this.codigo = codigo;
		this.nomecurso = nome;
	}
	
	public String getCodigo(){
		return this.codigo;
	}
	
	public void setCodigo(String codigo){
		this.codigo = codigo;
	}
	
	public String getNomeCurso(){
		return this.nomecurso;
	}
	
	public void setNomeCurso(String nome){
		this.nomecurso = nome;
	}
}
