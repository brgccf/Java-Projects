package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import client.MainClient;
import server.MainServer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/* Bruno Filho - brgccf --> projeto 2 Infra - Comunicação
 * ---- FUNCIONAMENTO DA GUI ----------
 * OPEN CONNECTION: ABRE SOCKET DE CONEXÃO (PAPEL DE SERVIDOR)
 * CONNECT: CONECTA-SE A UM SOCKET DE CONEXÃO JÁ ABERTO PELO IP FORNECIDO NO CAMPO DE DIGITAÇÃO
 * DISCONNECT: DESCONECTA E ENCERRA A CONEXÃO
 */

@SuppressWarnings("serial")
public class ChatGui extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIP;
	private JTextField textField;
	private MainServer server;
	private MainClient client;
	private Thread thServer = null;
	private Thread thClient = null;
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
	
	public void sendMessage(String message)
	{
		
	}
	
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
		
		textFieldIP = new JTextField();
		textFieldIP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textFieldIP.setText("");
			}
		});
		IPpanel.add(textFieldIP);
		textFieldIP.setText("0.0.0.0");
		textFieldIP.setToolTipText("Digite o IP...");
		textFieldIP.setColumns(10);
		
		JLabel txtFieldLabel = new JLabel("Text Field - Enter To Send");
		txtFieldLabel.setVerticalAlignment(SwingConstants.TOP);
		txtFieldLabel.setBounds(10, 11, 170, 96);
		contentPane.add(txtFieldLabel);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				String msg = textField.getText();
				if(key == KeyEvent.VK_ENTER)
				{
					if(thServer != null)
					{
						server.sendMessage(msg);
					}
					else if(thClient != null)
					{
						client.sendMessage(msg);
					}
					else JOptionPane.showMessageDialog(null, "No connections opened!");
					
					textField.setText("");
				}
			}
		});
		txtFieldLabel.setLabelFor(textField);
		textField.setBounds(10, 31, 170, 66);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 125, 514, 141);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent k) {
				
				String ip = textFieldIP.getText();
				try
				{
					serverPort = Integer.parseInt(JOptionPane.showInputDialog("Type the server port:"));
					client = new MainClient(ip, serverPort, textArea);
					thClient = new Thread(client);
					thClient.start();
					JOptionPane.showMessageDialog(null, "Trying to connect to server " + ip + " at port " + serverPort);
				}
				catch(NumberFormatException z){
					JOptionPane.showMessageDialog(null, "Invalid Entry! Please Try Again.");
				}
			}
		});
		btnConnect.setBounds(317, 40, 98, 23);
		contentPane.add(btnConnect);
		
		JButton btnDisconnect = new JButton("Disconnect");
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disconnect();
			}
		});
		btnDisconnect.setBounds(317, 74, 98, 23);
		contentPane.add(btnDisconnect);
		
		JPanel panelMsg = new JPanel();
		panelMsg.setBorder(new TitledBorder(null, "Messages", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMsg.setBackground(Color.WHITE);
		panelMsg.setBounds(10, 108, 536, 158);
		contentPane.add(panelMsg);
		
		JButton btnOpenConnection = new JButton("Open Connection");
		btnOpenConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					serverPort = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da porta do servidor:"));
				}
				catch(NumberFormatException k){
					JOptionPane.showMessageDialog(null, "Entrada inválida! Tente novamente.");
				}
				server = new MainServer(serverPort, textArea);
				thServer = new Thread(server);
				thServer.start();
				JOptionPane.showMessageDialog(null, "Connection opened at port " + serverPort);
			}
		});
		btnOpenConnection.setBounds(183, 31, 131, 66);
		contentPane.add(btnOpenConnection);	
	}
	private void disconnect() {
		if(this.client!=null)client.disconnect();
		if(this.server!=null)server.disconnect();
		JOptionPane.showMessageDialog(null, "Connection closed. End of program.");
		
	}
}
