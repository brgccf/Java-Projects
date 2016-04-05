package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JToggleButton;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

import java.awt.Dimension;

import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

import excecoes.ClienteExistenteException;
import excecoes.ClienteNaoExistenteException;
import excecoes.ProdutoAlugadoException;
import excecoes.ProdutoExistenteException;
import excecoes.ProdutoNaoExistenteException;
import excecoes.RepositorioException;

import java.awt.Choice;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.JobAttributes;
import java.awt.Label;
import java.awt.Scrollbar;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;

import locadora.Cliente;

public class FrameLocadora extends JFrame {

	private static String nome;

	private JPanel contentPane;

	private Locadora fachada;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLocadora frame = new FrameLocadora(nome);
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
	public FrameLocadora(String nome) {
		try {
			this.fachada = new Locadora (nome);
		} catch (RepositorioException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}



		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblEscolherFuncao = new JLabel("Escolha uma fun\u00E7\u00E3o: ");
		lblEscolherFuncao.setBounds(10, 11, 764, 53);
		lblEscolherFuncao.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscolherFuncao.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblEscolherFuncao);

		JButton btnCadastrarCliente = new JButton("Cadastrar Cliente\r\n");
		btnCadastrarCliente.setAction(action);
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrarCliente();
			}
		});
		btnCadastrarCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrarCliente.setForeground(Color.DARK_GRAY);
		btnCadastrarCliente.setBounds(41, 75, 247, 88);
		contentPane.add(btnCadastrarCliente);

		JButton btnCadastrarProduto = new JButton("Cadastrar Produto");
		btnCadastrarProduto.setAction(action_1);
		btnCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarProduto();
			}
		});
		btnCadastrarProduto.setForeground(Color.DARK_GRAY);
		btnCadastrarProduto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrarProduto.setBounds(41, 194, 247, 88);
		contentPane.add(btnCadastrarProduto);

		JButton btnAlugaProduto = new JButton("Alugar Produto");
		btnAlugaProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alugarProduto();
			}
		});
		btnAlugaProduto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAlugaProduto.setBounds(451, 75, 247, 88);
		contentPane.add(btnAlugaProduto);

		JButton btnRemoveProduto = new JButton("Remover Produto\r\n");
		btnRemoveProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerProdutoCatalogo();
			}
		});
		btnRemoveProduto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRemoveProduto.setBounds(250, 313, 247, 88);
		contentPane.add(btnRemoveProduto);

		JButton btnDevolverProduto = new JButton("Devolver Produto");
		btnDevolverProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				devolverProduto();
			}
		});
		btnDevolverProduto.setAction(action_2);
		btnDevolverProduto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDevolverProduto.setBounds(451, 194, 247, 88);
		contentPane.add(btnDevolverProduto);

		JButton btnNewButton = new JButton("Relat\u00F3rios");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//falta implementar metodo para mostrar relatorios
				//relatorio();
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btnNewButton.setBounds(632, 430, 152, 32);
		contentPane.add(btnNewButton);



	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	private void cadastrarCliente(){
		String nomeCliente = JOptionPane.showInputDialog(this, "Digite o nome");
		String cpfCliente = JOptionPane.showInputDialog(this, "Digite o CPF (sem pontos ou hífens)");
		//verificando se o cpf está no tamanho certo
		while(cpfCliente.length() != 11){
			cpfCliente = JOptionPane.showInputDialog(this, "CPF inválido! Tente novamente. Digite o CPF:");
		}
		//verificando se so foram digitados numeros
		boolean invalido = false;
		for (int i = 0; i < cpfCliente.length(); i++) {
			if(cpfCliente.charAt(i) < 48 || cpfCliente.charAt(i) > 57){
				JOptionPane.showMessageDialog(this, "CPF Inválido!");
				invalido = true;
			}
		}
		if(!invalido){
			Cliente cliente = null;
			try {
				cliente = new Cliente (nomeCliente, cpfCliente);
			} catch (RepositorioException e) {
				JOptionPane.showInputDialog(this, e.getMessage());
			}
			try {
				this.fachada.cadastrarCliente(cliente);
				JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
			} catch (ClienteExistenteException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			} catch (RepositorioException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
	}

	private void alugarProduto() {
		String nomeProduto = JOptionPane.showInputDialog(this, "Digite o nome do produto");
		String cpfCliente = JOptionPane.showInputDialog(this, "Digite o CPF do cliente (sem pontos ou hífens)");
		//verificando se o cpf está no tamanho certo
		while(cpfCliente.length() != 11){
			cpfCliente = JOptionPane.showInputDialog(this, "CPF inválido! Tente novamente. Digite o CPF:");
		}
		//verificando se so foram digitados numeros
		boolean invalido = false;
		for (int i = 0; i < cpfCliente.length(); i++) {
			if(cpfCliente.charAt(i) < 48 || cpfCliente.charAt(i) > 57){
				JOptionPane.showMessageDialog(this, "CPF Inválido!");
				invalido = true;
			}
		}
		if(!invalido){
			try {
				this.fachada.alugarProduto(cpfCliente, nomeProduto);
				JOptionPane.showMessageDialog(this, "Produto alugado com sucesso!");
			} catch (ProdutoNaoExistenteException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			} catch (ClienteNaoExistenteException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			} catch (ProdutoExistenteException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			} catch (RepositorioException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}		
		}
	}

	private void devolverProduto(){
		String nomeProduto = JOptionPane.showInputDialog(this, "Digite o nome do produto devolvido:");
		String cpfCliente = JOptionPane.showInputDialog(this, "Digite o CPF do cliente (sem pontos ou hífens)");
		//verificando se o cpf está correto:
		while(cpfCliente.length() != 11){
			cpfCliente = JOptionPane.showInputDialog(this, "CPF inválido! Tente novamente. Digite o CPF:");
		}
		//verificando se so foram digitados numeros
		boolean invalido = false;
		for (int i = 0; i < cpfCliente.length(); i++) {
			if(cpfCliente.charAt(i) < 48 || cpfCliente.charAt(i) > 57){
				JOptionPane.showMessageDialog(this, "CPF Inválido!");
				invalido = true;
			}
		}
		if(!invalido){
			double multa = 0;
			try{
				multa = this.fachada.devolucaoProduto(cpfCliente, nomeProduto);
				JOptionPane.showMessageDialog(this, "Produto devolvido com sucesso! Multa de R$" + multa);
			}
			catch(ProdutoNaoExistenteException e){
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
			catch(ClienteNaoExistenteException e){
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
			catch(RepositorioException e){
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
			
		}
	}

	private void removerProdutoCatalogo() {
		String nomeProduto = JOptionPane.showInputDialog(this, "Digite o nome do produto");
		try {
			this.fachada.removerProdutoCatalogo(nomeProduto);
			JOptionPane.showMessageDialog(this, "Produto removido com sucesso!");
		} catch (ProdutoNaoExistenteException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		} catch (RepositorioException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		} catch (ProdutoAlugadoException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	private void cadastrarProduto(){
		//abre um novo frame para escolha do produto, para assim poder cadastrar
		FrameCadastroProduto cadastroProduto = new FrameCadastroProduto(this.fachada);
		cadastroProduto.setVisible(true);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Cadastrar Cliente");
			putValue(SHORT_DESCRIPTION, "Cadastre um cliente em sua Locadora");
		}
		public void actionPerformed(ActionEvent e) {

		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Cadastrar Produto");
			putValue(SHORT_DESCRIPTION, "Cadastre um produto em sua locadora");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Devolver Produto");
			putValue(SHORT_DESCRIPTION, "Disponibilize um produto para aluguel");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
