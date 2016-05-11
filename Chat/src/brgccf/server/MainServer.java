package brgccf.server;

import java.net.ServerSocket;
import java.net.Socket;

import brgccfStreams.Reader;
import brgccfStreams.Writer;

public class MainServer extends Thread {

	public static void main(String[] args) {
		try{
			ServerSocket sserver = new ServerSocket(3500);
			Socket server = sserver.accept(); //para aceitar a entrada do servidor
			Reader read = new Reader(server);
			Writer write = new Writer(server);
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
