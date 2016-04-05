import java.util.Scanner;
public class Questao {
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Digite a primeira String; ");
		String primeiraStr = in.nextLine();
		primeiraStr = convert(primeiraStr);
		System.out.println("Digite a sua segunda String: ");
		String segundaStr = in.nextLine();
		segundaStr = convert(primeiraStr);
		System.out.println("Digite a sua terceira String: ");
		String terceiraStr = in.nextLine();
		terceiraStr = convert(primeiraStr);
		
		in.close();
		}
	
	public static boolean vemAntes(String a, String b){
		int x = Math.min(a.length(), b.length());
		//math.min retorna o menor valor entre dois parametros
		boolean retorno;
		retorno = a.length()<b.length() ? true : false;
		//retorna o primeiro valor caso true, e
		//retorna segundo valor caso falso
		for (int i=0; i < x; i++){
			if(a.charAt(i) > b.charAt(i)){
				retorno = false;
				i = x;
			}
		}
		return retorno;
	}
	
	public static String convert(String entrada){
		String nova = "";
		for (int i=0; i < entrada.length(); i++){
			if(entrada.charAt(i) >= 'A' && entrada.charAt(i) <= 'Z'){
				nova += entrada.charAt(i) + 32;
			}else{
				nova += entrada.charAt(i);
			}
				
		}
		return nova;
		
		
		
		
		
	}

}