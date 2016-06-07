package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
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
import streams.Writer;

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
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToolBar;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class ChatGui extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIP;
	private JTextField textField;
	private MainServer server;
	private MainClient client;
	private Thread thServer = null;
	private Thread thClient = null;
	private int serverPort;
	private Writer writeMsg;
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Sent & Received", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(184, 58, 113, 49);
		contentPane.add(panel);
		panel.setLayout(null);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(6, 16, 97, 26);
		panel.add(toolBar);
		
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
				toolBar.setBackground(Color.RED);
			}
		});
		IPpanel.add(textFieldIP);
		textFieldIP.setText("0.0.0.0");
		textFieldIP.setToolTipText("Digite o IP...");
		textFieldIP.setColumns(10);
		
		JLabel txtFieldLabel = new JLabel("Text Field");
		txtFieldLabel.setVerticalAlignment(SwingConstants.TOP);
		txtFieldLabel.setBounds(10, 11, 160, 96);
		contentPane.add(txtFieldLabel);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key == KeyEvent.VK_ENTER)
				{
					String message = textField.getText();
					if(thServer != null)
					{
						server.getWriter().setClicked(true);;
					}
					else if(thClient != null)
					{
						client.getWriter().setClicked(true);
					}
					else JOptionPane.showMessageDialog(null, "No connections opened!");
					server.getWriter().setClicked(false);
					client.getWriter().setClicked(false);
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
		
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = textField.getText();
				if(thServer != null)
				{
					server.getWriter().setClicked(true);;
				}
				else if(thClient != null)
				{
					client.getWriter().setClicked(true);
				}
				else JOptionPane.showMessageDialog(null, "No connections opened!");
				server.getWriter().setClicked(false);
				client.getWriter().setClicked(false);
				textField.setText("");
			}
		});
		btnSend.setBounds(190, 31, 67, 23);
		contentPane.add(btnSend);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent k) {
				
				String ip = textFieldIP.getText();
				try
				{
					
					serverPort = Integer.parseInt(JOptionPane.showInputDialog("Digite o n�mero da porta do servidor:"));
				}
				catch(NumberFormatException z){
					JOptionPane.showMessageDialog(null, "Entrada inv�lida! Tente novamente.");
				}
				client = new MainClient(ip, serverPort, textField, textArea, toolBar);
				thClient = new Thread(client);
				thClient.start();
				JOptionPane.showMessageDialog(null, "Connected to server " + ip + " at port " + serverPort);
			}
		});
		btnConnect.setBounds(307, 37, 98, 23);
		contentPane.add(btnConnect);
		
		JButton btnDisconnect = new JButton("Disconnect");
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thClient.interrupt();
				thServer.interrupt();
				
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
		btnOpenConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					serverPort = Integer.parseInt(JOptionPane.showInputDialog("Digite o n�mero da porta do servidor:"));
				}
				catch(NumberFormatException k){
					JOptionPane.showMessageDialog(null, "Entrada inv�lida! Tente novamente.");
				}
				server = new MainServer(serverPort, textField, textArea, toolBar);
				thServer = new Thread(server);
				thServer.start();
				JOptionPane.showMessageDialog(null, "Connection opened at port " + serverPort);
			}
		});
		btnOpenConnection.setBounds(415, 7, 131, 23);
		contentPane.add(btnOpenConnection);
		
		
		
	}
}
