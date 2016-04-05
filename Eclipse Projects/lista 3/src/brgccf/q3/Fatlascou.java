package brgccf.q3;

public class Fatlascou {
	//f(n) = (n + Ei->n) * f(n - 1)
	
	//metodo recursivo
	public double fatlascou (double value){
		
		double answer = 0;
		
		int plus = 0;
		if(value == 0){
			answer = 1;
		}
		
		else{
			for(int i = 0; i <= value; i++){
				plus += i;
			}
			
			answer = (value + plus) * fatlascou(value - 1);
			
		}
		
		return answer;
	}

}
