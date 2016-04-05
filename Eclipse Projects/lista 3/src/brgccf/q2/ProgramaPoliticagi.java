package brgccf.q2;
import java.util.Scanner;
public class ProgramaPoliticagi {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		Scanner read = new Scanner (System.in);
		//choice determina a escolha do usuario no menu inicial
		int choice;
		String name;
		//name armazena o nome digitado pelo usuario

		//partialpopularity armazena a popularidade da pessoa criada pelo usuario
		double partialPopularity;
		System.out.println("Bem vindo ao Politicagi. Escolha o que deseja fazer:");
		//loop mantem o programa funcionando
		boolean loop = true;


		//family sera utilizado para registrar novas pessoas
		Familia family = new Familia ();

		//do-while mantendo o programa funcionando at� o usuario pedir popularidade total (conforme a questao)
		do{

			System.out.println("1) Adicionar pessoa" + "\n2)mostrar popularidade parcial de alguem" + 
					"\n3) Mostrar popularidade total de algu�m");
			while(!in.hasNextInt()) in.next();
			choice = in.nextInt();
			//tratando entradas invalidas
			while(choice <= 0 && choice > 3){
				System.out.println("Entrada invalida. Digite um dos valores do menu.");
				while(!in.hasNextInt()){
					System.out.println("Entrada invalida. Digite um dos valores do menu.");
					in.next();
				}
				choice = in.nextInt();
			}





			if(loop){

				switch (choice){
				case(1):
					System.out.println("Diga o nome");
				name = read.nextLine();
				//for para verificar se a pessoa j� foi cadastrada no programa

				for(int i = 0; i < family.getPeople().length; i++){
					//se a posicao no array for diferente de null, entramos no if.
					if(family.getPeople()[i] != null){
						if (name.equalsIgnoreCase(family.getPeople()[i].getName())){

							System.out.println("Pessoa j� cadastrada! Digite o nome novamente");
							name = read.nextLine();
							//zera o i para percorrer novamente todo o array
							i = 0;
						}
					}
				}


				System.out.println("Diga a popularidade:");
				while(!in.hasNextDouble()){
					System.out.println("Entrada invalida. Digite um dos valores do menu.");
					in.next();
				}
				partialPopularity = in.nextDouble();
				Pessoa person = new Pessoa (name, null, null, partialPopularity);
				family.registerPeople(person);


				System.out.println("Adicionada.");
				break;

				case(2):
					System.out.println("Diga o nome da pessoa");
				name = read.nextLine();
				//executa o metodo para procurar pessoa 
				Pessoa person2 = family.searchPerson(name);
				while(person2 == null){
					System.out.println("Pessoa n�o encontrada. tente novamente:");
					name = read.nextLine();
					person2 = family.searchPerson(name);
					
				}
				//imprime na tela
				System.out.println("A popularidade parcial de " + name + " � " + person2.getPartialPopularity());
				

				break;
				case(3):
					System.out.println("Diga o nome:");
				name = read.nextLine();
				//executa o metodo de popularidade total
				double result = family.totalPopularity(name);

				System.out.println("A popularidade total de " + name + " � " + result);

				//finaliza o programa apos o resultado da popularidade total
				loop = false;
				break;

				}



			}

		}while(loop);

		System.out.println("Fim de programa.");






		read.close();
		in.close();
	}

}
