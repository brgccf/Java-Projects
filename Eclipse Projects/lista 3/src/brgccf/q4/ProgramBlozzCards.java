package brgccf.q4;
import java.util.Scanner;
public class ProgramBlozzCards {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		Scanner read = new Scanner (System.in);
		String input = "";
		String function = "";
		int id = 0;
		String name = "";
		int cost = 0;
		String description = "";
		int attack = 0;
		int life = 0;
		boolean loop = true;

		System.out.println("Bem vindo ao BlozzCard Collection Manager!");
		//OBS: A questão afirma que PODEMOS assumir que a ENTRADA estará CORRETA
		//"Você pode assumir que a entrada estará no formato correto,
		//com o número correto de entradas, sendo inteiro quando deve ser inteiro e String quando deve ser String, 
		//sem vírgulas no nome ou na descrição."
		Deck cards = new Deck();
		Cards[] collection = new Cards[10];
		do{

			input = read.nextLine();
			if(input.equalsIgnoreCase("stop")){
				loop = false;
			}


			if(loop){

				//verifica se a funçao digitada exige virgulas ou nao:
				boolean isComma = true;
				if(input.equalsIgnoreCase("help")){
					input = "help";
					function = input;
					isComma = false;
				}
				else if(input.equalsIgnoreCase("dispallc")){
					input = "dispallc";
					function = input;
					isComma = false;
				}
				else if(input.equalsIgnoreCase("dispalld")){
					input = "dispalld";
					function = input;
					isComma = false;
				}
				else if(input.equalsIgnoreCase("clearall")){
					input = "clearall";
					function = input;
					isComma = false;
				}

				//armazena a função escolhida pelo usuario e corta a string inicial desconsiderando a parte armazenada (ocorre em todos os passos)
				if(isComma){

					function = input.substring(0, input.indexOf(" "));
					input = input.substring(input.indexOf(" ")+1);
				}
				switch (function){
				case("help"):
					System.out.println("Comandos: " + 
							"\nadde X,N,C,D,A,V --> Adiciona a carta (equipamento) X à coleção"
							+ "\naddcc X,N,C,D,A,V --> Adiciona a carta (criatura comum) X à coleção"
							+ "\naddce X,N,C,D,A,V,H --> Adiciona a carta (criatura especial) X à coleção"
							+ "\naddma X,N,C,D,A --> Adiciona a carta (magica de ataque) X à coleção"
							+ "\naddme X,N,C,D --> Adiciona a carta (magica de efeito) X à coleção"
							+ "\nrem X --> Remove a carta X da coleção" + 
							"\ndispc X --> Mostra as informações da carta X" + 
							"\ndispallc --> Lista todas as cartas, separadas por tipo, ordenadas por custo e em seguida por nome"
							+ "\ncreate K,N --> Cria o deck K, com nome “N”" + 
							"\ndel K --> Apaga o deck K"
							+ "\nrename K,N --> Renomeia o deck K como “N”"
							+ "\naddd K,X --> Adiciona a carta X ao deck K"
							+ "\nremd K,X --> Remove a carta X do deck K"
							+ "\ndispd K --> Imprime o nome do deck K, seguido de todas as cartas do deck, \nseparadas por tipo, ordenadas por custo e em seguida por nome"
							+ "\ndispalld --> Lista todas os decks, ordenados por nome" + 
							"\nclearall --> Limpa todas as informações do programa"
							+ "\nstop --> Encerra o programa");
				break;

				case("adde"):
				case("addcc"):


					String entire = input.substring(0, input.indexOf(","));
				id = strToInt(entire);
				while(id <= 0 && id > 10){
					System.out.println("ID invalida. Digite a Id da carta novamente:");
					while(!in.hasNextInt()){
						System.out.println("Entrada invalida.");
						in.next();
					}
					id = in.nextInt();
				}

				input = input.substring(input.indexOf(",")+1);

				name = input.substring(0, input.indexOf(","));

				input = input.substring(input.indexOf(",")+1);




				//verifica se o usuario deu espaço antes de digitar o custo: se sim, corta o espaço da string
				if(input.charAt(0) == ' '){
					input = input.substring(input.indexOf(" ")+1);
				}
				//armazena a string com o inteiro do custo e converte utilizando o metodo estatico
				String dble = input.substring(0, input.indexOf(","));
				cost = strToInt(dble);

				input = input.substring(input.indexOf(",")+1);

				description = input.substring(0, input.indexOf(","));

				input = input.substring(input.indexOf(",")+1);



				//verifica se o usuario deu espaço antes de digitar o ataque: se sim, corta o espaço da string
				if(input.charAt(0) == ' '){
					input = input.substring(input.indexOf(" ")+1);
				}
				String att = input.substring(0,input.indexOf(","));


				attack = strToInt(att);
				//tratando entradas invalidas para ataque para criaturas
				if(input.equals("addcc")){
					while(attack < 0){
						System.out.println("Ataque invalido. Digite o ataque:");
						while(!in.hasNextInt()){
							System.out.println("Entrada invalida. Digite valor inteiro");
							in.next();
						}
						attack = in.nextInt();
					}
				}
				input = input.substring(input.indexOf(",")+1);

				//verifica se o usuario deu espaço antes de digitar a vida: se sim, corta o espaço da string
				if(input.charAt(0) == ' '){
					input = input.substring(input.indexOf(" ")+1);
				}
				String lf = input.substring(0);
				life = strToInt(lf);
				//tratando entradas invalidas para vida de criatura
				if(function.equals("addcc")){
					while (life <= 0){
						System.out.println("Vida invalida. Digite a vida novamente:");
						while(!in.hasNextInt()){
							System.out.println("Entrada invalida. Digite valor inteiro ");
							in.next();
						}
						life = in.nextInt();
					}
					
				}


				if(function.equals("adde")){
					Equipment equipCard = new Equipment (id, name, cost, description, attack, life);

					if(collection[id-1] == null){
						collection[id-1] = equipCard;

						cards.setCards(collection[id-1], id);
						System.out.println("Carta adicionada com sucesso!");
					}
					else{
						System.out.println("Entrada invalida. Já existe uma carta com este ID. Tente novamente");
					}
				}
				else if(function.equals("addcc")){
					CommonCreatures CommonCard = new CommonCreatures(id, name, cost, description, attack, life);
					//testando se a carta já existe no repositorio collection
					if(collection[id-1] == null){
						collection[id-1] = CommonCard;

						cards.setCards(collection[id-1], id);
						System.out.println("Carta adicionada com sucesso!");
					}
					else{
						System.out.println("Entrada invalida. Já existe uma carta com este ID. Tente novamente");
					}
				}
				break;

				case("addce"):
					

					entire = input.substring(0, input.indexOf(","));
				id = strToInt(entire);
				while(id <= 0 && id > 10){
					System.out.println("ID invalida. Digite a Id da carta novamente:");
					while(!in.hasNextInt()){
						System.out.println("Entrada invalida.");
						in.next();
					}
					id = in.nextInt();
				}

				input = input.substring(input.indexOf(",")+1);

				name = input.substring(0, input.indexOf(","));

				input = input.substring(input.indexOf(",")+1);




				//verifica se o usuario deu espaço antes de digitar o custo: se sim, corta o espaço da string
				if(input.charAt(0) == ' '){
					input = input.substring(input.indexOf(" ")+1);
				}
				//armazena a string com o inteiro do custo e converte utilizando o metodo estatico
				dble = input.substring(0, input.indexOf(","));
				cost = strToInt(dble);

				input = input.substring(input.indexOf(",")+1);

				description = input.substring(0, input.indexOf(","));

				input = input.substring(input.indexOf(",")+1);



				//verifica se o usuario deu espaço antes de digitar o ataque: se sim, corta o espaço da string
				if(input.charAt(0) == ' '){
					input = input.substring(input.indexOf(" ")+1);
				}
				att = input.substring(0,input.indexOf(","));


				attack = strToInt(att);
				//tratando entradas invalidas para ataque
				while(attack < 0){
					System.out.println("Ataque invalido. Digite o ataque:");
					while(!in.hasNextInt()){
						System.out.println("Entrada invalida. Digite valor inteiro");
						in.next();
					}
					attack = in.nextInt();
				}

				input = input.substring(input.indexOf(",")+1);

				//verifica se o usuario deu espaço antes de digitar a vida: se sim, corta o espaço da string
				if(input.charAt(0) == ' '){
					input = input.substring(input.indexOf(" ")+1);
				}
				lf = input.substring(0, input.indexOf(","));
				life = strToInt(lf);
				//tratando entradas invalidas para vida
				while (life <= 0){
					System.out.println("Vida invalida. Digite a vida novamente:");
					while(!in.hasNextInt()){
						System.out.println("Entrada invalida. Digite valor inteiro ");
						in.next();
					}
					life = in.nextInt();
				}


				//Habilidade da carta:
				input = input.substring(input.indexOf(",")+1);

				String hability = input;

				SpecialCreatures SpeCard = new SpecialCreatures(id, name, cost, description, attack, life, hability);
				//testando se a carta já existe no repositorio collection
				if(collection[id-1] == null){
					collection[id-1] = SpeCard;

					cards.setCards(collection[id-1], id);
					System.out.println("Carta adicionada com sucesso!");
				}
				else{
					System.out.println("Entrada invalida. Já existe uma carta com este ID. Tente novamente");
				}

				break;
				case("addma"):
					//carta Magica de Ataque
					entire = input.substring(0, input.indexOf(","));
				id = strToInt(entire);
				while(id <= 0 && id > 10){
					System.out.println("ID invalida. Digite a Id da carta novamente:");
					while(!in.hasNextInt()){
						System.out.println("Entrada invalida.");
						in.next();
					}
					id = in.nextInt();
				}

				input = input.substring(input.indexOf(",")+1);

				name = input.substring(0, input.indexOf(","));

				input = input.substring(input.indexOf(",")+1);




				//verifica se o usuario deu espaço antes de digitar o custo: se sim, corta o espaço da string
				if(input.charAt(0) == ' '){
					input = input.substring(input.indexOf(" ")+1);
				}
				//armazena a string com o inteiro do custo e converte utilizando o metodo estatico
				dble = input.substring(0, input.indexOf(","));
				cost = strToInt(dble);

				input = input.substring(input.indexOf(",")+1);

				description = input.substring(0, input.indexOf(","));

				input = input.substring(input.indexOf(",")+1);



				//verifica se o usuario deu espaço antes de digitar o ataque: se sim, corta o espaço da string
				if(input.charAt(0) == ' '){
					input = input.substring(input.indexOf(" ")+1);
				}
				att = input;


				attack = strToInt(att);
				
				AttackMagic AttMagCard = new AttackMagic(id, name, cost, description, attack);
				if(collection[id-1] == null){
					collection[id-1] = AttMagCard;

					cards.setCards(collection[id-1], id);
					System.out.println("Carta adicionada com sucesso!");
				}
				else{
					System.out.println("Entrada invalida. Já existe uma carta com este ID. Tente novamente");
				}
				break;
				case("addme"):
					//Carta Magica de Efeito
					entire = input.substring(0, input.indexOf(","));
				id = strToInt(entire);
				while(id <= 0 && id > 10){
					System.out.println("ID invalida. Digite a Id da carta novamente:");
					while(!in.hasNextInt()){
						System.out.println("Entrada invalida.");
						in.next();
					}
					id = in.nextInt();
				}

				input = input.substring(input.indexOf(",")+1);

				name = input.substring(0, input.indexOf(","));

				input = input.substring(input.indexOf(",")+1);




				//verifica se o usuario deu espaço antes de digitar o custo: se sim, corta o espaço da string
				if(input.charAt(0) == ' '){
					input = input.substring(input.indexOf(" ")+1);
				}
				//armazena a string com o inteiro do custo e converte utilizando o metodo estatico
				dble = input.substring(0, input.indexOf(","));
				cost = strToInt(dble);

				input = input.substring(input.indexOf(",")+1);

				description = input;
				EffectMagic EffMagCard = new EffectMagic(id, name, cost, description);
				if(collection[id-1] == null){
					collection[id-1] = EffMagCard;

					cards.setCards(collection[id-1], id);
					System.out.println("Carta adicionada com sucesso!");
				}
				else{
					System.out.println("Entrada invalida. Já existe uma carta com este ID. Tente novamente");
				}
				break;
				case("rem"):
					//remover carta
					entire = input.substring(input.length()-1);
				id = strToInt(entire);
				while(id <= 0 && id > 10){
					System.out.println("ID invalida. Digite a Id da carta novamente:");
					while(!in.hasNextInt()){
						System.out.println("Entrada invalida.");
						in.next();
					}
					id = in.nextInt();
				}
				
				collection[id-1] = null;
				cards.removeCard(id);

				System.out.println("Carta removida!");
				break;
				case("dispc"):
					//mostrar informações de uma carta escolhida
					entire = input.substring(input.length()-1);
				id = strToInt(entire);
				while(id <= 0 && id > 10){
					System.out.println("ID invalida. Digite a Id da carta novamente:");
					while(!in.hasNextInt()){
						System.out.println("Entrada invalida.");
						in.next();
					}
					id = in.nextInt();
				}
				
				System.out.println(cards.showInformation(id));
				
				break;
				case("dispallc"):
					
					System.out.println(cards.listCards());
				break;
				
				case("create"):
					//criar um deck a partir do id digitado, com nome "N"
					entire = input.substring(0, input.indexOf(","));
				id = strToInt(entire);
				while(id <= 0 && id > 10){
					System.out.println("ID invalida. Digite a Id da carta novamente:");
					while(!in.hasNextInt()){
						System.out.println("Entrada invalida.");
						in.next();
					}
					id = in.nextInt();
				}
				
				input = input.substring(input.indexOf(",")+1);

				name = input;
				
				Decks deck = new Decks (id, name);
				deck.setDecks(id, name);
				System.out.println("Deck Criado!");
				break;
				

				}








			}

		}while(loop);

		System.out.println("Fim de programa!");

		in.close();
		read.close();
	}


	//metodo para converter de string para int
	public static int strToInt(String str){
		boolean isNeg = false;
		int num = 0;

		//checa se for negativo: se for, assinala o boolean e apaga do string o sinal de hifen
		if(str.charAt(0) == '-'){
			isNeg = true;
			str = str.substring(1, str.length());
		}

		//varre o string e forma o numero digitado pelo usuario atraves da potencia
		for(int i = 0; i < str.length(); i++){
			num *= 10;
			num += str.charAt(i) - '0';
		}
		//se for negativo, adiciona o sinal na frente
		if(isNeg){
			num = -num;
		}


		return num;
	}

}
