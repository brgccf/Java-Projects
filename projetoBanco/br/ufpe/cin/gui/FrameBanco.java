package br.ufpe.cin.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import br.ufpe.cin.banco.Banco;
import br.ufpe.cin.banco.ContaAbstrata;
import br.ufpe.cin.banco.ContaJaCadastradaException;
import br.ufpe.cin.banco.Poupanca;
import br.ufpe.cin.banco.SaldoInsuficienteException;
import br.ufpe.cin.dados.ContaNaoEncontradaException;
import br.ufpe.cin.dados.RepositorioContas;
import br.ufpe.cin.dados.RepositorioContasArray;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameBanco extends JFrame {

		
	private Banco fachada;
	
	private JPanel contentPane;
	private JTextField tf_numero;
	private JTextField tf_valor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameBanco frame = new FrameBanco();
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
	public FrameBanco() {
		
		RepositorioContas repositorio = new RepositorioContasArray(100);
		this.fachada = new Banco(repositorio);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_numero = new JLabel("Numero");
		lbl_numero.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lbl_numero.setBounds(32, 15, 87, 38);
		contentPane.add(lbl_numero);
		
		tf_numero = new JTextField();
		tf_numero.setBounds(147, 20, 183, 29);
		contentPane.add(tf_numero);
		tf_numero.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblValor.setBounds(46, 93, 73, 38);
		contentPane.add(lblValor);
		
		tf_valor = new JTextField();
		tf_valor.setBounds(161, 98, 169, 29);
		contentPane.add(tf_valor);
		tf_valor.setColumns(10);
		
		JButton btnCreditar = new JButton("Creditar");
		btnCreditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				creditar();
			}
		});
		btnCreditar.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnCreditar.setBounds(32, 149, 105, 38);
		contentPane.add(btnCreditar);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrar();
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnNewButton.setBounds(147, 149, 103, 38);
		contentPane.add(btnNewButton);
		
		JButton btnSaldo = new JButton("Saldo");
		btnSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saldo();
			}
		});
		btnSaldo.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnSaldo.setBounds(260, 149, 105, 38);
		contentPane.add(btnSaldo);
	}
	private void creditar(){
		try{
		String numero = tf_numero.getText();
		String v = tf_valor.getText();
		double valor = Double.parseDouble(v);
		this.fachada.creditar(numero, valor);
		JOptionPane.showMessageDialog(this, "Crédito realizado com sucesso");
		}
		catch (ContaNaoEncontradaException e){
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "O valor deve ser um numero real!");
		}
		
	}
	private void cadastrar(){
		try{
			String numero = tf_numero.getText();
			ContaAbstrata conta = new Poupanca(numero);
			fachada.cadastrar(conta);
			JOptionPane.showMessageDialog(this, "Conta cadastrada com sucesso!");
		}
		catch(ContaJaCadastradaException e){
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	private void saldo(){
		try{
			String numero = tf_numero.getText();
			double saldo = fachada.getSaldo(numero);
			JOptionPane.showMessageDialog(this, "O saldo da conta " + numero + " é " + saldo);
		}
		catch(ContaNaoEncontradaException e){
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
	}
	
}
