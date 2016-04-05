package brgccf.q3;
import java.util.Scanner;
public class ValiantQuiz {
	public static void main (String [] args){
		Scanner in = new Scanner(System.in);
		String escolha, saida;
		saida = null;
		//escolha é o personagem; saida é se o usuario deseja continuar ou nao com o quiz.
		int pontuacao = 0;
		char letra;
		//letra é a resposta escolhida
		boolean a = true;
		//boolean que mantem o programa funcionando ate o usuario pedir para sair;
		//introducao: foi utilizado um do-while em todo o programa para mantê-lo em funcionamento.
		
	do{
		System.out.println("Em 1914, após o assassinato do arqueduque Francisco Fernando, do império Austro-Húngaro, a Alemanha declara guerra a Rússia. \nÉ o início da Primeira Guerra Mundial. A França se prepara para cercar o império germanico. \n3 personagens se destacam nesta guerra, e voce pode ser um deles! Escolha abaixo.");
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
			System.out.println("Voce escolheu Freddie, um jovem americano que se voluntariou a entrar na guerra porque havia cometido 3 assassinatos. \nComo forma de se redimir para o governo americano, Freddie escolhe entrar na guerra para evitar ser preso, escondendo isso de todos. \nEle acaba lutando ao lado da França desde o início do conflito. Em meio a um forte cerco alemão, todos os seus companheiros morrem. \nE é assim que ele conhece Walt, um cão abandonado em meio ao conflito, mas que logo se tornou o melhor amigo de Freddie.");
			System.out.println("Sobre Freddie, responda o quiz a seguir: ");
			System.out.println("Pergunta 1.1: Qual a nacionalidade de Freddie? \na) Estados Unidos; \nb) Inglaterra; \nc) França.");
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
			System.out.println("Pergunta 1.2: Qual o segredo de Freddie? \na) Ele traiu sua mulher \nb) Ele matou o seu pai \nc) Ele cometeu três assassinatos");
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
			System.out.println("Pergunta 1.4: Na guerra, de que lado ficou Freddie? \na) Da Espanha \nb) Da Inglaterra \nc) Da França");
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
			System.out.println("Pergunta 1.5: O que acontece com os companheiros de guerra de Freddie? E o que ele faz depois? \na) Eles morrem. Freddie se mata. \nb) Eles conquistam a Alemanha. Freddie conhece Walt. \nc) Eles são fuzilados. Freddie encontra um cão.");
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
			System.out.println("Fim de Quiz! Sua pontuação foi de " + pontuacao + "/5. Até a próxima.");
			pontuacao = 0;
			System.out.println("Deseja sair ou escolher outro personagem? (digite 'sair' ou 'escolher')");
			saida = in.nextLine();
			saida = in.nextLine();
			break;
			
			
		case ("George"):
			//historia e perguntas relacionadas ao personagem 2 (George):
			System.out.println("Voce escolheu George, um piloto britânico que perdeu sua família num ataque alemão à capital Londres. \nPraticamente sem motivos para viver, George resolve se alistar na guerra para vingar-se da morte de sua família. \nEm meio a uma investida alemã tentando conquistar Paris, os reforços aéreos ingleses são convocados e George resolve dar o seu melhor. \nPorém, em meio a tantos inimigos, George tem seu avião danificado e sofre um acidente, mas sobrevive. \nAo acordar do impacto, ele percebe que foi socorrido por um cão e um jovem com uniforme americano...");
			System.out.println("Sobre George, responda o quiz a seguir: ");
			System.out.println("Pergunta 2.1: Qual a profissão de George? \na) Aeromoça \nb) Marinheiro \nc) Piloto");
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
			System.out.println("Pergunta 2.2: Por que George entrou na guerra? \na) Porque estava com depressão \nb) Porque queria vingar a morte dos pais \nc) Porque queria vingar a morte da familia");
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
			System.out.println("Pergunta 2.3: por que George foi para Paris? \na) Ele foi convocado pelo exército francês \nb) uma investida alemã exigiu uma reação britânica \nc) Ele foi como um turista");
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
			System.out.println("Pergunta 2.4: George sofre um acidente. Como foi e o que ocorreu com ele? \na)De avião. Foi abatido, mas conseguiu evacuar e sobreviver. \nb)De avião. Foi danificado e caiu, mas sobreviveu. \nc) De avião. Foi danificado, mas evacuou e caiu num lago, e sobreviveu.");
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
			System.out.println("Pergunta 2.5: George foi socorrido após seu acidente. Quem o ajudou? \na) Soldados franceses \nb) Freddie e um francês \nc) Walt e Freddie");
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
			System.out.println("Fim de Quiz! Sua pontuação foi de " + pontuacao + "/5. Até a próxima.");
			pontuacao = 0;
			System.out.println("Deseja sair ou escolher outro personagem? (digite 'sair' ou 'escolher')");
			saida = in.nextLine();
			saida = in.nextLine();
			break;
			
			
		case ("Walt"):
			System.out.println("Voce escolheu Walt, um cão abandonado pertencente a uma família judia alemã, que ficou sem condições de criá-lo após o início da guerra. \nA Alemanha passou a cortar os gastos públicos para investir pesado nos armamentos para a guerra, e com isso toda a sua população foi afetada. \nWalt, sem ter para onde ir, seguiu sem rumo sem saber para onde ia, até chegar em território francês. \nDiante de tanta violência, Walt procurou se abrigar em cavernas e trincheiras, alimentando-se dos restos de animais e alimentos dos soldados. \nUm dia, Walt chegou numa trincheira cheia de soldados franceses e alemães mortos. Foi quando avistou um jovem que utilizada uniforme americano \ne que estava prestes a se matar. Prontamente, encontrou latiu e entregou comida ao jovem. Foi aí que conheceu Freddie \n e se tornou seu melhor amigo.");
			System.out.println("Sobre Walt, responda o quiz a seguir: ");
			System.out.println("Pergunta 3.1: Por que Walt foi abandonado? \na) Porque sua familia era pobre \nb) porque, com a falta de alimentos, sua familia não pôde ajudá-lo \nc) porque era muito brabo");
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
			System.out.println("Pergunta 3.2: A que familia Walt pertencia? \na) Judeus franceses \nb) Judeus italianos \nc) Judeus alemães");
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
			System.out.println("Pergunta 3.3: Como Walt sobreviveu, após ser abandonado? \na) Ele seguiu rumo a território francês, buscando outra família \nb) Ele se alimentou dos restos mortais dos soldados mortos \nc) Ele procurou comer pequenos animais e restos de enlatados");
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
			System.out.println("Pergunta 3.5: Como Walt se tornou o melhor amigo de Freddie? \na) Ele salvou a vida dele matando um soldado alemão \nb) Ele salvou sua vida trazendo alimento em meio a um tiroteio \nc) Ele salvou sua vida ao se tornar um companheiro e evitar seu suicídio");
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
			System.out.println("Fim de Quiz! Sua pontuação foi de " + pontuacao + "/5. Até a próxima.");
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
