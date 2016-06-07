package server;

import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextField;

import streams.Reader;
import streams.Writer;

public class MainServer implements Runnable {

	private static int port;
	private JTextField textField;
	public MainServer(int port, JTextField textField)
	{
		this.port = port;
		this.textField = textField;
	}
	
	public void run() {
		try
		{
			ServerSocket socketServer = new ServerSocket(port);
			Socket server = socketServer.accept(); //para aceitar a entrada do servidor
			Reader read = new Reader(server);
			Writer write = new Writer(server, this.textField);
			Thread readth = new Thread(read); 
			Thread send = new Thread(write);
			readth.start();
			send.start();
		}
		catch(Exception e)
		{
			System.out.println("Server error Exception: " + e.getMessage());
		}

	}

}
