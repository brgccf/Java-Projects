package client;

import java.net.Socket;

import javax.swing.JLabel;
import javax.swing.JTextField;

import streams.Reader;
import streams.Writer;

public class MainClient implements Runnable {

	private static String host;
	private static int port;
	private JTextField textField;
	private JLabel messageLabel;
	public MainClient(String host, int port, JTextField textField, JLabel messageLabel)
	{
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

	public void run() {
		try{
			Socket client = new Socket(host, port);
			Reader read = new Reader(client);
			Writer write = new Writer(client, this.textField);
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