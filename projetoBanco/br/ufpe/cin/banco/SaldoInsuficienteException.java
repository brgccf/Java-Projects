package br.ufpe.cin.banco;

public class SaldoInsuficienteException extends Exception {

	public SaldoInsuficienteException (String numero, double saldo) {
		super("O saldo atual da conta "+numero+" Ž "+saldo);
	}
}
