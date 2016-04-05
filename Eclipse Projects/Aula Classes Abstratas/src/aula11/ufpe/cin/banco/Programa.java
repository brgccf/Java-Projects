package aula11.ufpe.cin.banco;
import java.util.Scanner;
public class Programa {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		double taxa = 0.01;
		Banco banco = new Banco (taxa);
		
		Conta conta = new Conta ("123-conta");
		banco.cadastrar(conta);
		System.out.println("Conta cadastrada. \n" + conta.toString());
		banco.creditar("123-conta", 120);
		System.out.println("Creditado valor. \n" + conta.toString());
		banco.debitar("123-conta", 20);
		System.out.println("Debitado valor. \n" + conta.toString());
		
		Poupanca poupanca = new Poupanca("321-poupanca");
		banco.cadastrarPoupanca(poupanca);
		System.out.println("Poupanca cadastrada. \n" + poupanca.toString());
		banco.creditar("321-poupanca", 125);
		System.out.println("Valor creditado em poupança. \n" + poupanca.toString());
		banco.renderJuros("321-poupanca");
		System.out.println("Juros rendidos. \n" + poupanca.toString());
		banco.debitar("321-poupanca", 35);
		System.out.println("Valor debitado de poupanca \n" + poupanca.toString());
		
		
		
		
		
		/*

		System.out.println("Digite quantas contas deseja criar:");
		int contas = in.nextInt();
		for(int i = contas; i > 0; i--){
			System.out.println("Digite um numero para a prox conta");
			in.nextLine();
			String numero = in.nextLine();
			
			Conta conta = new Conta (numero);
			banco.cadastrar(conta);
			numero = "";
		}
		System.out.println("Digite quantos créditos deseja fazer");
		int creditos = in.nextInt();
		for (int i = creditos; i > 0; i-- ){
			System.out.println("digite o numero da conta:");
			in.nextLine();
			String numero2 = in.nextLine();
			System.out.println("Digite o valor a ser creditado:");
			
			double valor = in.nextDouble();
			
			banco.creditar(numero2, valor);
			System.out.println("Valor de R$ " + valor + " creditado na conta de numero " + numero2 + 
					"\nSeu saldo é: R$ " + banco.getSaldo(numero2));
		}
		System.out.println("Digite quantos débitos deseja fazer");
		int debitos = in.nextInt();
		for(int i = debitos; i > 0; i--){
			System.out.println("Digite o numero da conta");
			String numero3 = in.nextLine();
			System.out.println("Digite o valor a ser debitado");
			double valor2 = in.nextDouble();
			banco.debitar(numero3, valor2);
			System.out.println("Valor de R$ " + valor2 + " debitado na conta de numero " + numero3 + 
					"\nSeu saldo é de: R$ " + banco.getSaldo(numero3));
		}
		*/
		
				
			
				
				
				
				
				
				
		in.close();
	}
	
	

}
