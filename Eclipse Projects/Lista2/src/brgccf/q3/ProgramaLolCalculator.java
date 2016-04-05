package brgccf.q3;
import java.util.Scanner;
public class ProgramaLolCalculator {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		boolean loop = true;
		//OBS: JAMAIS JOGUEI LOL NA MINHA VIDA. FAVOR CORRIGIR LEVANDO ESTA OBSERVAÇÃO EM CONTA.
		int choose;
		int choice = 0;
		int items = 0;
		int which = 0;
		int countSO = 0;
		int countBC = 0;
		int countBRK = 0;
		int countTB = 0;
		int countNT = 0;
		int countSA = 0;
		int stacks = 0;
		int attacks = 0;
		double result = 0;
		double damage;
		double lifeCha;
		double lifeResult;
		double attackOut = 0;
		int choiceAttack = 0;
		/*loop mantem o funcionamento do programa
		 * choose é a escolha do menu inicial
		 * choice é a escolha do menu secundário (Khazix ataca ou Rengar ataca)
		 * items é a quantidade de items que o campeao tem
		 * which são quais itens possui o campeao.
		 * count foi utilizado para tratar as passivas unicas
		 * stacks sao pesos referentes a itens especificos
		 * attacks define quantas vezes o personagem vai atacar
		 * result retorna o resultado final de quantos PV o personagem perdeu apos os ataques
		 * armorPen armazenará a penetração da armadura antes de algum ataque ser feito (classes khazix e rengar)
		 * armor armazenará a armadura do campeao antes de sofrer o ataque (classes khazix e rengar)
		 * damage é o dano que sera causado dependendo do resultado do multiplicador de redução
		 * e depois passa a ser o dano causado por um ataque especifico
		 * attDamage é a informação de quanto dano algum ataque causou
		 * lifeCha é utilizado para subtrair o dano do ataque escolhido
		 * lifeResult é a vida resultante do personagem ao fim do programa
		 * attackOut é a saida apos os calculos de dano de ataque
		 */
		
		do{
			//boolean abaixo sera utilizado no momento em que rengar for atacar, para definir o ataque basico
			boolean isStacks30 = false;

			//menu inicial
			System.out.println("Olá invocador, escolha sua opção no menu: ");
			System.out.println("1) fazer novo cálculo: " + "\n2) Sair");
			while (!in.hasNextInt()) in.next();
			choose = in.nextInt();
			//teste se a escolha do menu inicial esta correta
			while (choose != 1 && choose != 2){
				System.out.println("Entrada invalida. Tente novamente:");
				while (!in.hasNextInt()); in.next();
				choose = in.nextInt();
			}
			//continuação do programa dependendo da escolha inicial
			switch(choose){
			case(1):
				System.out.println("1) Kha'Zix ataca e Rengar defende" + "\n2) Rengar ataca e Kha'Zix defende");
			while (!in.hasNextInt()) in.next();
			choice = in.nextInt();
			break;
			case(2):
				loop = false;
			break;

			}
			//caso nao tenha escolhido 2, prossiga o programa
			if (loop == true){
				//testa se houve entrada invalida no menu secundario
				while (choice != 1 && choice != 2){
					System.out.println("Entrada invalida. Tente novamente:");
					while (!in.hasNextInt()) in.next();
					choice = in.nextInt();
				}
				//continua o programa de acordo com a escolha no menu secundario
				switch(choice){
				case(1):
					System.out.println("Diga quantos itens Kha'Zix possui em seu inventário:");
				while (!in.hasNextInt()) in.next();
				items = in.nextInt();
				break;
				case(2):
					System.out.println("Diga quantos itens Rengar possui em seu inventário: ");
				while (!in.hasNextInt()) in.next();
				items = in.nextInt();
				break;
				}
				//testa se houve entrada invalida na quantidade de itens digitada
				while(items <= 0 && items > 6){
					System.out.println("Entrada invalida. valor máx itens = 6.");
					while (!in.hasNextInt()) in.next();
					items = in.nextInt();
				}
				System.out.println("Digite agora, quais são esses itens:");
				//caso tenha escolhido Khazix atacando
				if (choice == 1){
					Khazix khazix = new Khazix (2018.0, 75.0, 108.0, 0);
					System.out.println("1) Sword of the Occult" + "\n2) B.F Sword" + 
							"\n3) The Bloodthirster" + "\n4) The Black Cleaver" + 
							"\n5) Blade Of The Ruined King" + "\n6) The Brutalizer");
					//o for mantem o programa pedindo entradas ate zerarem os itens
					for (int i = items; i > 0; i--){
						while (!in.hasNextInt()) in.next();
						which = in.nextInt();

						switch (which){

						case(1):
							//tratar passiva unica
							if(countSO == 0){
								countSO += 1;
								System.out.println("Quantas stacks a Sword of the Occult possui?");
								while (!in.hasNextInt()) in.next();
								stacks = in.nextInt();
								//testa se houve entrada invalida pra stacks
								while (stacks < 0 && stacks > 20){
									System.out.println("Entrada invalida. Stacks estao validos entre 0 e 20.");
									while (!in.hasNextInt()) in.next();
									stacks = in.nextInt();
								}
							}

						//executa o metodo para o item escolhido
						khazix.swordOfTheOccult(stacks);
						stacks = 0;
						System.out.println("Sword of the Occult adicionada(o)");
						break;
						case(2):
							khazix.bfSword();
						System.out.println("B. F. Sword adicionada(o)");
						break;
						case(3):
							khazix.theBloodthirster();
						System.out.println("The Bloodthirster adicionado");
						break;
						case(4):
							//tratar passiva unica
							if (countBC == 0){
								khazix.theBlackCleaver(countBC);
								countBC += 1;
							}
							else{
								khazix.theBlackCleaver(countBC);
							}

						System.out.println("The Black Cleaver adicionado");
						break;
						case(5):
							//tratar passiva unica
							if (countBRK == 0){
								khazix.bladeOfTheRuinedKing(countBRK);
								countBRK += 1;
							}
							else{
								khazix.bladeOfTheRuinedKing(countBRK);
							}

						System.out.println("Blade Of The Ruined King adicionado.");
						break;
						case(6):
							//tratar passiva unica
							if (countTB == 0){
								khazix.theBrutalizer(countTB);
								countTB += 1;
							}
							else{
								khazix.theBrutalizer(countTB);
							}

						System.out.println("The Brutalizar adicionado");
						}
					}
					//dizendo com o que Rengar irá se defender:
					items = 0;
					System.out.println("Diga quantos itens Rengar possui em seu inventário:");
					while (!in.hasNextInt()) in.next();
					items = in.nextInt();	
					while(items <= 0 && items > 6){
						System.out.println("Entrada invalida. Máx itens = 6. Mín itens = 1.");
						while (!in.hasNextInt()) in.next();
						items = in.nextInt();	
					}
					Rengar rengar = new Rengar (2116.0, 85.4, 111.0, 0.0);
					System.out.println("1) Chain Vest" + "\n2) Ninja Tabi" + "\n3)Randuin's Omen" + 
							"\n4) Thornmail" + "\n5) Seeker Arm'sguard" + "\n6) Sunfire Cape");
					for (int i = items; i > 0; i--){
						while (!in.hasNextInt()) in.next();
						which = in.nextInt();
						switch (which){
						case(1):
							rengar.chainVest();
						System.out.println("Chain Vest adicionado");
						break;
						case(2):
							//tratar passiva unica
							if (countNT == 0){
								rengar.ninjaTabi(countNT);
								countNT += 1;
							}
							else{
								rengar.ninjaTabi(countNT);
							}

						System.out.println("Ninja Tabi adicionado");
						break;
						case(3):
							rengar.randuinsOmen();
						System.out.println("Randuin's Omen adicionado");
						break;
						case(4):
							rengar.tornmail();
						System.out.println("Thornmail adicionado");
						break;
						case(5):
							//tratar passiva unica
							if (countSA == 0){
								countSA += 1;

								System.out.println("Quantos stacks?");
								while (!in.hasNextInt()) in.next();
								stacks = in.nextInt();
								while(stacks < 0 && stacks > 30){
									System.out.println("Entrada invalida. Stacks validos entre 0 e 30");
									while (!in.hasNextInt()) in.next();
									stacks = in.nextInt();
								}

								rengar.seekerArmsGuard(stacks);
								stacks = 0;
							}

							else{

								rengar.seekerArmsGuard(stacks);
							}

						System.out.println("Seeker Arm's Guard adicionado");
						break;
						case(6):
							rengar.sunfireCape();
						System.out.println("Sunfire Cape adicionado");
						break;

						}
					}
					//Kha'Zix ataca!
					System.out.println("Digite agora quantas vezes Khazix vai atacar:");
					while (!in.hasNextInt()) in.next();
					attacks = in.nextInt();
					//impendindo entradas invalidas
					while (attacks <= 0){
						System.out.println("Entrada invalida. khazix deve atacar pelo menos uma vez. Tente novamente:");
						while (!in.hasNextInt()) in.next();
						attacks = in.nextInt();
					}
					System.out.println("Digite qual(is) ataque(s) ele vai utilizar:" + 
							"\n1) Ataque básico" + "\n2) Taste Their Fear" + "\n3) Void Spike" + 
							"\n4) Leap ");
					//o for abaixo pede os ataques até zerar a quantidade digitada acima
					for(int i = attacks; i > 0; i--){
						
						while (!in.hasNextInt()) in.next();
						choiceAttack = in.nextInt();
						//impedindo entradas invalidas
						while(choiceAttack <= 0 && choiceAttack > 4){
							System.out.println("Entrada invalida. Escolha um dos ataques acima");
							while (!in.hasNextInt()) in.next();
							choiceAttack = in.nextInt();
						}
						//calculando o dano causado de acordo com o ataque escolhido
						switch(choiceAttack){
						case(1):
							//os passos abaixo servem para todos os ataques
							//1º passo: executa o metodo referente ao ataque
							//(outros passos na classe khazix)
							khazix.basicAttack();
						damage = khazix.battleKhazix();
						//8º passo: soma na variavel result para dar o resultado final apos todos os ataques
						result += damage;
						//9º passo: imprime na tela o resultado do ataque escolhido
						System.out.println("O dano causado pelo ataque básico foi de " + 
								damage + " PV no Rengar.");
						
						break;
						case(2):
							khazix.tasteTheirFear();
						damage = khazix.battleKhazix();
						result += damage;
						System.out.println("O dano causado pelo Taste Their Fear foi de " + 
								damage + " PV no Rengar.");
						
						break;
						case(3):
							khazix.voidSpike();
						damage = khazix.battleKhazix();
						result += damage;
						System.out.println("O dano causado por Void Spike foi de " + 
								damage + " PV no Rengar");
						
						break;
						case(4):
							khazix.leap();
						damage = khazix.battleKhazix();
						damage = 2018.0 - attackOut;
						result += damage;
						System.out.println("O dano causado por Leap foi de " + damage + " PV no Rengar");
						break;
						}
					
					}
					lifeCha = rengar.getLifeRengar();
					lifeResult = lifeCha - result;
					if(result < 0 || lifeResult < 0){
						lifeResult = 0;
					}
					//10º passo: finaliza a operação verificando qual foi a diferença total de dano e imprime a vida do inimigo.
					System.out.println("O dano total causado pelo Kha'Zix no Rengar foi de " + result + 	
							", resultando num restante de " + lifeResult + " de vida no Rengar");
					//11º passo: zera as variaveis utilizadas para evitar erros posteriormente
					lifeCha = 0;
					lifeResult = 0;
					result = 0;
					choiceAttack = 0;



				}
				
				
				//caso tenha escolhido Rengar atacando
				else if (choice == 2){
					Rengar rengar = new Rengar (2116.0, 85.4, 111.0, 0.0);
					System.out.println("1) Chain Vest" + "\n2) Ninja Tabi" + "\n3)Randuin's Omen" + 
							"\n4) Thornmail" + "\n5) Seeker Arm'sguard" + "\n6) Sunfire Cape");
					for (int i = items; i > 0; i--){
						while (!in.hasNextInt()) in.next();
						which = in.nextInt();
						switch (which){
						case(1):
							rengar.chainVest();
						System.out.println("Chain Vest adicionado");
						break;
						case(2):
							//tratar passiva unica
							if (countNT == 0){
								rengar.ninjaTabi(countNT);
								countNT += 1;
							}
							else{
								rengar.ninjaTabi(countNT);
							}

						System.out.println("Ninja Tabi adicionado");
						break;
						case(3):
							rengar.randuinsOmen();
						System.out.println("Randuin's Omen adicionado");
						break;
						case(4):
							rengar.tornmail();
						System.out.println("Thornmail adicionado");
						break;
						case(5):
							
							//tratar passiva unica
							if (countSA == 0){
								countSA += 1;

								System.out.println("Quantos stacks?");
								while (!in.hasNextInt()) in.next();
								stacks = in.nextInt();
								while(stacks < 0 && stacks > 30){
									System.out.println("Entrada invalida. Stacks validos entre 0 e 30");
									while (!in.hasNextInt()) in.next();
									stacks = in.nextInt();
								}
								if(stacks == 30){
									isStacks30 = true;
								}
								rengar.seekerArmsGuard(stacks);
								stacks = 0;
							}

							else{

								rengar.seekerArmsGuard(stacks);
							}

						System.out.println("Seeker Arm's Guard adicionado");
						break;
						case(6):
							rengar.sunfireCape();
						System.out.println("Sunfire Cape adicionado");
						break;

						}
					}
					items = 0;
					//dizendo com o que Khazix ira se defender
					System.out.println("Digite quantos itens Khazix possui em seu inventario");
					while(!in.hasNextInt()); in.next();
					items = in.nextInt();
					while(items <= 0 && items > 6){
						System.out.println("Entrada invalida. Max itens = 6; Min itens = 1");
						while(!in.hasNextInt()); in.next();
						items = in.nextInt();
					}
					
					Khazix khazix = new Khazix (2018.0, 75.0, 108.0, 0);
					System.out.println("1) Sword of the Occult" + "\n2) B.F Sword" + 
							"\n3) The Bloodthirster" + "\n4) The Black Cleaver" + 
							"\n5) Blade Of The Ruined King" + "\n6) The Brutalizer");
					//o for mantem o programa pedindo entradas ate zerarem os itens
					for (int i = items; i > 0; i--){
						while (!in.hasNextInt()) in.next();
						which = in.nextInt();

						switch (which){

						case(1):
							//tratar passiva unica
							if(countSO == 0){
								countSO += 1;
								System.out.println("Quantas stacks a Sword of the Occult possui?");
								while (!in.hasNextInt()) in.next();
								stacks = in.nextInt();
								//testa se houve entrada invalida pra stacks
								while (stacks < 0 && stacks > 20){
									System.out.println("Entrada invalida. Stacks estao validos entre 0 e 20.");
									while (!in.hasNextInt()) in.next();
									stacks = in.nextInt();
								}
							}

						//executa o metodo para o item escolhido
						khazix.swordOfTheOccult(stacks);
						stacks = 0;
						System.out.println("Sword of the Occult adicionada(o)");
						break;
						case(2):
							khazix.bfSword();
						System.out.println("B. F. Sword adicionada(o)");
						break;
						case(3):
							khazix.theBloodthirster();
						System.out.println("The Bloodthirster adicionado");
						break;
						case(4):
							//tratar passiva unica
							if (countBC == 0){
								khazix.theBlackCleaver(countBC);
								countBC += 1;
							}
							else{
								khazix.theBlackCleaver(countBC);
							}

						System.out.println("The Black Cleaver adicionado");
						break;
						case(5):
							//tratar passiva unica
							if (countBRK == 0){
								khazix.bladeOfTheRuinedKing(countBRK);
								countBRK += 1;
							}
							else{
								khazix.bladeOfTheRuinedKing(countBRK);
							}

						System.out.println("Blade Of The Ruined King adicionado.");
						break;
						case(6):
							//tratar passiva unica
							if (countTB == 0){
								khazix.theBrutalizer(countTB);
								countTB += 1;
							}
							else{
								khazix.theBrutalizer(countTB);
							}

						System.out.println("The Brutalizar adicionado");
						}
					}
					
					//Rengar ataca!
					System.out.println("Digite agora quantas vezes Rengar vai atacar:");
					while (!in.hasNextInt()) in.next();
					attacks = in.nextInt();
					//impendindo entradas invalidas
					while (attacks <= 0){
						System.out.println("Entrada invalida. khazix deve atacar pelo menos uma vez. Tente novamente:");
						while (!in.hasNextInt()) in.next();
						attacks = in.nextInt();
					}
					System.out.println("Digite qual(is) ataques ele vai utilizar: " + 
							"\n1) Ataque básico" + "\n2) Savagery" + "\n3) Empowered Savagery" + "\n4) Bola Strike");
					// o for pede os ataques desejados até a condição seja zerada
					for(int i = attacks; i > 0 ; i--){
						
						while (!in.hasNextInt()) in.next();
						choiceAttack = in.nextInt();
						//impedindo entradas invalidas
						while(choiceAttack <=0 && choiceAttack > 4){
							System.out.println("Entrada invalida. Tente novamente");
							while (!in.hasNextInt()) in.next();
							choiceAttack = in.nextInt();
						}
						
						switch(choiceAttack){
						case(1):
							int a = 0;
							if(isStacks30){
								a = 1;
							}
							rengar.basicAttack(a);
						damage = rengar.battleRengar();
						result += damage;
						System.out.println("O dano causado por Ataque Básico foi de " + 
								damage + " PV no Kha'Zix");
						
						break;
						case(2):
							rengar.savagery();
						damage = rengar.battleRengar();
						result += damage;
						System.out.println("O dano causado por Savagery foi de " + 
						damage + " PV no Kha'Zix");
						
						break;
						case(3):
							rengar.empoweredSavagery();
						damage = rengar.battleRengar();
						result += damage;
						System.out.println("O dano causado por Empowered Savagery foi de " + 
						damage + " PV no Kha'Zix");
						
						break;
						case(4):
							rengar.bolaStrike();
						damage = rengar.battleRengar();
						result += damage;
						System.out.println("O dano causado por Bola Strike foi de " + 
						damage + " PV no Kha'Zix");
					
						break;
						
						
						
						}
						
			
						
					}
					
					lifeCha = khazix.getLifeKhazix();
					lifeResult = lifeCha - result;
					if(result < 0 || lifeResult < 0){
						lifeResult = 0;
					}
					System.out.println("O dano total causado pelo Rengar no Kha'Zix foi de " + result + 	
							", resultando num restante de " + lifeResult + " de vida no Kha'Zix");
					lifeCha = 0;
					lifeResult = 0;
					result = 0;
					choiceAttack = 0;
					
					
					
					
				}


				







			}






		}while (loop == true);

		System.out.println("Até a próxima invocador.");


		in.close();
	}

}
