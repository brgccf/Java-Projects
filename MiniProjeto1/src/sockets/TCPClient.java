package sockets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
public class TCPClient implements Runnable{
	private Socket clientSocket = null; //socket cliente
	private InputStream inputStream = null;
	private OutputStream fileOutputStream = null;
	private boolean isConnected = false;
	private boolean temp = true;
	
	private File dstFile = null; //arquivo que sera criado
	//private String destinationPath;
	public TCPClient(String dest){
		this.dstFile = new File(dest);
	}
	
	public void finish()
	{
		this.temp = false;
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
				inputStream = clientSocket.getInputStream();
			}
			catch(Exception e)
			{
				System.out.println("Erro de conexao em cliente: " + e.getMessage());
			}
		}
		
		while(temp)
		{
			try
			{
				//recebendo resposta do servidor:
				int len;
				byte[] readPacket = new byte[1024]; //criando pacote
				//inputStream.read(readPacket); //recebendo pacote
				//dado que o pacote foi recebido, precisamos enviar um ack de confirmacao (usariamos para calcular RTT)
				//DataOutputStream ack = new DataOutputStream(clientSocket.getOutputStream());
				//como enviar este ack? eh necessario?
				//stream de saida: para path de destino
				fileOutputStream = new FileOutputStream(dstFile);
				if(!dstFile.exists()) throw new Exception();
				dstFile.setWritable(true); //permitindo escrita
				while((len = inputStream.read(readPacket)) > 0)
				{
					fileOutputStream.write(readPacket, 0, len); //escrevendo no diretorio destino
				}
				if(len <= 0) break;
				
			}
			catch(Exception e)
			{
				if(e.getMessage() == null)System.out.println("Diretorio destino inexistente!");
				else System.out.println("Erro em operacao de cliente: " + e.getMessage());
				
			}
		}
		
		try {
			clientSocket.close();
			fileOutputStream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
			
	}
}
