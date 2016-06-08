package streams;

import java.awt.Color;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;

import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class Reader implements Runnable{
	private Socket server;
	private JTextArea lblMsg;

	public Reader(Socket server, JTextArea lblMsg)
	{
		this.lblMsg = lblMsg;
		this.server = server;
	}
	
	public void run() {
		try
		{
			
			//pegar stream de entrada jogando num buffer
			BufferedReader entryReader = new BufferedReader(new InputStreamReader(this.server.getInputStream()));
			String strRead;
			//criando socket datagram para confirmação de recebimento
			DatagramSocket ackSocket = new DatagramSocket(server.getPort());
			//criando ack
			byte[]by = new byte[8];
			DatagramPacket ack = new DatagramPacket(by, by.length);
			
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
				if(strRead != null)
				{
					this.lblMsg.append(strRead + '\n');
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
