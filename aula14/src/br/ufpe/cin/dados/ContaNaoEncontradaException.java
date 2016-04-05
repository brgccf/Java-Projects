package br.ufpe.cin.dados;

@SuppressWarnings("serial")
public class ContaNaoEncontradaException extends Exception {
	
	public ContaNaoEncontradaException(){
		super("Conta nao encontrada!");
	}
	
}
