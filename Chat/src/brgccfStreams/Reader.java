package brgccfStreams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
//nesta classe devemos ler o stram de writer (input stream)
public class Reader implements Runnable { //Runnable possui os metodos obrigatorios de threads (Run)
	
	private Socket server;
	
	public Reader(Socket socket)
	{
		this.server = socket;
	}
	
	public void run(){
		try{
			//pegar stram de entrada jogando no buffer
			BufferedReader socketEntrada = new BufferedReader(new InputStreamReader(this.server.getInputStream()));
			String entry;
			while(true)
			{
				/* caso a Thread tenha recebido sinal de interrpção, retorna
				 * note que isto não é obrigatório para este caso
				 */
				entry = socketEntrada.readLine();
				if(entry.equals("exit")) //caso um comando de sair tenha sido recebido
				{
					this.server.close(); //fecha o socket
					System.out.println("interrupted Reader!");
					Thread.currentThread().interrupt(); //interrompendo thread de leitura
				}
				else //caso contrario devemos imprimir o texto recebido
				{
					System.out.println(entry);
				}
			}
		} 
		catch(Exception e)
		{
			System.out.println("Reader interrupted by exception: " + e.getMessage());
			Thread.currentThread().interrupt(); //interrompe thread de leitura
		}
	}
	

}
