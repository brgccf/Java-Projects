package brgccf.q4;
import java.util.Scanner;
public class SubmitChecker {
	private String endereco;
	private String padrao;
	private String login;
	private int numero;
	
	public SubmitChecker(String endereco, String padrao,
			String login, int numero){
		this.endereco = endereco;
		this.padrao = padrao;
		this.login = login;
		this.numero = numero;
	}
	public SubmitChecker(String padrao){
		this.padrao = padrao;
	}
	
	public String getEndereco(){
		return endereco;
	}
	public void setEndereco(String endereco){
		this.endereco = endereco;
	}
	public String getPadrao(){
		return padrao;
	}
	public void setPadrao(String padrao){
		this.padrao = padrao;
		padrao = ("zip>>" + login + ">>q" + numero);
	}
	public String getLogin(){
		return login;
	}
	public void setLogin(String login){
		this.login = login;
	}
	public int getNumero(){
		return numero;
	}
	public void setNumero(int numero){
		this.numero = numero;
	}
	public String caminho(){
		return this.endereco;
	}
	
	public static void main (String [] args){
		Scanner ler = new Scanner (System.in);
		Scanner in = new Scanner (System.in);
		int menu = 0, numero;
		int menupasta;
		String login, caminho, visaogeral = " ";
		caminho = " ";
		System.out.println("Insira login: ");
		login = ler.nextLine();
		System.out.println("Insira o numero da questao: " );
		numero = in.nextInt();
		//gerando a string padrao:
		SubmitChecker padrao = new SubmitChecker ("zip>>" + login + ">>q" + numero);
		System.out.println("MENU-DESKTOP: \nvisão geral:" + caminho +  "\n1-Criar pasta única ou modificar existente;"
				+ "\n2-Selecionar pasta;"
				+ "\n3-Inserir pasta no desktop em um arquivo zip.");
		menu = in.nextInt();
		
		while (menu == 1){
			System.out.println("insira um nome: ");
			if (caminho.equals(" ")){
				caminho = ler.nextLine();
			}
			else{
			    int e = caminho.length();
				caminho = ler.nextLine() + caminho.substring(caminho.indexOf(">>", e));
			}
			visaogeral = caminho;
			System.out.println("MENU-DESKTOP: \nVisão geral: " + caminho
					+ "\nPasta criada/alterada. O que deseja fazer? "
					+ "\n2- Selecionar pasta" + "\n3-inserir pasta no desktop em arquivo zip");
			menu = in.nextInt();
		}
		
		while (menu == 2){
			if (!caminho.equals(" ")){
			System.out.println("Pasta atual: " + caminho +
					"\nvisão geral: " + login + "\n1- Renomear pasta"
					+ "\n2- realocar conteudo e excluir pasta" + 
					"\n3- abrir proxima pasta" + 
					"\n4- voltar à pasta anterior" + 
					"\n5- criar e abrir proxima pasta" + 
					"\n6- inserir pasta atual em um arquivo zip");
			menupasta = in.nextInt();
			while (menupasta == 1){
				System.out.println("Digite o novo nome: ");
				caminho = ler.nextLine();
				System.out.println("Pasta renomeada. Digite nova função: ");
				menupasta = in.nextInt();
			}
			while (menupasta == 2){
				caminho = ">>q" + numero; 
				System.out.println("Pasta apagada. Digite nova função:");
				menupasta = in.nextInt();
			}
			while (menupasta == 3){
				int a = caminho.length() - 4;
				if (caminho.equals(caminho.substring(0, a))){
					System.out.println("não há pasta após a atual. Digite outra função: ");
					menupasta = in.nextInt();
				}
				else{
					int b = caminho.length();
					caminho = caminho.substring(b);
					System.out.println("Pasta atual: " + caminho + "\nDigite nova funçao: ");
					menupasta = in.nextInt();
				}
			}
			while (menupasta == 4){
				if (caminho.length() > 4 ){
					caminho = caminho.substring(0, 4);
					System.out.println("Pasta atual: " + caminho + "\nvisão geral: "
							+ visaogeral);
					menupasta = in.nextInt();
				}
				else{
					System.out.println("MENU-DESKTOP: \nvisão geral:" + caminho +  "\n1-Criar pasta única ou modificar existente;"
							+ "\n2-Selecionar pasta;"
							+ "\n3-Inserir pasta no desktop em um arquivo zip.");
					menu = in.nextInt();
				}
			}
			while (menupasta == 5){
				System.out.println("Digite o nome da nova pasta: ");
				caminho = ler.nextLine() + caminho.substring(caminho.indexOf(">>"));
				visaogeral = caminho;
				
				System.out.println("Pasta atual: " + caminho + "\nVisão geral: " + visaogeral
						+ "Digite outra função: ");
				menupasta = in.nextInt();
				
			}
			while (menupasta == 6){
				caminho = caminho.indexOf("zip>>") + caminho;
				if (caminho.equals(padrao)){
					System.out.println("Resultado: " + "\nSubmissão está correta!");
				}
				else{
					System.out.println("Resultado: \nSubmissão está incorreta e o aluno zerou essa questão." );
				}
				menupasta = 0;
				menu = 0;
				System.out.println("Fim de programa.");
			}
			}
			else{
				System.out.println("Não há pastas no desktop. Crie uma antes:");
				System.out.println("insira um nome: ");
				if (caminho.equals(" ")){
					caminho = ler.nextLine();
				}
				else{
					caminho = ler.nextLine() + caminho.substring(caminho.indexOf(">>"));
				}
				visaogeral = caminho;
				menu = 2;
				System.out.println("Pasta atual: " + caminho +
						"\nvisão geral: " + login + "\n1- Renomear pasta"
						+ "\n2- realocar conteudo e excluir pasta" + 
						"\n3- abrir proxima pasta" + 
						"\n4- voltar à pasta anterior" + 
						"\n5- criar e abrir proxima pasta" + 
						"\n6- inserir pasta atual em um arquivo zip");
				menupasta = in.nextInt();
			}
		}
		while (menu == 3){
			caminho = caminho.indexOf("zip>>") + caminho;
			if (caminho.equals(padrao)){
				System.out.println("Resultado: " + "\nSubmissão está correta!");
			}
			else{
				System.out.println("Resultado: \nSubmissão está incorreta e o aluno zerou essa questão." );
			}
			menupasta = 0;
			menu = 0;
			System.out.println("Fim de programa.");
		}
			
			
		in.close();
		ler.close();
		
		
	}
	
	
	
}
