package streams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Reader implements Runnable{
	private Socket server;
	
	public Reader(Socket server)
	{
		this.server = server;
	}
	
	public void run() {
		try
		{
			//pegar stream de entrada jogando num buffer
			BufferedReader entryReader = new BufferedReader(new InputStreamReader(this.server.getInputStream()));
			String strRead;
			while(true)
			{
				strRead = entryReader.readLine(); //lendo texto digitado
				//comando de saida
				if(strRead.equalsIgnoreCase("exit"))
				{
					this.server.close();
					System.out.println("Interrupting Reader!");
					Thread.currentThread().interrupt(); //interrompe a thread
				}
				//caso contrario vamos imprimir o texto recebido
				System.out.println(strRead);
			}
		}
		catch(Exception e)
		{
			System.out.println("Reader interrupted by exception: " + e.getMessage());
			Thread.currentThread().interrupt(); //interrompe thread de leitura
		}
	}

}