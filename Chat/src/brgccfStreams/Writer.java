package brgccfStreams;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
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
				if(Thread.currentThread().isInterrupted()) return; //se estiver interrompida volta ao inicio do la�o
				else
				{
					message = scan.nextLine();
					
					if(message.equals("exit")){
						socketOut.writeBytes(message+'\n'); //envia o comando de saida
						socketOut.flush(); //for�a todos os bytes a serem enviados na stream
						this.server.close(); //fecha o servidor
						System.out.println("Writer interrupted!");
						Thread.currentThread().interrupt();
					}
					else{
						socketOut.writeBytes(message+'\n'); //escrevendo no socket
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Interrupted Writer with Exception: " + e.getMessage());
			Thread.currentThread().interrupt();
		}
		
	}
	
	

}
