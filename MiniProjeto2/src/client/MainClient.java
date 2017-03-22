package client;

import java.net.Socket;
import javax.swing.JTextArea;

import streams.Reader;
import streams.Writer;

public class MainClient implements Runnable {
	private Reader read;
	private static String host;
	private static int port;
	private JTextArea messageLabel;
	private Socket client;
	@SuppressWarnings("static-access")
	public MainClient(String host, int port, JTextArea messageLabel)
	{
		this.read = null;
		this.host = host;
		this.port = port;
		this.messageLabel = messageLabel;
		this.client = null;
	}
	//host é o ip destino
	
	public void disconnect()
	{
		try
		{
			if(this.client!=null)this.client.close();
		}catch(Exception e)
		{
			System.out.println("exception disconnecting: " + e.getMessage());
		}
		
		this.read.disconnect();
		Thread.currentThread().interrupt();
	}

	public void sendMessage(String msg)
	{
		if(this.client == null)
		{
			System.out.println("Socket closed!");
			return;
		}
		Writer write = new Writer(this.client, msg, this.messageLabel);
		Thread wr = new Thread(write);
		wr.start();
	}
	
	public void run() {
		try{
			System.out.println("host = " + host + " port = " + port);
			this.client = new Socket(host, port);
			this.messageLabel.append("Connection Established!\n");
			this.read = new Reader(this.client, this.messageLabel);
			Thread readth = new Thread(read);
			readth.start();
		}
		catch(Exception e){
			System.out.println("Erro main cliente: " + e.getMessage());
		}

		
	}

}
