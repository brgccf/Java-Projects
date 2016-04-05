package Exercicios;
import java.util.Scanner;
import java.text.NumberFormat;
public class Notas {
	public static void main (String [] args) {
		Scanner in = new Scanner (System.in);
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(1);
		double nota;
		boolean a;
		System.out.println("Digite sua nota: ");
		nota = in.nextDouble();
		if ((nota <= 0) || (nota >= 10)){
			a = false;}
		else a = true;
		while (a == false){
		if ((nota < 0) || (nota > 10)){
			System.out.println("Nota Inválida. Tente novamente.");
			System.out.println("Digite sua nota: ");
			nota = in.nextDouble();}
			else if ((nota >= 0) || (nota <=10)){
			a = true;}}
		if ((nota >= 8.5) & (nota <= 10.0)){
			System.out.println("A");}
		else if ((nota >= 7.0) & (nota < 8.5)){
			System.out.println("B");}
		else if ((nota >= 5.0) & (nota < 7.0)){
			System.out.println("C");}
		else if ((nota >= 3.0) & (nota < 5.0)){
			System.out.println("D");}
		else if ((nota < 3.0)){
			System.out.println("E");}
		System.out.println("Fim de programa.");}
		}

