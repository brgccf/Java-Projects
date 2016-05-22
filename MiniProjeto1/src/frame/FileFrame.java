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
import java.awt.Button;
import java.awt.Color;

public class FileFrame extends JFrame {
	private TCPServer server;
	private TCPClient client;
	private Thread thServer = null;
	private Thread thClient = null;
	private String path = null;
	private String name = null;
	private int totalLength = 0;
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
		progressBar.setBounds(48, 186, 323, 37);
		contentPane.add(progressBar);
		
		JLabel lblRTT = new JLabel("Waiting for File Choose");
		lblRTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblRTT.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblRTT.setBounds(48, 131, 323, 44);
		contentPane.add(lblRTT);

		JLabel lblinfo = new JLabel("Information");
		lblinfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblinfo.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblinfo.setBounds(48, 76, 323, 44);
		contentPane.add(lblinfo);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser choose = new JFileChooser();
				choose.showOpenDialog(contentPane);
				path = choose.getSelectedFile().getAbsolutePath(); //caminho do arquivo a ser baixado
				name = choose.getSelectedFile().getName(); //nome do arquivo a ser transferido
				System.out.println("name = " + name);
				server = new TCPServer(path, lblinfo, name);
				File myFile = server.getFile();
				totalLength = (int)myFile.length();
				lblRTT.setText("File Length = " + totalLength + " bytes");
				thServer = new Thread(server);
				thServer.start();
			}
		});
		btnSearch.setBounds(157, 27, 99, 37);
		contentPane.add(btnSearch);
		
		//C:\Users\brgccf\Desktop\teste
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "escolha o caminho para salvar seu arquivo");
				JFileChooser chooseClient = new JFileChooser();
				chooseClient.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooseClient.showOpenDialog(contentPane);
				path = chooseClient.getSelectedFile().getAbsolutePath();
				path += '\\';
				System.out.println("Path = " + path);
				client = new TCPClient(path, lblRTT, progressBar, totalLength);
				thClient = new Thread(client);
				thClient.start();	
				
			}
				
		});
		btnStart.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnStart.setBounds(48, 27, 99, 37);
		contentPane.add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(thServer != null && thClient != null)
				{
					client.finish();
					server.finish();
					JOptionPane.showMessageDialog(null, "Transferencia encerrada.");
				}
				else JOptionPane.showMessageDialog(null, "N�o h� transfer�ncia em execu��o!");
			}
		});
		btnStop.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnStop.setBounds(272, 27, 99, 37);
		contentPane.add(btnStop);
		
	}
}
