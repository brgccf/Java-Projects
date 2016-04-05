package Exercicios;
import java.util.Scanner;
import java.text.NumberFormat;
public class IMC {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		double peso, altura, IMC;
		System.out.println("Digite o seu peso: ");
		peso = in.nextDouble();
		System.out.println("Digite a sua altura (em metros): ");
		altura = in.nextDouble();
		System.out.println("Calculando seu IMC...");
		IMC = ((peso)/(Math.pow(altura, 2)));
		System.out.println(IMC);
		if (IMC <= 18.5){
			System.out.println("Voc� est� abaixo do peso ideal.");}
		else if ((IMC > 18.5) & (IMC <= 25)){
			System.out.println("Voc� est� no peso ideal.");}
		else if ((IMC > 25) & (IMC <= 30)){
			System.out.println("Voc� est� acima do peso ideal.");}
		else{
			System.out.println("Voc� est� obeso. Procure um m�dico.");}
		
			
		}
	}
