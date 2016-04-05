package brgccf.q3;
import java.util.Scanner;
public class ValiantQuiz {
	public static void main (String [] args){
		Scanner in = new Scanner(System.in);
		String escolha, saida;
		saida = null;
		//escolha � o personagem; saida � se o usuario deseja continuar ou nao com o quiz.
		int pontuacao = 0;
		char letra;
		//letra � a resposta escolhida
		boolean a = true;
		//boolean que mantem o programa funcionando ate o usuario pedir para sair;
		//introducao: foi utilizado um do-while em todo o programa para mant�-lo em funcionamento.
		
	do{
		System.out.println("Em 1914, ap�s o assassinato do arqueduque Francisco Fernando, do imp�rio Austro-H�ngaro, a Alemanha declara guerra a R�ssia. \n� o in�cio da Primeira Guerra Mundial. A Fran�a se prepara para cercar o imp�rio germanico. \n3 personagens se destacam nesta guerra, e voce pode ser um deles! Escolha abaixo.");
		System.out.println("Escolha seu personagem pelo nome: ");
		System.out.println("1 - Freddie; ");
		System.out.println("2 - George; ");
		System.out.println("3 - Walt.");
		escolha = in.nextLine();
		while (!escolha.equals("Freddie") && !escolha.equals("George") && !escolha.equals("Walt")){
			System.out.println("Digite o nome corretamente. Tente de novo: ");
			escolha = in.nextLine();
		}
		switch (escolha){
		case ("Freddie"):
			//historia e perguntas relacionadas ao personagem 1 (Freddie):
			System.out.println("Voce escolheu Freddie, um jovem americano que se voluntariou a entrar na guerra porque havia cometido 3 assassinatos. \nComo forma de se redimir para o governo americano, Freddie escolhe entrar na guerra para evitar ser preso, escondendo isso de todos. \nEle acaba lutando ao lado da Fran�a desde o in�cio do conflito. Em meio a um forte cerco alem�o, todos os seus companheiros morrem. \nE � assim que ele conhece Walt, um c�o abandonado em meio ao conflito, mas que logo se tornou o melhor amigo de Freddie.");
			System.out.println("Sobre Freddie, responda o quiz a seguir: ");
			System.out.println("Pergunta 1.1: Qual a nacionalidade de Freddie? \na) Estados Unidos; \nb) Inglaterra; \nc) Fran�a.");
			letra = in.next().charAt(0);
			//evitando que o usuario 'capeta' destrua o programa:
			while (letra != 'a' & letra != 'b' & letra != 'c'){
				System.out.println("Comando invalido. Digite sua resposta com a letra escolhida: ");
				letra = in.next().charAt(0);
			}
			//verificando a resposta do usuario (repete-se ao longo do codigo a cada pergunta);
			if (letra == 'a'){
				System.out.println("Resposta correta!");
				pontuacao += 1;
			}
			else if (letra == 'b' || letra == 'c'){
				System.out.println("Resposta errada.");
			}
			System.out.println("Pergunta 1.2: Qual o segredo de Freddie? \na) Ele traiu sua mulher \nb) Ele matou o seu pai \nc) Ele cometeu tr�s assassinatos");
			letra = in.next().charAt(0);
			while (letra != 'a' & letra != 'b' & letra != 'c'){
				System.out.println("Comando invalido. Digite sua resposta com a letra escolhida: ");
				letra = in.next().charAt(0);
			}
			if (letra == 'c'){
				System.out.println("Resposta correta!");
				pontuacao += 1;
			}
			else if (letra == 'a' || letra == 'b'){
				System.out.println("Resposta errada.");
			}
			System.out.println("Pergunta 1.3: Por que Freddie entrou na guerra? \na) Porque matou o seu pai \nb) Porque queria evitar ser encarcerado \nc) Porque queria trabalhar para a CIA");
			letra = in.next().charAt(0);
			while (letra != 'a' & letra != 'b' & letra != 'c'){
				System.out.println("Comando invalido. Digite sua resposta com a letra escolhida: ");
				letra = in.next().charAt(0);
			}
			if (letra == 'b'){
				System.out.println("Resposta correta!");
				pontuacao += 1;
			}
			else if (letra == 'a' || letra == 'c'){
				System.out.println("Resposta errada.");
			}
			System.out.println("Pergunta 1.4: Na guerra, de que lado ficou Freddie? \na) Da Espanha \nb) Da Inglaterra \nc) Da Fran�a");
			letra = in.next().charAt(0);
			while (letra != 'a' & letra != 'b' & letra != 'c'){
				System.out.println("Comando invalido. Digite sua resposta com a letra escolhida: ");
				letra = in.next().charAt(0);
			}
			if (letra == 'c'){
				System.out.println("Resposta correta!");
				pontuacao += 1;
			}
			else if (letra == 'a' || letra == 'b'){
				System.out.println("Resposta errada.");
			}
			System.out.println("Pergunta 1.5: O que acontece com os companheiros de guerra de Freddie? E o que ele faz depois? \na) Eles morrem. Freddie se mata. \nb) Eles conquistam a Alemanha. Freddie conhece Walt. \nc) Eles s�o fuzilados. Freddie encontra um c�o.");
			letra = in.next().charAt(0);
			while (letra != 'a' & letra != 'b' & letra != 'c'){
				System.out.println("Comando invalido. Digite sua resposta com a letra escolhida: ");
				letra = in.next().charAt(0);
			}
			if (letra == 'c'){
				System.out.println("Resposta correta!");
				pontuacao += 1;
			}
			else if (letra == 'a' || letra == 'b'){
				System.out.println("Resposta errada.");
			}
			//Final de quiz:
			System.out.println("Fim de Quiz! Sua pontua��o foi de " + pontuacao + "/5. At� a pr�xima.");
			pontuacao = 0;
			System.out.println("Deseja sair ou escolher outro personagem? (digite 'sair' ou 'escolher')");
			saida = in.nextLine();
			saida = in.nextLine();
			break;
			
			
		case ("George"):
			//historia e perguntas relacionadas ao personagem 2 (George):
			System.out.println("Voce escolheu George, um piloto brit�nico que perdeu sua fam�lia num ataque alem�o � capital Londres. \nPraticamente sem motivos para viver, George resolve se alistar na guerra para vingar-se da morte de sua fam�lia. \nEm meio a uma investida alem� tentando conquistar Paris, os refor�os a�reos ingleses s�o convocados e George resolve dar o seu melhor. \nPor�m, em meio a tantos inimigos, George tem seu avi�o danificado e sofre um acidente, mas sobrevive. \nAo acordar do impacto, ele percebe que foi socorrido por um c�o e um jovem com uniforme americano...");
			System.out.println("Sobre George, responda o quiz a seguir: ");
			System.out.println("Pergunta 2.1: Qual a profiss�o de George? \na) Aeromo�a \nb) Marinheiro \nc) Piloto");
			letra = in.next().charAt(0);
			//whiles foram utilizados para evitar mau funcionamento caso o usuario digite errado.
			while (letra != 'a' & letra != 'b' & letra != 'c'){
				System.out.println("Comando invalido. Digite sua resposta com a letra escolhida: ");
				letra = in.next().charAt(0);
			}
			if (letra == 'c'){
				System.out.println("Resposta correta!");
				pontuacao += 1;
			}
			else if (letra == 'a' || letra == 'b'){
				System.out.println("Resposta errada.");
			}
			System.out.println("Pergunta 2.2: Por que George entrou na guerra? \na) Porque estava com depress�o \nb) Porque queria vingar a morte dos pais \nc) Porque queria vingar a morte da familia");
			letra = in.next().charAt(0);
			while (letra != 'a' & letra != 'b' & letra != 'c'){
				System.out.println("Comando invalido. Digite sua resposta com a letra escolhida: ");
				letra = in.next().charAt(0);
			}
			if (letra == 'c'){
				System.out.println("Resposta correta!");
				pontuacao += 1;
			}
			else if (letra == 'a' || letra == 'b'){
				System.out.println("Resposta errada.");
			}
			System.out.println("Pergunta 2.3: por que George foi para Paris? \na) Ele foi convocado pelo ex�rcito franc�s \nb) uma investida alem� exigiu uma rea��o brit�nica \nc) Ele foi como um turista");
			letra = in.next().charAt(0);
			while (letra != 'a' & letra != 'b' & letra != 'c'){
				System.out.println("Comando invalido. Digite sua resposta com a letra escolhida: ");
				letra = in.next().charAt(0);
			}
			if (letra == 'b'){
				System.out.println("Resposta correta!");
				pontuacao += 1;
			}
			else if (letra == 'a' || letra == 'c'){
				System.out.println("Resposta errada.");
			}
			System.out.println("Pergunta 2.4: George sofre um acidente. Como foi e o que ocorreu com ele? \na)De avi�o. Foi abatido, mas conseguiu evacuar e sobreviver. \nb)De avi�o. Foi danificado e caiu, mas sobreviveu. \nc) De avi�o. Foi danificado, mas evacuou e caiu num lago, e sobreviveu.");
			letra = in.next().charAt(0);
			while (letra != 'a' & letra != 'b' & letra != 'c'){
				System.out.println("Comando invalido. Digite sua resposta com a letra escolhida: ");
				letra = in.next().charAt(0);
			}
			if (letra == 'b'){
				System.out.println("Resposta correta!");
				pontuacao += 1;
			}
			else if (letra == 'a' || letra == 'c'){
				System.out.println("Resposta errada.");
			}
			System.out.println("Pergunta 2.5: George foi socorrido ap�s seu acidente. Quem o ajudou? \na) Soldados franceses \nb) Freddie e um franc�s \nc) Walt e Freddie");
			letra = in.next().charAt(0);
			while (letra != 'a' & letra != 'b' & letra != 'c'){
				System.out.println("Comando invalido. Digite sua resposta com a letra escolhida: ");
				letra = in.next().charAt(0);
			}
			if (letra == 'c'){
				System.out.println("Resposta correta!");
				pontuacao += 1;
			}
			else if (letra == 'a' || letra == 'b'){
				System.out.println("Resposta errada.");
			}
			System.out.println("Fim de Quiz! Sua pontua��o foi de " + pontuacao + "/5. At� a pr�xima.");
			pontuacao = 0;
			System.out.println("Deseja sair ou escolher outro personagem? (digite 'sair' ou 'escolher')");
			saida = in.nextLine();
			saida = in.nextLine();
			break;
			
			
		case ("Walt"):
			System.out.println("Voce escolheu Walt, um c�o abandonado pertencente a uma fam�lia judia alem�, que ficou sem condi��es de cri�-lo ap�s o in�cio da guerra. \nA Alemanha passou a cortar os gastos p�blicos para investir pesado nos armamentos para a guerra, e com isso toda a sua popula��o foi afetada. \nWalt, sem ter para onde ir, seguiu sem rumo sem saber para onde ia, at� chegar em territ�rio franc�s. \nDiante de tanta viol�ncia, Walt procurou se abrigar em cavernas e trincheiras, alimentando-se dos restos de animais e alimentos dos soldados. \nUm dia, Walt chegou numa trincheira cheia de soldados franceses e alem�es mortos. Foi quando avistou um jovem que utilizada uniforme americano \ne que estava prestes a se matar. Prontamente, encontrou latiu e entregou comida ao jovem. Foi a� que conheceu Freddie \n e se tornou seu melhor amigo.");
			System.out.println("Sobre Walt, responda o quiz a seguir: ");
			System.out.println("Pergunta 3.1: Por que Walt foi abandonado? \na) Porque sua familia era pobre \nb) porque, com a falta de alimentos, sua familia n�o p�de ajud�-lo \nc) porque era muito brabo");
			letra = in.next().charAt(0);
			while (letra != 'a' & letra != 'b' & letra != 'c'){
				System.out.println("Comando invalido. Digite sua resposta com a letra escolhida: ");
				letra = in.next().charAt(0);
			}
			if (letra == 'b'){
				System.out.println("Resposta correta!");
				pontuacao += 1;
			}
			else if (letra == 'a' || letra == 'c'){
				System.out.println("Resposta errada.");
			}
			System.out.println("Pergunta 3.2: A que familia Walt pertencia? \na) Judeus franceses \nb) Judeus italianos \nc) Judeus alem�es");
			letra = in.next().charAt(0);
			while (letra != 'a' & letra != 'b' & letra != 'c'){
				System.out.println("Comando invalido. Digite sua resposta com a letra escolhida: ");
				letra = in.next().charAt(0);
			}
			if (letra == 'c'){
				System.out.println("Resposta correta!");
				pontuacao += 1;
			}
			else if (letra == 'a' || letra == 'b'){
				System.out.println("Resposta errada.");
			}
			System.out.println("Pergunta 3.3: Como Walt sobreviveu, ap�s ser abandonado? \na) Ele seguiu rumo a territ�rio franc�s, buscando outra fam�lia \nb) Ele se alimentou dos restos mortais dos soldados mortos \nc) Ele procurou comer pequenos animais e restos de enlatados");
			letra = in.next().charAt(0);
			while (letra != 'a' & letra != 'b' & letra != 'c'){
				System.out.println("Comando invalido. Digite sua resposta com a letra escolhida: ");
				letra = in.next().charAt(0);
			}
			if (letra == 'c'){
				System.out.println("Resposta correta!");
				pontuacao += 1;
			}
			else if (letra == 'a' || letra == 'b'){
				System.out.println("Resposta errada.");
			}
			System.out.println("Pergunta 3.4: Ao chegar numa trincheira repleta de soldados mortos, Walt: \na) Investiga e procura por sobreviventes \nb) Late pedindo ajuda \nc) Contorna o caminho");
			letra = in.next().charAt(0);
			while (letra != 'a' & letra != 'b' & letra != 'c'){
				System.out.println("Comando invalido. Digite sua resposta com a letra escolhida: ");
				letra = in.next().charAt(0);
			}
			if (letra == 'a'){
				System.out.println("Resposta correta!");
				pontuacao += 1;
			}
			else if (letra == 'c' || letra == 'b'){
				System.out.println("Resposta errada.");
			}
			System.out.println("Pergunta 3.5: Como Walt se tornou o melhor amigo de Freddie? \na) Ele salvou a vida dele matando um soldado alem�o \nb) Ele salvou sua vida trazendo alimento em meio a um tiroteio \nc) Ele salvou sua vida ao se tornar um companheiro e evitar seu suic�dio");
			letra = in.next().charAt(0);
			while (letra != 'a' & letra != 'b' & letra != 'c'){
				System.out.println("Comando invalido. Digite sua resposta com a letra escolhida: ");
				letra = in.next().charAt(0);
			}
			if (letra == 'c'){
				System.out.println("Resposta correta!");
				pontuacao += 1;
			}
			else if (letra == 'a' || letra == 'b'){
				System.out.println("Resposta errada.");
			}
			System.out.println("Fim de Quiz! Sua pontua��o foi de " + pontuacao + "/5. At� a pr�xima.");
			pontuacao = 0;
			System.out.println("Deseja sair ou escolher outro personagem? (digite 'sair' ou 'escolher')");
			saida = in.nextLine();
			saida = in.nextLine();
			break;
		}
		
		
		
		while (!saida.equals("sair") && !saida.equals("escolher")){
			System.out.println("Voce digitou errado. Digite 'sair' ou 'escolher'.");
			saida = in.nextLine();
		}
		
		
		if (saida.equals("sair")){
			System.out.println("Fim de programa.");
			a = false;
		}
		else if (saida.equals("escolher")){
			a = true;
		}
	} while (a == true);
	
	in.close();
	}

}
