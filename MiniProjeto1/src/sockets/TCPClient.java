package sockets;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.Socket;
public class TCPClient implements Runnable{
	private Socket clientSocket = null; //socket cliente
	private BufferedInputStream inputStream = null;
	private boolean isConnected = false;
	
	private File dstFile = null; //arquivo que sera criado
	private String destinationPath;
	public TCPClient(String dest){
		this.destinationPath = dest;
	}
	
	public void run()
	{
		//accept connection
		while(!isConnected)
		{
			try
			{
				clientSocket = new Socket("localhost", 5050); //conectando com host na porta do servidor aberta
				isConnected = true;
			}
			catch(Exception e)
			{
				System.out.println("Erro de conexao em cliente: " + e.getMessage());
			}
		}
		
		while(true)
		{
			try
			{
				//recebendo resposta do servidor:
				inputStream = new BufferedInputStream(clientSocket.getInputStream());
				byte[] readPacket = new byte[1024]; //criando pacote
				inputStream.read(readPacket); //recebendo pacote
				//dado que o pacote foi recebido, precisamos enviar um ack de confirmacao (usariamos para calcular RTT)
				//DataOutputStream ack = new DataOutputStream(clientSocket.getOutputStream());
				//como enviar este ack? eh necessario?
				//stream de saida: para path de destino
				dstFile = new File(destinationPath);
				if(!dstFile.exists()) throw new Exception();
				dstFile.setWritable(true); //permitindo escrita
				if(!dstFile.createNewFile()) System.out.println("nao foi possivel criar arquivo!"); //criando arquivo
				
				FileOutputStream fileOutputStream = new FileOutputStream(dstFile.getName());
				fileOutputStream.write(readPacket, 0, readPacket.length); //escrevendo pacote no diretorio destino
				
				
			}
			catch(Exception e)
			{
				if(e.getMessage() == null)System.out.println("Diretorio destino inexistente!");
				else System.out.println("Erro em operacao de cliente: " + e.getMessage());
			}
		}
		
		
			
	}
}