package brgccfStreams;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
import Streams.*;
//esta classe vai ler a entrada do teclado para enviar para o socket
public class Writer implements Runnable {
	
	private Socket server;
	
	public Writer(Socket socket)
	{
		this.server = socket;
	}
	
	public void run(){
		DataOutputStream socketOut; //criando caixa de areia para os dados de saida
		try{
			socketOut = new DataOutputStream(this.server.getOutputStream());
			String message = "";
			Scanner scan = new Scanner (System.in);
			while(true)
			{
				if(Thread.currentThread().isInterrupted()) return;
				
			}
		}
		catch(Exception e)
		{
			
		}
	}
	

}
