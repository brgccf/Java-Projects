package brgccf.q1;
import java.util.Scanner;
public class HorarioJogo {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int H1, M1, H2, M2;
		int HORA, MINUTO;
		System.out.println("Digite o horário: ");
		H1 = in.nextInt(); M1 = in.nextInt();
		H2 = in.nextInt(); M2 = in.nextInt();
		//checagem se o usuario colocou numeros negativos:
		if (H1 < 0 || H2 < 0 || M1 < 0 || M2 < 0){
			System.out.println("Horario invalido. ");
		}
		HORA = (H2 - H1);
		MINUTO = (M2 - M1);
		//programa propriamente dito:
		if (HORA <= 0){
			HORA += 24;
		}
		else if (MINUTO <= 0){
			MINUTO += 60;
			HORA -= 1;
		}
		System.out.println("O JOGO DUROU " + HORA + " HORA(S) E " + MINUTO + " MINUTO(S)");
		
		in.close();
			
			
	}

}
