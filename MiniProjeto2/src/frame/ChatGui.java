package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.JobAttributes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.metal.MetalToggleButtonUI;

import client.MainClient;
import server.MainServer;

import javax.swing.UIManager;
import java.awt.Panel;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class ChatGui extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIP;
	private JTextField textField;
	private MainServer server;
	private MainClient client;
	private Thread thServer;
	private Thread thClient;
	private int serverPort;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatGui frame = new ChatGui();
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
	public ChatGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel IPpanel = new JPanel();
		IPpanel.setBorder(new TitledBorder(null, "IP", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		IPpanel.setToolTipText("");
		
		IPpanel.setBounds(415, 31, 131, 66);
		contentPane.add(IPpanel);
		
		JLabel lblLblmsg = new JLabel("lblMsg");
		lblLblmsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblLblmsg.setForeground(Color.BLACK);
		lblLblmsg.setBackground(Color.BLACK);
		lblLblmsg.setBounds(10, 108, 536, 158);
		contentPane.add(lblLblmsg);
		lblLblmsg.setText("");
		
		textFieldIP = new JTextField();
		IPpanel.add(textFieldIP);
		textFieldIP.setText("0.0.0.0");
		textFieldIP.setToolTipText("Digite o IP...");
		textFieldIP.setColumns(10);
		
		JLabel txtFieldLabel = new JLabel("Text Field");
		txtFieldLabel.setVerticalAlignment(SwingConstants.TOP);
		txtFieldLabel.setBounds(10, 11, 179, 96);
		contentPane.add(txtFieldLabel);
		
		textField = new JTextField();
		txtFieldLabel.setLabelFor(textField);
		textField.setBounds(10, 31, 170, 66);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = textField.getText();
				
			}
		});
		btnSend.setBounds(190, 31, 67, 66);
		contentPane.add(btnSend);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent k) {
				String ip = textFieldIP.getText();
				try
				{
					serverPort = Integer.parseInt(JOptionPane.showInputDialog("Digite o n�mero da porta do servidor:"));
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Entrada inv�lida! Tente novamente.");
				}
				server = new MainServer(serverPort, textField);
				thServer = new Thread(server);
			}
		});
		btnConnect.setBounds(307, 37, 98, 23);
		contentPane.add(btnConnect);
		
		JButton btnDisconnect = new JButton("Disconnect");
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnDisconnect.setBounds(307, 71, 98, 23);
		contentPane.add(btnDisconnect);
		
		JPanel panelMsg = new JPanel();
		panelMsg.setBorder(new TitledBorder(null, "Messages", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMsg.setBackground(Color.WHITE);
		panelMsg.setBounds(10, 108, 536, 158);
		contentPane.add(panelMsg);
		
		JButton btnOpenConnection = new JButton("Open Connection");
		btnOpenConnection.setBounds(415, 7, 131, 23);
		contentPane.add(btnOpenConnection);
		
		
	}
}