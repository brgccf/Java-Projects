package exercicio;
import java.util.Scanner;
public class ProgramaHeroi {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		Scanner ler = new Scanner (System.in);
		String nome, superPoder, universo;
		int poderDestruicao;
		
		System.out.println("Who's your hero?");
		nome = ler.nextLine();
		
		System.out.println("What's its superpower?");
		superPoder = ler.nextLine();
		
		System.out.println("What's the universe?");
		universo = ler.nextLine();
		
		System.out.println("What's its destruction power? ");
		poderDestruicao = in.nextInt();
		
		
		Heroi Hero = new Heroi (nome, superPoder, universo, poderDestruicao);
		
		System.out.println(Hero.getNome() + "\n" + Hero.getSuperPoder() + "\n" + 
		Hero.getUniverso() + "\n" + Hero.getPoderDestruicao());
		
		
		
		
		
		
		
		
		
		
		
		ler.close();
		in.close();
	}

}
