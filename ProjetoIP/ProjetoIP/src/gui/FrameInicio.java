package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class FrameInicio extends JFrame {

	private JPanel contentPane;
	private JTextField txtDigiteNome;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameInicio frame = new FrameInicio();
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
	public FrameInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMsgBoasVindas = new JLabel("Bem vindo! Digite o nome de sua locadora:");
		lblMsgBoasVindas.setBounds(5, 5, 424, 26);
		lblMsgBoasVindas.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsgBoasVindas.setToolTipText("");
		lblMsgBoasVindas.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		contentPane.add(lblMsgBoasVindas);

		txtDigiteNome = new JTextField();
		txtDigiteNome.setToolTipText("");
		txtDigiteNome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtDigiteNome.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigiteNome.setBounds(94, 81, 214, 56);
		contentPane.add(txtDigiteNome);
		txtDigiteNome.setColumns(10);

		JButton btnOk = new JButton("OK\r\n");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOk.setAction(action);
		btnOk.setBounds(94, 164, 214, 51);
		contentPane.add(btnOk);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "OK");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			abrirFrame();
		}
	}

	private void abrirFrame(){
		//lendo texto digitado
		String nome = txtDigiteNome.getText();
		//criando objeto com o nome digitado
		JOptionPane.showMessageDialog(this, "Locadora " + nome + " Definida com sucesso!");
		FrameLocadora locadora = new FrameLocadora (nome);
		
		locadora.setVisible(true);
	}


}
