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
			System.out.println("1� Quadrante. ");}
		else if ((x < 0) & (y > 0)){
			System.out.println("2� Quadrante. ");}
		else if ((x < 0) & (y < 0)){
			System.out.println("3� Quadrante. ");}
		else if ((x > 0) & (y < 0)){
			System.out.println("4� Quadrante. ");}
		else if ((x == 0) & (y == 0)){
			System.out.println("Est� na origem. ");}
		else if ((x == 0)){
			System.out.println("Est� no eixo Y.");}
		else if ((y == 0)){
			System.out.println("Est� no eixo X.");}
		
		}
}
	
