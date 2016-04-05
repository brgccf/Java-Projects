package Exercicios;
import java.util.Scanner;
import java.text.NumberFormat;
public class Quadrantes {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(1);
		double x, y;
		System.out.println("Digite a abcissa: ");
		x = in.nextDouble();
		System.out.println("Digite a ordenada: ");
		y = in.nextDouble();
		if ((x > 0) & (y > 0)){
			System.out.println("1º Quadrante. ");}
		else if ((x < 0) & (y > 0)){
			System.out.println("2º Quadrante. ");}
		else if ((x < 0) & (y < 0)){
			System.out.println("3º Quadrante. ");}
		else if ((x > 0) & (y < 0)){
			System.out.println("4º Quadrante. ");}
		else if ((x == 0) & (y == 0)){
			System.out.println("Está na origem. ");}
		else if ((x == 0)){
			System.out.println("Está no eixo Y.");}
		else if ((y == 0)){
			System.out.println("Está no eixo X.");}
		
		}
}
	
