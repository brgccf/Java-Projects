package sockets;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JLabel;
public class TCPServer implements Runnable {
	int serverPort = 5050;
	private ServerSocket serverSocket = null;
	private Socket connectSocket = null;
	private BufferedOutputStream outToClient;
	private String sourceFilePath; //local raiz do arquivo
	//private String destinationPath; //destino do arquivo
	private JLabel label;
	public TCPServer(String source, JLabel label)
	{
		this.sourceFilePath = source;
		//this.destinationPath = dest;
		this.label = label;
	}
	
	public void run()
	{
		/*
		 * deve conter
		 * socket de boas vindas
		 * socket de conexao
		 * buffer de saida
		 * input stream de arquivo
		 */
		
		try {
			serverSocket = new ServerSocket(serverPort); //socket boas vindas
			connectSocket = serverSocket.accept(); //socket conexao
			this.label.setText("Waiting for Client...");
			
		} 
		catch (IOException e) {
			this.label.setText("Erro no servidor: " + e.getMessage());;
		}
		
		while(true)
		{
			try
			{
				File myFile = new File(sourceFilePath); //found file to send
				int len = (int)myFile.length(); //tamanho total do arquivo
				byte[] arrayBytesFile = new byte[1024]; //array de bytes 
				 //tcp para leitura de arquivo
				if(len > 1024)new FileInputStream(myFile).read(arrayBytesFile, 0, 1024); //se arquivo for maior que 1024 bytes
				else new FileInputStream(myFile).read(arrayBytesFile, 0, len); //se nao for maior, devemos diminuir o pacote
				//stream de saida
				outToClient = new BufferedOutputStream(connectSocket.getOutputStream());
				//escrevendo no socket
				long RTT = System.nanoTime();
				outToClient.write(arrayBytesFile);
				outToClient.flush(); //for�ando escrita de todo o pacote no socket
				
				//falta receber confirma�ao pra calcular RTT
				
				RTT = System.nanoTime() - RTT;
				this.label.setText("RTT = " + RTT/1000 + " micro segundos"); //atualizando RTT
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Arquivo nao encontrado! --> " + e.getMessage());
			}
			catch(Exception e)
			{
				System.out.println("erro de servidor: " + e.getMessage());
			}
		}
	}

}