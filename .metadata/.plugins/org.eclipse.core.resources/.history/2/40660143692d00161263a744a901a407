package server;

import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import streams.Reader;
import streams.Writer;

public class MainServer implements Runnable {

	private static int port;
	private JTextField textField;
	private JTextArea lblMsg;
	private Writer write;
	private JToolBar toolBar;
	public MainServer(int port, JTextField textField, JTextArea lblMsg, JToolBar toolbar)
	{
		this.toolBar = toolbar;
		this.lblMsg = lblMsg;
		this.port = port;
		this.textField = textField;
	}
	
	public Writer getWriter()
	{
		return this.write;
	}
	
	public void run() {
		
		try
		{
			ServerSocket socketServer = new ServerSocket(port);
			Socket server = socketServer.accept(); //para aceitar a entrada do servidor
			Reader read = new Reader(server, this.lblMsg, toolBar);
			write = new Writer(server, this.textField);
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
