package brgccfStreams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.*;
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
				/* caso a Thread tenha recebido sinal de interrp��o, retorna
				 * note que isto n�o � obrigat�rio para este caso
				 */
				
			}
		} 
		catch(Exception e)
		{
			
		}
	}
	

}
