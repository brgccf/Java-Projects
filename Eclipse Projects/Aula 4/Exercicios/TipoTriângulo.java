package Exercicios;
import java.util.Scanner;
public class TipoTri�ngulo {
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
			System.out.println("Tri�ngulo Equil�tero.");}
		else if ((y == z) & (y != x)){
			System.out.println("Tri�ngulo Is�sceles.");}
		else{
			System.out.println("Tri�ngulo Escaleno.");}
		
			
		}
	}

