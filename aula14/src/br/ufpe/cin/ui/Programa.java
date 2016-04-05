package br.ufpe.cin.ui;

import br.ufpe.cin.banco.Banco;
import br.ufpe.cin.banco.Conta;
import br.ufpe.cin.banco.ContaEspecial;
import br.ufpe.cin.banco.ContaImposto;
import br.ufpe.cin.banco.Poupanca;
import br.ufpe.cin.banco.SaldoInsuficienteException;
import br.ufpe.cin.dados.ContaNaoEncontradaException;
import br.ufpe.cin.dados.RepositorioContas;
import br.ufpe.cin.dados.RepositorioContasArray;

/**
 *  Altere a classe Programa para fazer os testes
 *
 */
public class Programa {

	public static void main(String[] args) {
		RepositorioContas repositorio = new RepositorioContasArray(100);
		Banco banco = new Banco(repositorio);
		try{
		banco.cadastrar(new Conta("123"));
		banco.cadastrar(new ContaEspecial("456"));
		banco.cadastrar(new Poupanca("789"));
		banco.cadastrar(new ContaImposto("012"));

		banco.creditar("123", 100);
		banco.creditar("456", 200);
		banco.creditar("789", 300);
		banco.creditar("012", 400);

		try{
			
		
		banco.debitar("123", 300);
		banco.debitar("456", 20);
		banco.debitar("789", 30);
		banco.debitar("012", 40);		
		}
		catch (SaldoInsuficienteException e){
			System.out.println(e.getMessage());
			System.out.println("Conta: " + e.getNumero());
			System.out.println("Saldo atual: " + e.getSaldo());
		}
		System.out.println("123: " + banco.getSaldo("123"));
		System.out.println("456: " + banco.getSaldo("456"));
		System.out.println("789: " + banco.getSaldo("789"));
		System.out.println("012: " + banco.getSaldo("012"));
		
		banco.renderBonus("456");
		banco.renderJuros("789");
		
		System.out.println("\nDepois de render juros e bonus...");
		System.out.println("123: " + banco.getSaldo("123"));
		System.out.println("456: " + banco.getSaldo("456"));
		System.out.println("789: " + banco.getSaldo("789"));
		System.out.println("012: " + banco.getSaldo("012"));

		try {
			banco.transferir("123", "789", 10);
		} catch (SaldoInsuficienteException e) {
		
			e.printStackTrace();
		}
		
		System.out.println("\nDepois de transferir...");
		System.out.println("123: " + banco.getSaldo("123"));
		System.out.println("456: " + banco.getSaldo("456"));
		System.out.println("789: " + banco.getSaldo("789"));
		System.out.println("012: " + banco.getSaldo("012"));
		
		System.out.println("\nDuvido que a proxima linha execute");
		banco.renderBonus("123");
		}
		catch(ContaNaoEncontradaException e){
			System.out.println(e.getMessage());
			main(args);
		}
		catch(RuntimeException e){
			System.out.println("Programa direito seu besta");
		}
		
		
		
		System.out.println("Fim de programa!");
	}
	
	

}
