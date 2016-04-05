package brgccf.q3;
import java.util.Scanner;

public class ProgramaFatlascou {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int value;
		//entrada do usuario
		boolean loop = true;
		//loop mantem o programa funcionando até o usuario digitar o fatlascou de 50 (conforme exemplo da questao)
		do{
			System.out.println("Digite um inteiro positivo: ");
			while(!in.hasNextInt()) in.next();
			value = in.nextInt();

			if(value == 50){
				loop = false;
			}

			//tratando entradas invalidas
			if(loop){

				while(value <= 0 || value >= 105){
					System.out.println("Entrada incorreta. Tente novamente:");
					while(!in.hasNextInt()) in.next();
					value = in.nextInt();
					if(value == 50){
						loop = false;
					}
				}
			}



			//criando objeto para executar metodo
			Fatlascou f = new Fatlascou ();
			//executando metodo e imprimindo resultado
			System.out.println("O fatlascou de " + value + " é:");
			System.out.println(f.fatlascou(value));



		}while (loop);

		System.out.println("Fim de programa.");

		in.close();
	}

}
