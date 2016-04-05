package Exercicios;
import java.util.Scanner;
public class TipoTriângulo {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		int x, y, z;
		System.out.println("AVISO: Este programa somente aceita valores inteiros.");
		System.out.println("Digite a base: ");
		x = in.nextInt();
		System.out.println("Digite o lado 1: ");
		y = in.nextInt();
		System.out.println("Digite o lado 2: ");
		z = in.nextInt();
		if ((x == y) & (y == z)){
			System.out.println("Triângulo Equilátero.");}
		else if ((y == z) & (y != x)){
			System.out.println("Triângulo Isósceles.");}
		else{
			System.out.println("Triângulo Escaleno.");}
		
			
		}
	}

