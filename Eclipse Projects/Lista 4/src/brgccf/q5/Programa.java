package brgccf.q5;
import java.util.Scanner;
import brgccf.q1.*;

public class Programa {
	//	OBS: CLASSE CRIADA QUANDO ESTAVA FAZENDO A Q1. (não tive tempo de readaptar para fachada)

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		Scanner ler = new Scanner (System.in);
		Scanner ch = new Scanner (System.in);
		int contadorJogadores = 1;
		int contadorMestres = 1;
		String nome = "";
		Classes classe = null;
		Dados dados = new Dados();
		//o jogo possui um minimo de 3 jogadores, mas um máximo de 5 (excluindo o mestre)
		//1ª Parte: cadastro de jogadores + 2ª Parte: cadastro de mestres!
		boolean loopJogadores = true;
		boolean loopMestres = false;
		do{
			if(loopJogadores){
				System.out.println("Bem vindo. Comece efetuando o cadastro dos jogadores: "
						+ "\nObs: Crie muitos para o programa funcionar corretamente.");
				System.out.println("Nome do jogador " + contadorJogadores + " : ");
				nome = ler.nextLine();
			}
			else if(loopMestres){
				System.out.println("Vamos cadastrar agora os mestres do programa.");
				System.out.println("Nome do mestre " + contadorMestres + ":");
				nome = ler.nextLine();
			}
			System.out.println("Login para " + nome + " : ");
			String login = ler.nextLine();

			System.out.println("Escolha uma classe: " + "\n1) Guerreiro" + "\n2) Arqueiro"
					+ "\n3)Mago" + "\n4) Clérigo" + "\n5) Ladino");
			//tratando entradas invalidas para a classe

			while(!in.hasNextInt()){
				System.out.println("Entrada invalida. Digite um valor inteiro.");
				in.next();
			}
			int escolha = in.nextInt();
			while(escolha < 1 || escolha > 5){
				System.out.println("Entrada invalida. Escolha um valor do menu.");
				while(!in.hasNextInt()){
					System.out.println("Entrada invalida. Digite um valor inteiro!");
					in.next();
				}
				escolha = in.nextInt();
			}
			//definindo a classe:
			switch(escolha){
			case(1):
				classe = new Guerreiro();
			break;
			case(2):
				classe = new Arqueiro();
			break;
			case(3):
				classe = new Mago();
			break;
			case(4):
				classe = new Clerigo();
			break;
			case(5):
				classe = new Ladino();
			break;
			}
			System.out.println("Classe definida!");

			System.out.println("Digite agora os dias da semana disponíveis para o jogador " + nome + " :");
			System.out.println("1) Segundas-feiras" + "\n2) Terças-feiras" + "\n3) Quartas-feiras" + "\n4) Quintas-feiras"
					+ "\n5) Sextas-feiras" + "\n6) Sábados" + "\n7) Domingos" + "\n0) Confirmar dias");

			//tratando entradas invalidas para os dias:
			boolean dispDias = true;
			boolean[] dias = new boolean[7];
			do{
				while(!in.hasNextInt()){
					System.out.println("Entrada invalida. Digite um valor inteiro do menu!");
					in.next();
				}
				int dia = in.nextInt();
				while(dia < 1 && dia > 7){
					System.out.println("Entrada invalida! Escolha um dos dias do menu!");
					while(!in.hasNextInt()){
						System.out.println("Entrada invalida. Digite um valor inteiro do menu!");
						in.next();
					}
					dia = in.nextInt();
				}

				switch (dia){
				case(1):
					dias[0] = true;
				System.out.println("Segunda-feira disponível para " + nome + " ! ");
				break;
				case(2):
					dias[1] = true;
				System.out.println("Terça-feira disponível para " + nome + " ! ");
				break;
				case(3):
					dias[2] = true;
				System.out.println("Quarta-feira disponível para " + nome + " ! ");
				break;
				case(4):
					dias[3] = true;
				System.out.println("Quinta-feira disponível para " + nome + " ! ");
				break;
				case(5):
					dias[4] = true;
				System.out.println("Sexta-feira disponível para " + nome + " ! ");
				break;
				case(6):
					dias[5] = true;
				System.out.println("Sábado disponível para " + nome + " ! ");
				break;
				case(7):
					dias[6] = true;
				System.out.println("Domingo disponível para " + nome + " ! ");
				break;
				default:
					dispDias = false;
				}
				//verifica se o jogador escolheu pelo menos um dia. se nao, repete o processo do menu.
				boolean encontrou = false;
				for(int i = 0; !encontrou && i < dias.length; i++){
					if(dias[i]){
						encontrou = true;
					}
				}
				//se nao encontrou nenhum dia escolhido, devemos repetir o menu para que o usuario escolha um dia	
				if(!encontrou){
					dispDias = true;
					System.out.println("Você não selecionou nenhum dia! Tente novamente. Escolha a opção no menu: "
							+ "1) Segundas-feiras" + "\n2) Terças-feiras" + "\n3) Quartas-feiras" + "\n4) Quintas-feiras"
							+ "\n5) Sextas-feiras" + "\n6) Sábados" + "\n7) Domingos" + "\n0) Confirmar dias");
				}

			}while(dispDias);
			if(loopJogadores){
				System.out.println("Jogador cadastrado com sucesso!");

				//cadastra o jogador no programa
				Jogadores jogador = new Jogadores(nome, classe, login, dias);
				dados.setJogadores(jogador);


				System.out.println("Deseja finalizar o cadastro de jogadores? (digite s/n)");
				while(!ch.hasNext("s") && !ch.hasNext("n")){
					System.out.println("Entrada inválida! Digite 's' ou 'n'.");
					ch.next();
				}
				char sair = ch.next().charAt(0);
				switch(sair){
				case('s'):
					loopJogadores = false;
				loopMestres = true;
				break;
				case('n'):
					loopJogadores = true;
				break;
				}
				contadorJogadores++;
			}
			else if(loopMestres){
				System.out.println("Mestre cadastrado com sucesso!");
				Mestres mestre = new Mestres (nome, classe, login, dias);
				dados.setMestres(mestre);

				System.out.println("Deseja finalizar o cadastro de mestres? (digite s/n)");
				while(!ch.hasNext("s") && !ch.hasNext("n")){
					System.out.println("Entrada inválida! Digite 's' ou 'n'.");
					ch.next();
				}
				char sair = ch.next().charAt(0);
				switch(sair){
				case('s'):
					loopMestres = false;
				break;
				case('n'):
					loopMestres = true;
				break;
				}
				contadorMestres++;
			}

		}while (loopJogadores || loopMestres);


		boolean loopPersonagens = true;
		int contadorPersonagens = 1;
		//3º passo: cadastrando personagens no programa!
		do{
			System.out.println("Adicione agora os personagens de seu programa! ");
			System.out.println("Nome do personagem " + contadorPersonagens + ":");
			nome = ler.nextLine();
			System.out.println("Digite o sexo de " + nome + ": (digite m/f)");
			//tratando entradas invalidas para char
			while(!ch.hasNext("m") && !ch.hasNext("f")){
				System.out.println("Entrada inválida! Digite 'm' ou 'f'.");
				ch.next();
			}
			char sexo = ch.next().charAt(0);

			System.out.println("Escolha uma classe: " + "\n1) Guerreiro" + "\n2) Arqueiro"
					+ "\n3)Mago" + "\n4) Clérigo" + "\n5) Ladino");
			//tratando entradas invalidas para a classe

			while(!in.hasNextInt()){
				System.out.println("Entrada invalida. Digite um valor inteiro.");
				in.next();
			}
			int escolha = in.nextInt();
			while(escolha < 1 || escolha > 5){
				System.out.println("Entrada invalida. Escolha um valor do menu.");
				while(!in.hasNextInt()){
					System.out.println("Entrada invalida. Digite um valor inteiro!");
					in.next();
				}
				escolha = in.nextInt();
			}
			//definindo a classe:
			switch(escolha){
			case(1):
				classe = new Guerreiro();
			break;
			case(2):
				classe = new Arqueiro();
			break;
			case(3):
				classe = new Mago();
			break;
			case(4):
				classe = new Clerigo();
			break;
			case(5):
				classe = new Ladino();
			break;
			}
			System.out.println("Classe definida!");

			System.out.println("Personagem " + nome + " Criado com sucesso!");
			Personagens personagem = new Personagens(nome, classe, sexo);
			dados.setPersonagens(personagem);

			System.out.println("Deseja finalizar o cadastro de personagens? (digite s/n)");
			while(!ch.hasNext("s") && !ch.hasNext("n")){
				System.out.println("Entrada inválida! Digite 's' ou 'n'.");
				ch.next();
			}
			char sair = ch.next().charAt(0);
			switch(sair){
			case('s'):
				loopPersonagens = false;
			break;
			case('n'):
				loopPersonagens = true;
			break;
			}
			contadorPersonagens++;

		}while(loopPersonagens);

		//CRIANDO SESSÃO!

		boolean loopCriandoSessoes = true;
		int contadorSessoes = 1;

		do{

			System.out.println("Vamos criar as sessões de seu programa!");
			System.out.println("Digite o dia da sessão " + contadorSessoes + ":");
			System.out.println("1) Segunda-feira" + "\n2) Terça-feira" + "\n3) Quarta-feira" + "\n4) Quinta-feira"
					+ "\n5) Sexta-feira" + "\n6) Sábado" + "\n7) Domingo");
			//tratando entradas invalidas para o dia escolhido
			while(!in.hasNextInt()){
				System.out.println("Entrada invalida. Digite um valor inteiro do menu!");
				in.next();
			}
			int diaSessao = in.nextInt();
			while(diaSessao < 1 && diaSessao > 7){
				System.out.println("Entrada invalida! Escolha um dos dias do menu!");
				while(!in.hasNextInt()){
					System.out.println("Entrada invalida. Digite um valor inteiro do menu!");
					in.next();
				}
				diaSessao = in.nextInt();
			}
			//definindo nome da aventura
			System.out.println("Dia definido! Digite agora o nome da aventura:");
			String aventura = ler.nextLine();
			//definindo mestre da sessão
			System.out.println("Muito bem! Digite agora o login do mestre desta sessão: ");
			String loginMestre = ler.nextLine();
			//verificando se o nome digitado confere com algum mestre do programa
			boolean tentarNovamente = false;
			Mestres mestreSessao = null;
			while(tentarNovamente == false){
				try{
					//se o mestre for definido com sucesso, o boolean se tornará verdadeiro
					mestreSessao = dados.procuraMestre(loginMestre, diaSessao);
					System.out.println("Mestre definido com sucesso!"
							+ "O mestre da sessão " + contadorSessoes
							+ " é " + mestreSessao.getNome());
					//aumentando o indice de sessoes mestradas do mestre digitado
					mestreSessao.setSessoesMestradas();
					tentarNovamente = true;
				}
				//capturando exceções possíveis
				catch(MestreNaoEncontradoException e){
					System.out.println(e.getMessage());
					loginMestre = ler.nextLine();
				}
				catch(MestreNaoJogaNoMesmoDiaException e){
					System.out.println(e.getMessage());
					loginMestre = ler.nextLine();
				}

			}


			contadorJogadores = 1;
			loopJogadores = true;
			//definindo os jogadores:
			Jogadores[] jogadoresSessao = new Jogadores[5];
			do{

				System.out.println("Ok. Vamos definir agora os jogadores desta sessão! Lembre-se que a capacidade máxima é de 5 jogadores, e no mínimo 3");
				System.out.println("Login do jogador " + contadorJogadores + ":");
				String loginJogador = ler.nextLine();
				//verificando se o nome digitado confere com algum jogador (não mestre) do programa
				tentarNovamente = false;
				Jogadores jogadorSessao = null;
				while(tentarNovamente == false){
					try{
						jogadorSessao = dados.procuraJogador(loginJogador, diaSessao);

						System.out.println("Jogador " + contadorJogadores + " Definido com Sucesso! "
								+ "Jogador " + contadorJogadores + " = " + jogadorSessao.getNome());
						tentarNovamente = true;

					}
					//tratando exceções possíveis
					catch(JogadorNaoEncontradoException e){
						System.out.println(e.getMessage());
						loginJogador = ler.nextLine();
					}
					catch(JogadorNaoJogaNoMesmoDiaException e){
						System.out.println(e.getMessage());
						System.out.println(e.getJogador().getNome());
						loginJogador = ler.nextLine();
					}
				}
				//armazenando jogador nos dados do programa
				jogadoresSessao[contadorJogadores-1] = jogadorSessao;
				contadorJogadores++;
				//verificando se a sessão ficou lotada
				if(contadorJogadores == 6){
					System.out.println("Sessão lotada. Adição de jogadores finalizada.");
					loopJogadores = false;
				}
				//se nao está lotada ainda, pergunta se deseja adicionar mais
				else if(contadorJogadores < 6 && contadorJogadores >= 3 ){
					System.out.println("Deseja adicionar mais jogadores? (digite s/n)");
					while(!ch.hasNext("s") && !ch.hasNext("n")){
						System.out.println("Entrada inválida! Digite 's' ou 'n'.");
						ch.next();
					}
					char sair = ch.next().charAt(0);
					switch(sair){
					case('s'):
						loopJogadores = true;
					break;
					case('n'):
						loopJogadores = false;
					break;
					}
				}

			}while(loopJogadores);
			//criando a sessão e armazenando em dados
			Sessao sessao = new Sessao(diaSessao, aventura, mestreSessao, jogadoresSessao);
			dados.setSessao(sessao);
			System.out.println("Sessão criada com sucesso! Deseja criar mais sessões? (digite s/n)");
			while(!ch.hasNext("s") && !ch.hasNext("n")){
				System.out.println("Entrada inválida! Digite 's' ou 'n'.");
				ch.next();
			}
			char sair = ch.next().charAt(0);
			switch(sair){
			case('s'):

				loopCriandoSessoes = true;
			break;
			case('n'):

				loopCriandoSessoes = false;
			break;
			}
			contadorSessoes++;

		}while(loopCriandoSessoes);
		//perguntando se deseja-se criar uma sessão balanceada:
		System.out.println("Deseja criar uma sessão balanceada? (digite s/n)");
		while(!ch.hasNext("s") && !ch.hasNext("n")){
			System.out.println("Entrada inválida! Digite 's' ou 'n'.");
			ch.next();
		}
		char sessaoBalanceada = ch.next().charAt(0);
		switch(sessaoBalanceada){
		case('s'):
			boolean tentarNovamente = true;
		int idSessao = 0;
		while(tentarNovamente){
			System.out.println("Digite o dia da sessão:");
			System.out.println("1) Segunda-feira" + "\n2) Terça-feira" + "\n3) Quarta-feira" + "\n4) Quinta-feira"
					+ "\n5) Sexta-feira" + "\n6) Sábado" + "\n7) Domingo");
			//tratando entradas invalidas para o dia escolhido
			while(!in.hasNextInt()){
				System.out.println("Entrada invalida. Digite um valor inteiro do menu!");
				in.next();
			}
			int diaSessao = in.nextInt();
			while(diaSessao < 1 && diaSessao > 7){
				System.out.println("Entrada invalida! Escolha um dos dias do menu!");
				while(!in.hasNextInt()){
					System.out.println("Entrada invalida. Digite um valor inteiro do menu!");
					in.next();
				}
				diaSessao = in.nextInt();
			}
			//definindo nome da aventura
			System.out.println("Dia definido! Digite agora o nome da aventura:");
			String aventura = ler.nextLine();
			//tratando exceção caso nenhum mestre possa jogar no dia desta sessao
			try{
				idSessao = dados.criaSessaoBalanceada(diaSessao, aventura);
			}
			catch(MestreNaoJogaNoMesmoDiaException e){
				System.out.println("Nenhum mestre do programa pode jogar no dia desta sessão balanceada! Tente novamente!");
			}
			tentarNovamente = false;
		}

		System.out.println("Sua sessão balanceada foi criada com sucesso! Você pode jogá-la escolhendo " + idSessao);

		break;
		case('n'):

			System.out.println("Sem problemas!");
		break;
		}
		//após a finalização da criação de sessões, criamos um array de boolean para ter o controle sobre quais estão abertas/fechadas
		boolean[] sessoesAbertas = new boolean[dados.getSessoes().length];
		//também criamos o boolean abaixo para manter o funcionamento da sessao.
		boolean jogandoSessoes = true;
		do{
			//começando uma sessão!
			System.out.println("Vamos jogar? Escolha uma sessão para iniciar! " + 
					"\nVocê tem " + dados.getSessoes().length + " Sessões disponíveis. Digite qual deseja começar:");
			//tratando entradas invalidas para a escolha da sessao
			while(!in.hasNextInt()){
				System.out.println("Entrada invalida! Digite um valor inteiro dentro da quantidade de sessões e diferente de zero!");
				in.next();
			}
			int intSessaoEscolhida = in.nextInt();
			while(intSessaoEscolhida <= 0 && intSessaoEscolhida > dados.getSessoes().length){
				System.out.println("Entrada invalida! Digite um inteiro dentro do intervalo de quantidade de sessões!");
				in.next();
				while(!in.hasNextInt()){
					System.out.println("Entrada invalida! Digite um valor inteiro dentro do intervalo citado!");
					in.next();
				}
				intSessaoEscolhida = in.nextInt();
			}

			sessoesAbertas[intSessaoEscolhida] = true;
			//definindo sessao escolhida
			Sessao sessaoEscolhida = dados.getSessoes()[intSessaoEscolhida];
			System.out.println("Sessão iniciada! Aventura: " + sessaoEscolhida.getNomeAventura());
			//definindo os personagens do mestre da sessao:
			System.out.println("Vamos definir os personagens do mestre " + sessaoEscolhida.getMestre().getNome() + "!");
			//limitando a quantidade de personagens de acordo com a quantidade cadastrada no programa:
			System.out.println("Este mestre pode ter um máximo de " + dados.getPersonagens().length + " Personagens.");
			System.out.println("Quantos personagens este mestre terá? Digite um valor inteiro maior que 0 e dentro do limite.");
			//tratando entradas invalidas e armazenando valor digitado
			while(!in.hasNextInt()){
				System.out.println("Entrada invalida! Digite um valor inteiro maior que zero.");
				in.next();
			}
			int qtdPersonagensMestre = in.nextInt();
			while(qtdPersonagensMestre <= 0 && qtdPersonagensMestre > dados.getPersonagens().length){
				System.out.println("Entrada invalida! Você digitou um inteiro fora do limite de personagens cadastrados. Tente novamente");
				while(!in.hasNextInt()){
					System.out.println("Entrada invalida! Digite um valor inteiro maior que zero!");
					in.next();
				}
				qtdPersonagensMestre = in.nextInt();
			}
			//cria array de personagens do mestre do tamanho desejado:
			contadorPersonagens = 1;
			Personagens[] personagensMestreSessao = new Personagens[qtdPersonagensMestre];
			//vai pedindo os personagens até finalizar de acordo com a quantidade de personagens escolhida para o mestre
			for (int i = 0; i < personagensMestreSessao.length; i++) {
				System.out.println("Escolha os personagens! Digite o nome do " + contadorPersonagens + "º personagem:");
				nome = ler.nextLine();
				boolean tentarNovamente = true;
				Personagens personagemEscolhido = null;
				while(tentarNovamente){
					try{
						personagemEscolhido = dados.procuraPersonagem(nome);
						tentarNovamente = false;
					}
					catch(PersonagemNaoEncontradoException e){
						System.out.println(e.getMessage());
						nome = ler.nextLine();
					}
					catch(PersonagemSendoUtilizadoException e){
						System.out.println(e.getMessage());
						nome = ler.nextLine();
					}
				}
				personagensMestreSessao[i] = personagemEscolhido;
				//altera o boolean de utilização do personagem
				personagensMestreSessao[i].setSendoUtilizadoTrue();
				System.out.println(contadorPersonagens + "º Personagem definido com sucesso!");
				contadorPersonagens++;
			}
			//define o array configurado como sendo os personagens do mestre:
			sessaoEscolhida.getMestre().setPersonagens(personagensMestreSessao);
			System.out.println("Personagens do mestre da sessão definidos com sucesso!");

			//definindo personagens dos jogadores da sessão escolhida:
			Personagens personagemEscolhido = null;
			System.out.println("Vamos agora definir os personagens dos jogadores da aventura " + sessaoEscolhida.getNomeAventura() + "!");
			for (int i = 0; i < sessaoEscolhida.getJogadores().length; i++) {
				System.out.println("Escolha o personagem do jogador " + sessaoEscolhida.getJogadores()[i].getNome() + 
						", que possui login " + sessaoEscolhida.getJogadores()[i].getLogin() + ". Digite um nome de personagem: ");
				nome = ler.nextLine();
				boolean tentarNovamente = true;
				while(tentarNovamente){
					try{
						personagemEscolhido = dados.procuraPersonagem(nome);
						tentarNovamente = false;
					}
					catch(PersonagemNaoEncontradoException e){
						System.out.println(e.getMessage());
						nome = ler.nextLine();
					}
					catch(PersonagemSendoUtilizadoException e){
						System.out.println(e.getMessage());
						nome = ler.nextLine();
					}
				}
				//define o personagem para o jogador:
				sessaoEscolhida.definePersonagemJogador(sessaoEscolhida.getJogadores()[i], personagemEscolhido);
				//altera o boolean de utilização:
				personagemEscolhido.setSendoUtilizadoTrue();
				System.out.println("Personagem " + personagemEscolhido.getNome() + " definido para o jogador " + 
						sessaoEscolhida.getJogadores()[i].getNome() + "!");
			}

			System.out.println("Todos os personagens definidos para os jogadores da aventura " + sessaoEscolhida.getNomeAventura());
			//após o cadastro dos personagens, temos o menu da sessão:
			System.out.println("O que deseja fazer agora? " + "\n1) Verificar personagem de maior nível na sessão atual"
					+ "\n2) Verificar se a sessão está balanceada"
					+ "\n3) Modificar um personagem "
					+ "\n4) Abrir nova sessão "
					+ "\n5) Encerrar sessão atual");
			//tratando entradas invalidas para a escolha
			while(!in.hasNextInt()){
				System.out.println("Entrada invalida! Digite um inteiro do menu");
				in.next();
			}
			int escolha = in.nextInt();
			while(escolha < 1 && escolha > 5){
				System.out.println("Entrada invalida! Digite um inteiro do menu exposto!");
				while(!in.hasNextInt()){
					System.out.println("Entrada invalida novamente! Digite um valor do menu!");
					in.next();
				}
				escolha = in.nextInt();
			}

			boolean loopMenuSessao = true;

			while(loopMenuSessao){
				switch(escolha){
				case(1):
					//VERIFICAR PERSONAGEM DE MAIOR NÍVEL NA SESSÃO ATUAL
					try{
						Personagens personagemMaiorNivel = sessaoEscolhida.maiorNivel(sessaoEscolhida);
						System.out.println("O personagem de maior nível desta sessão é " + personagemMaiorNivel.getNome());
					}
				catch(GrupoBalanceadoException e){
					System.out.println(e.getMessage());
				}
				System.out.println("O que deseja fazer agora? "
						+ "\n2) Verificar se a sessão está balanceada"
						+ "\n3) Modificar um personagem "
						+ "\n4) Abrir nova sessão "
						+ "\n5) Encerrar sessão atual");
				//tratando entradas invalidas para a escolha
				while(!in.hasNextInt()){
					System.out.println("Entrada invalida! Digite um inteiro do menu");
					in.next();
				}
				escolha = in.nextInt();
				while(escolha < 2 && escolha > 5){
					System.out.println("Entrada invalida! Digite um inteiro do menu exposto!");
					while(!in.hasNextInt()){
						System.out.println("Entrada invalida novamente! Digite um valor do menu!");
						in.next();
					}
					escolha = in.nextInt();
				}
				break;
				case(2):
					//VERIFICAR SE A SESSÃO ESTÁ BALANCEADA
					boolean balanceada = sessaoEscolhida.verificaBalanceamentoSessao(sessaoEscolhida);
				if(balanceada){
					System.out.println("A sessão está balanceada!");
				}
				else{
					System.out.println("Esta sessão não é balanceada.");
				}
				System.out.println("O que deseja fazer agora? " + "\n1) Verificar personagem de maior nível na sessão atual"
						+ "\n3) Modificar um personagem "
						+ "\n4) Abrir nova sessão "
						+ "\n5) Encerrar sessão atual");
				//tratando entradas invalidas para a escolha
				while(!in.hasNextInt()){
					System.out.println("Entrada invalida! Digite um inteiro do menu");
					in.next();
				}
				escolha = in.nextInt();
				while(escolha < 1 && escolha > 5){
					System.out.println("Entrada invalida! Digite um inteiro do menu exposto!");
					while(!in.hasNextInt()){
						System.out.println("Entrada invalida novamente! Digite um valor do menu!");
						in.next();
					}
					escolha = in.nextInt();
				}

				break;
				case(3):
					//MODIFICAR PERSONAGEM
					System.out.println("Digite o nome do personagem que deseja modificar: ");
				nome = ler.nextLine();
				boolean tentarNovamente = true;
				Personagens personagemModificado = null;
				while(tentarNovamente){
					try{
						personagemModificado = sessaoEscolhida.procuraPersonagemSessao(nome, sessaoEscolhida);
						tentarNovamente = false;
					}
					catch(PersonagemNaoEncontradoException e){
						System.out.println("O personagem digitado não existe nesta sessão. Tente novamente! Digite um nome: ");
						nome = ler.nextLine();
					}
				}
				//menu de escolha da modificação desejada
				System.out.println("Ok. O que deseja modificar em " + personagemModificado.getNome() + "?"
						+ "\n1) Nome"
						+ "\n2) Classe"
						+ "\n3) Sexo");
				//tratamente de entradas invalidas para o menu de modificação do personagem escolhido
				while(!in.hasNextInt()){
					System.out.println("Entrada invalida! Digite um inteiro do menu");
					in.next();
				}
				int menuModificacao = in.nextInt();
				while(menuModificacao < 1 && menuModificacao > 3){
					System.out.println("Entrada invalida! Digite um inteiro do menu exposto ");
					while(!in.hasNextInt()){
						System.out.println("Entrada invalida! Digite um inteiro do menu");
						in.next();
					}
					menuModificacao = in.nextInt();
				}

					switch(menuModificacao){
					case(1):
						System.out.println("Digite um novo nome: ");
					nome = ler.nextLine();
					personagemModificado.setNome(nome);
					System.out.println("Nome modificado com sucesso! " );
					break;
					case(2):
						System.out.println("Escolha uma classe: " + "\n1) Guerreiro" + "\n2) Arqueiro"
								+ "\n3)Mago" + "\n4) Clérigo" + "\n5) Ladino");
					//tratando entradas invalidas para a classe
	
					while(!in.hasNextInt()){
						System.out.println("Entrada invalida. Digite um valor inteiro.");
						in.next();
					}
					int escolhaClasseNova = in.nextInt();
					while(escolhaClasseNova < 1 || escolhaClasseNova > 5){
						System.out.println("Entrada invalida. Escolha um valor do menu.");
						while(!in.hasNextInt()){
							System.out.println("Entrada invalida. Digite um valor inteiro!");
							in.next();
						}
						escolhaClasseNova = in.nextInt();
					}
					//definindo a classe:
						switch(escolhaClasseNova){
						case(1):
							classe = new Guerreiro();
						break;
						case(2):
							classe = new Arqueiro();
						break;
						case(3):
							classe = new Mago();
						break;
						case(4):
							classe = new Clerigo();
						break;
						case(5):
							classe = new Ladino();
						break;
						}
					personagemModificado.setClasse(classe);
					System.out.println("Classe modificada com sucesso!");
					case(3):
						System.out.println("Digite o sexo de " + personagemModificado.getNome() + ": (digite m/f)");
					//tratando entradas invalidas para char
					while(!ch.hasNext("m") && !ch.hasNext("f")){
						System.out.println("Entrada inválida! Digite 'm' ou 'f'.");
						ch.next();
					}
					char sexo = ch.next().charAt(0);
					personagemModificado.setSexo(sexo);
					System.out.println("Sexo redefinido com sucesso!");
					}
					
					System.out.println("O que deseja fazer agora? " + "\n1) Verificar personagem de maior nível na sessão atual"
							+ "\n2) Verificar se a sessão está balanceada "
							+ "\n4) Abrir nova sessão "
							+ "\n5) Encerrar sessão atual");
					//tratando entradas invalidas para a escolha
					while(!in.hasNextInt()){
						System.out.println("Entrada invalida! Digite um inteiro do menu");
						in.next();
					}
					escolha = in.nextInt();
					while(escolha < 1 && escolha > 5){
						System.out.println("Entrada invalida! Digite um inteiro do menu exposto!");
						while(!in.hasNextInt()){
							System.out.println("Entrada invalida novamente! Digite um valor do menu!");
							in.next();
						}
						escolha = in.nextInt();
					}
				break;
				case(4):
					loopMenuSessao = false;
					break;
				case(5):
					System.out.println("Aventura " + sessaoEscolhida.getNomeAventura() + " Encerrada com sucesso!");
					sessaoEscolhida.encerraSessao(sessaoEscolhida);
					loopMenuSessao = false;
					break;
				}

			}
			
			System.out.println("Deseja finalizar o programa? (digite s/n");
			//tratando entradas invalidas para char
			while(!ch.hasNext("m") && !ch.hasNext("f")){
				System.out.println("Entrada inválida! Digite 'm' ou 'f'.");
				ch.next();
			}
			char sair = ch.next().charAt(0);
			switch(sair){
			case('s'):
				jogandoSessoes = false;
			case('n'):
				jogandoSessoes = true;
			}
			


		}while(jogandoSessoes);


		System.out.println("Fim de programa! Até a proxima.");







		ch.close();
		ler.close();
		in.close();

	}

}
