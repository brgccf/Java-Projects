package Exercicio1;
import java.util.Scanner;
public class TestaAluno {
	public static void main (String [] args){
		Scanner in = new Scanner (System.in);
		Scanner ler = new Scanner (System.in);
		String cpf, nome, nomecurso;
		int idade;
		System.out.println("Digite seu nome: ");
		nome = ler.nextLine();
		System.out.println("Digite seu CPF: ");
		cpf = ler.nextLine();
		System.out.println("Digite sua idade: ");
		idade = in.nextInt();
		System.out.println("Digite seu curso: ");
		nomecurso = ler.nextLine();
		Curso curso = new Curso ("123", nomecurso);
		Aluno a = new Aluno (nome, cpf, idade, curso);
		System.out.println("Dados do aluno: " + "\nNome: " +
		a.getNome());
		System.out.println("CPF: " + a.getCpf());
		System.out.println("idade: " + a.getIdade());
		System.out.println("Curso: " + a.getCurso().getNomeCurso());
		
		System.out.println("Digite novo CPF: ");
		a.setCpf(ler.nextLine());
		System.out.println("Digite nova idade: ");
		a.setIdade(in.nextInt());
		System.out.println("Digite novo curso: ");
		curso = new Curso ("321", ler.nextLine());
		a.setCurso(curso);
		
		
		System.out.println("Dados do aluno: " + "\nNome: ");
		a.getNome();
		System.out.println("CPF: " + a.getCpf());
		System.out.println("Idade: " + a.getIdade());
		System.out.println("Curso: " + a.getCurso().getNomeCurso());
	}
}
