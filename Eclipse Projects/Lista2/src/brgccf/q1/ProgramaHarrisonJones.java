package brgccf.q1;
import java.util.Scanner;
public class ProgramaHarrisonJones {
	public static void main (String [] args){
		Scanner ler = new Scanner (System.in);
		Scanner in = new Scanner (System.in);
		String nome;
		//nome armazena nome do personagem
		
		boolean loop = true;
		char movimento;
		//loop mantem o programa funcionando
		//movimento determina a direcao de cada
		
		System.out.println("Bem vindo ao Jogo Harrison Jones And The First Crusade! \nPara começar, digite o nome de seu herói:");
		nome = ler.nextLine();
		Personagem p = new Personagem (nome);
		
		
		//definindo mapa do jogo
		Mapa map = new Mapa (p);
		map.defineInicio();
		map.defineChao();
		map.defineArmadilha();
		
		
		System.out.println("O mapa do jogo: ");
		System.out.println(map.printMap());
		
		do{
		System.out.println("Qual o proximo passo de " + p.getNome() + "?");
		//aceitando entradas minusculas e maiusculas
		movimento = in.next().charAt(0);
		switch (movimento){
		case ('w'):
			movimento = 'W';
			break;
		case('a'):
			movimento = 'A';
			break;
		case ('d'):
			movimento = 'D';
			break;
		case('s'):
			movimento = 'S';
			break;
		case ('p'):
			movimento = 'P';
			break;
		}
		
		//invalidando caracteres fora dos aceitaveis
		while ((movimento != 'W' && movimento != 'w') && (movimento != 'A' && movimento != 'a')
				&& (movimento != 'D' && movimento != 'd') && (movimento != 'S' && movimento != 's') && 
				(movimento != 'P' && movimento != 'p')){
			System.out.println("Caractere invalido. Tente novamente: ");
			movimento = in.next().charAt(0);
		}
		//fazendo o personagem se mover de acordo com o comando
		switch (movimento){
		case ('W'):
			map.moveUp();
		
			System.out.println(map.printMap());
			System.out.println("Vida Atual: " + p.getLife());
			break;
		case ('A'):
			map.moveLeft();
			System.out.println(map.printMap());
			System.out.println("Vida Atual: " + p.getLife());
			break;
		case('D'):
			map.moveRight();
			System.out.println(map.printMap());
			System.out.println("Vida Atual: " + p.getLife());
			break;
			
		case('S'):
			map.moveDown();
		
			System.out.println(map.printMap());
			System.out.println("Vida Atual: " + p.getLife());
			break;
		case('P'):
			p.usePotion();
			System.out.println("Vida atual: " + p.getLife());
			break;
	
		}
		
		//verificando se sua vida zerou
		if (p.getLife() == 0){
			loop = false;
			System.out.println("Você morreu. Fim de jogo.");
		}
		//verificando se o jogo acabou
		if (p.getTest() == 0){
			loop = false;
			System.out.println("Parabéns! Você achou o tesouro perdido.");
		}
		
		
		
		
		
		
		}while (loop == true);
		
		
	
		
		in.close();
		ler.close();
	}
	
}
