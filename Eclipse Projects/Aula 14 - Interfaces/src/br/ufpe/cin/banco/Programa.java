package br.ufpe.cin.banco;

/**
 *  Altere a classe a classe Programa para testar todas 
 *  as classes do projeto
 *
 */
public class Programa {

	public static void main(String[] args) {
		Banco banco = new Banco();

		banco.cadastrar(new Conta("123"));
		banco.cadastrar(new ContaEspecial("456"));
		banco.cadastrar(new Poupanca("789"));
		banco.cadastrar(new ContaImposto("012"));

		banco.creditar("123", 100);
		banco.creditar("456", 200);
		banco.creditar("789", 300);
		banco.creditar("012", 400);

		banco.debitar("123", 10);
		banco.debitar("456", 20);
		banco.debitar("789", 30);
		banco.debitar("012", 40);		

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

		banco.transferir("123", "789", 10);
		
		System.out.println("\nDepois de transferir...");
		System.out.println("123: " + banco.getSaldo("123"));
		System.out.println("456: " + banco.getSaldo("456"));
		System.out.println("789: " + banco.getSaldo("789"));
		System.out.println("012: " + banco.getSaldo("012"));
		
		System.out.println("\nDuvido que a proxima linha execute");
		banco.renderBonus("123");
	}

}
