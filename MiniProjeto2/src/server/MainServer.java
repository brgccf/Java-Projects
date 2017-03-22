package server;

import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextArea;

import streams.Reader;
import streams.Writer;

public class MainServer implements Runnable {
	private Reader read;
	private static int port;
	private JTextArea lblMsg;
	private Socket server;
	@SuppressWarnings("static-access")
	public MainServer(int port, JTextArea lblMsg)
	{
		this.read = null;
		this.lblMsg = lblMsg;
		this.port = port;
		this.server = null;
	}
	
	public void sendMessage(String msg)
	{
		if(this.server == null) 
		{
			System.out.println("Socket closed!");
			return;
		}
		Writer write = new Writer(this.server, msg, this.lblMsg);
		Thread wr = new Thread(write);
		wr.start();
	}
	
	public void disconnect()
	{
		try
		{
			if(this.server!=null)this.server.close();
		}catch(Exception e)
		{
			System.out.println("exception disconnecting: " + e.getMessage());
		}
		
		this.read.disconnect();
		Thread.currentThread().interrupt();
	}
	
	@SuppressWarnings("resource")
	public void run() {
		
		try
		{
			ServerSocket socketServer = new ServerSocket(port);
			this.server = socketServer.accept(); //para aceitar a entrada do servidor
			this.read = new Reader(server, this.lblMsg);
			Thread readth = new Thread(read); 
			readth.start();
		}
		catch(Exception e)
		{
			System.out.println("Server error Exception: " + e.getMessage());
			
		}

		
	}

}
