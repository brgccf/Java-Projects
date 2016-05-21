package frame;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class FileFrame extends JFrame {
	private TCPServer server;
	private TCPClient client;
	private Thread thServer;
	private Thread thClient;
	private String path = null;
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
		progressBar.setBounds(48, 186, 323, 37);
		contentPane.add(progressBar);
		
		JLabel lblRTT = new JLabel("Waiting for File Choose");
		lblRTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblRTT.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 13));
		lblRTT.setBounds(48, 131, 323, 44);
		contentPane.add(lblRTT);
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser choose = new JFileChooser();
				choose.showOpenDialog(contentPane);
				//String path = choose.getSelectedFile().getAbsolutePath();
				path = choose.getSelectedFile().getAbsolutePath();
				server = new TCPServer(path, lblRTT);
				lblRTT.setText("Way choosen: " + path);
			}
		});
		btnSearch.setBounds(157, 55, 99, 37);
		contentPane.add(btnSearch);
		
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(path == null) JOptionPane.showMessageDialog(null, "Escolha um caminho antes de iniciar!");
				else
				{
					JOptionPane.showMessageDialog(null, "escolha o caminho para salvar seu arquivo");
					JFileChooser chooseClient = new JFileChooser();
					chooseClient.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					chooseClient.showOpenDialog(contentPane);
					path = chooseClient.getCurrentDirectory().getAbsolutePath();
					System.out.println("Path = " + path);
					client = new TCPClient(path);
					thClient = new Thread(client);
					thServer = new Thread(server);
					thServer.start();
					thClient.start();
				}
			}
		});
		btnStart.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnStart.setBounds(48, 55, 99, 37);
		contentPane.add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnStop.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnStop.setBounds(272, 55, 99, 37);
		contentPane.add(btnStop);
	}
}