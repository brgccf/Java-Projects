package client;

import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import streams.Reader;
import streams.Writer;

public class MainClient implements Runnable {

	private static String host;
	private static int port;
	private JTextField textField;
	private JTextArea messageLabel;
	private Writer write;
	private JToolBar toolBar;
	public MainClient(String host, int port, JTextField textField, JTextArea messageLabel, JToolBar toolBar)
	{
		this.toolBar = toolBar;
		this.host = host;
		this.port = port;
		this.messageLabel = messageLabel;
		this.textField = textField;

	}
	//host � o ip destino
	public static String getHost() {
		return host;
	}

	public static int getPort() {
		return port;
	}
	
	public Writer getWriter()
	{
		return this.write;
	}

	public void run() {

		try{
			System.out.println("host = " + host + " port = " + port);
			Socket client = new Socket(host, port);
			Reader read = new Reader(client, this.messageLabel);
			write = new Writer(client, this.textField);
			Thread readth = new Thread(read);
			Thread send = new Thread(write);
			readth.start();
			send.start();
		}
		catch(Exception e){
			System.out.println("Erro main cliente: " + e.getMessage());
		}

		
	}

}
