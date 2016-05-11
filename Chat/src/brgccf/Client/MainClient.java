package brgccf.Client;
import java.net.Socket;
import brgccfStreams.*;

public class MainClient extends Thread {
	public static void main(String []args)
	{
		try{
			Socket client = new Socket("localhost", 3500);
			Reader read = new Reader(client);
			Writer write = new Writer(client);
			Thread readth = new Thread(read);
			Thread send = new Thread(write);
			readth.start();
			send.start();
		}
		catch(Exception e){
			System.out.println("Erro main: " + e.getMessage());
		}
		
		
	}

}