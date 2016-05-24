package frame;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import sockets.TCPClient;
import sockets.TCPServer;
import java.awt.Color;

@SuppressWarnings("serial")
public class FileFrame extends JFrame {
	private TCPServer server;
	private TCPClient client;
	private Thread thServer = null;
	private Thread thClient = null;
	private String path = null;
	private long totalLength = 0;
	private int serverPort;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileFrame frame = new FileFrame();
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
	public FileFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.GREEN);
		progressBar.setBounds(36, 186, 353, 37);
		contentPane.add(progressBar);
		
		JLabel lblRTT = new JLabel("Waiting for File Choose");
		lblRTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblRTT.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblRTT.setBounds(36, 125, 353, 50);
		contentPane.add(lblRTT);

		JLabel lblinfo = new JLabel("Information");
		lblinfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblinfo.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblinfo.setBounds(36, 59, 353, 57);
		contentPane.add(lblinfo);
		
		JButton btnSearch = new JButton("Send File");
		btnSearch.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser choose = new JFileChooser();
				choose.showOpenDialog(contentPane);
				path = choose.getSelectedFile().getAbsolutePath(); //caminho do arquivo a ser baixado
				try
				{
					serverPort = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da porta do servidor:"));
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Entrada inválida! Tente novamente.");
				}
				server = new TCPServer(path, lblinfo, lblRTT, progressBar, serverPort);
				File myFile = server.getFile();
				totalLength = myFile.length();
				lblRTT.setText("File Length = " + totalLength + " bytes");
				thServer = new Thread(server);
				thServer.start();
			}
		});
		btnSearch.setBounds(181, 11, 99, 37);
		contentPane.add(btnSearch);
		
		//C:\Users\brgccf\Desktop\teste
		JButton btnStart = new JButton("Receive File");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "escolha o caminho para salvar seu arquivo");
				JFileChooser chooseClient = new JFileChooser();
				chooseClient.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooseClient.showOpenDialog(contentPane);
				path = chooseClient.getSelectedFile().getAbsolutePath();
				path += '\\';
				System.out.println("Path = " + path);
				int port = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da porta do servidor:"));
				String ip = JOptionPane.showInputDialog(null, "Digite o IP do servidor com o arquivo a ser baixado:");
				client = new TCPClient(path, lblRTT, progressBar, lblinfo, ip, port);
				thClient = new Thread(client);
				thClient.start();	
				
			}
				
		});
		btnStart.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnStart.setBounds(32, 11, 139, 37);
		contentPane.add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(thServer != null || thClient != null)
				{
					if(thClient.isAlive())client.finish();
					if(thServer.isAlive())server.finish();
					JOptionPane.showMessageDialog(null, "Transferencia encerrada.");
				}
				else JOptionPane.showMessageDialog(null, "Não há transferência em execução!");
			}
		});
		btnStop.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnStop.setBounds(290, 11, 99, 37);
		contentPane.add(btnStop);
		
	}
}
