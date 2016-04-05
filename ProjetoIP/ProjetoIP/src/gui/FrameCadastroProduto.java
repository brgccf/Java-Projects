package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

import excecoes.ProdutoExistenteException;
import excecoes.RepositorioException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import locadora.BluRay;
import locadora.DVD;
import locadora.Jogos;

public class FrameCadastroProduto extends JFrame {

	private JPanel contentPane;

	private static Locadora fachada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					FrameCadastroProduto frame = new FrameCadastroProduto(fachada);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameCadastroProduto(Locadora locadora) {
		this.fachada = locadora;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Escolha um Produto para cadastrar:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 46);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("DVD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrarDVD();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(20, 68, 361, 39);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Blu-Ray");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrarBluRay();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(20, 118, 361, 39);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Jogo");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrarJogo();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(20, 168, 361, 39);
		contentPane.add(btnNewButton_2);
	}

	public void cadastrarDVD(){

		boolean erro = false;
		String nome = "";
		String descricao = "";
		int duracao = 0;
		double preco = 0;

		try{
			nome = JOptionPane.showInputDialog(this, "Digite o nome do filme: ");
			descricao = JOptionPane.showInputDialog(this, "Digite a descrição (Sinopse):");
			preco = Double.parseDouble(JOptionPane.showInputDialog(this, "Digite o preço do aluguel deste filme: "));
			duracao = (int) Double.parseDouble(JOptionPane.showInputDialog(this, "Digite a duração: "));
		}
		catch(NumberFormatException e){
			erro = true;
			JOptionPane.showMessageDialog(this, "Erro! Você não digitou um valor válido.");
		}
		if(!erro){
			DVD dvd = new DVD (nome, descricao, preco, duracao);
			try {
				this.fachada.cadastrarProduto(dvd);
				JOptionPane.showMessageDialog(this, "DVD Cadastrado com sucesso!");
			} catch (ProdutoExistenteException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			} catch (RepositorioException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
		
		this.setVisible(false);

	}

	public void cadastrarBluRay(){
		boolean erro = false;
		String nome = "";
		String descricao = "";
		int duracao = 0;
		double preco = 0;

		try{
			nome = JOptionPane.showInputDialog(this, "Digite o nome do produto: ");
			descricao = JOptionPane.showInputDialog(this, "Digite a descrição (Sinopse):");
			preco = Double.parseDouble(JOptionPane.showInputDialog(this, "Digite o preço do aluguel deste produto: "));
			duracao = (int) Double.parseDouble(JOptionPane.showInputDialog(this, "Digite a duração: "));
		}
		catch(NumberFormatException e){
			erro = true;
			JOptionPane.showMessageDialog(this, "Erro! Você não digitou um valor válido.");
		}

		if(!erro){
			BluRay bluray = new BluRay (nome, descricao, preco, duracao);
			try {
				this.fachada.cadastrarProduto(bluray);
				JOptionPane.showMessageDialog(this, "Blu-Ray Cadastrado com sucesso!");
			} catch (ProdutoExistenteException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			} catch (RepositorioException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}

		}
		
		this.setVisible(false);
	}

	public void cadastrarJogo(){
		boolean erro = false;
		String nome = "";
		String descricao = "";
		double preco = 0;
		int faixaEtaria = 0;

		try{
			nome = JOptionPane.showInputDialog(this, "Digite o nome do jogo: ");
			descricao = JOptionPane.showInputDialog(this, "Digite a descrição (Sinopse):");
			preco = Double.parseDouble(JOptionPane.showInputDialog(this, "Digite o preço do aluguel deste jogo: "));
			faixaEtaria = (int) Double.parseDouble(JOptionPane.showInputDialog(this, "Digite a faixa etária: "));
		}
		catch(NumberFormatException e){
			erro = true;
			JOptionPane.showMessageDialog(this, "Erro! Você não digitou um valor válido.");
		}

		if(!erro){
			//verificando se a faixa etaria esta dentro dos limites:
			while(faixaEtaria > 18){
				try{
					faixaEtaria = (int) Double.parseDouble(JOptionPane.showInputDialog(this, "Erro! Faixa etária inválida. (Máx: 18 anos). Tente novamente:"));
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(this, "Erro! Você não digitou um valor válido.");
					erro = true;
				}
			}
			if(!erro){
				Jogos jogo = new Jogos(nome, descricao, preco, faixaEtaria);
				try {
					this.fachada.cadastrarProduto(jogo);
					JOptionPane.showMessageDialog(this, "Jogo Cadastrado com sucesso!");
				} catch (ProdutoExistenteException e) {
					JOptionPane.showMessageDialog(this, e.getMessage());
				} catch (RepositorioException e) {
					JOptionPane.showMessageDialog(this, e.getMessage());
				}


			}
		}
		this.setVisible(false);
	}

}
