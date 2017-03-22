package streams;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.net.Socket;

import javax.swing.JTextArea;


public class Reader implements Runnable{
	private Writer write;
	private Socket server;
	private JTextArea lblMsg;
	public Reader(Socket server, JTextArea lblMsg)
	{
		this.write = null;
		this.lblMsg = lblMsg;
		this.server = server;
	}
	
	public void disconnect()
	{
		Thread.currentThread().interrupt();
	}
	
	public void run() {
		try
		{
			//writer é instanciado para podermos enviar confirmaçao de recebimento da mensagem
			this.write = new Writer(this.server, "rcv", this.lblMsg);
		
			//pegar stream de entrada jogando num buffer
			BufferedReader entryReader = new BufferedReader(new InputStreamReader(this.server.getInputStream()));
			String strRead;
			
			while(true)
			{
				
				strRead = entryReader.readLine(); //lendo texto digitado
				if(strRead.equalsIgnoreCase("rcv"))
				{
					this.lblMsg.append("(mensagem entregue)\n");
				}
				//comando de saida
				else if(strRead.equalsIgnoreCase("exit"))
				{
					this.server.close();
					System.out.println("Interrupting Reader!");
					Thread.currentThread().interrupt(); //interrompe a thread
				}
				//caso contrario vamos imprimir o texto recebido
				else if(!strRead.equalsIgnoreCase(""))
				{
					this.lblMsg.append(strRead + '\n');
					Thread wr = new Thread(this.write);
					wr.start();
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
