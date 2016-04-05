package exercicios;
import java.util.Scanner;
public class Lucas {
	//L(n+1) = L(n) * L(n-1)
	//L(1) = L(0) * L(-1)
	//L(-1) = L(1) / L(0)
	//L(2) = L(1) * L(0)
	
	static long lucas(int n){
		long resposta = 0;
		
		if (n == 0){
			resposta = 2;
		}
		else if (n == 1){
			resposta = 5; 
		}
		else if(n > 1){
			resposta = lucas(n-1)*lucas(n-2);
			
		}
		
		
		return resposta;
	}
	
	public static void main(String [] args){
		Scanner in = new Scanner (System.in);
		System.out.println("Digite n:");
		int n = in.nextInt();
		System.out.println(Lucas.lucas(n));
		
		in.close();
		
		
		
	}

}
