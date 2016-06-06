package minhalista;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean sera = true;
		
		System.out.println((!sera)?"Mentira":"Verdade");
		
		PessoaLista pessoa = new PessoaLista("Pedro Rossi", "5469752148");
		pessoa.inserir(pessoa);
		PessoaLista pessoa2 = new PessoaLista("Ruy brito", "25987322984");
		pessoa2.inserir(pessoa2);
		
		PessoaLista pessoa3 = new PessoaLista("Brunow", "5845897984");
		pessoa3.inserir(pessoa3);
		PessoaLista pessoa4 = new PessoaLista("teste", "meucpfdeteste");
		
		
	}

}
