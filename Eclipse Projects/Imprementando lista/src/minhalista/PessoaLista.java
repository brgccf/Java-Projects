package minhalista;

public class PessoaLista {
	private String nome, CPF;
	private PessoaLista proximaPessoa;
	private PessoaLista ultimaPessoa;
	
	public PessoaLista (String nome, String CPF){
		this.nome = nome;
		this.CPF = CPF;
		this.proximaPessoa = null;
		this.ultimaPessoa = null;
	}
	
	public void inserir(PessoaLista pessoa){
		if(this.nome == null && this.CPF == null){
			this.nome = pessoa.getNome();
			this.CPF = pessoa.getCPF();
		}
		else if(this.proximaPessoa == null){
			this.proximaPessoa = pessoa;
			this.ultimaPessoa = pessoa;
		}else{
			this.ultimaPessoa.proximaPessoa = pessoa;
			this.ultimaPessoa = pessoa;
		}
	}
	
	

	private String getCPF() {
		
		return this.CPF;
	}

	private String getNome() {
		return this.nome;
	}
	
	
}
