package sockets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
public class TCPServer implements Runnable {
	int serverPort = 5050;
	private ServerSocket serverSocket = null;
	private Socket connectSocket = null;
	private OutputStream outToClient;
	private InputStream in = null;
	private FileInputStream fileInputStream;
	//private String sourceFilePath; //local raiz do arquivo
	//private String destinationPath; //destino do arquivo
	private boolean temp = true;
	private File myFile = null;
	private JLabel label;
	private JProgressBar progressBar;
	public TCPServer(String source, JLabel label, JProgressBar progress)
	{
		//this.sourceFilePath = source;
		//this.destinationPath = dest;
		this.label = label;
		this.myFile = new File(source);
		this.progressBar = progress;
	}
	
	public void finish()
	{
		this.temp = false;
	}
	
	public File getFile()
	{
		return this.myFile;
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
			
			this.label.setText("Waiting for Client...");
			connectSocket = serverSocket.accept(); //socket conexao
		} 
		catch (IOException e) {
			this.label.setText("Erro no servidor: " + e.getMessage());;
		}
		this.progressBar.setMinimum(0);
		this.progressBar.setMaximum(100);
		this.progressBar.setValue(0);
		long count = 0;
		long totLength = myFile.length();
		while(temp)
		{
			try
			{
				
				//File myFile = new File(sourceFilePath); //found file to send
				//int len = (int)myFile.length(); //tamanho total do arquivo
				int len;
				byte[] arrayBytesFile = new byte[1024]; //array de bytes 
				fileInputStream = new FileInputStream(myFile); //tcp para leitura de arquivo
				in = new BufferedInputStream(fileInputStream);
				//stream de saida
				outToClient = connectSocket.getOutputStream();
				//escrevendo no socket
				long RTT = System.nanoTime();
				while((len = in.read(arrayBytesFile)) > 0)
				{
					outToClient.write(arrayBytesFile, 0, len);
				}
				if(len <= 0) break;
				count += len;
				this.progressBar.setValue((int)(count*100/totLength));
				//falta receber confirmašao pra calcular RTT
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
		this.label.setText("Transmission Finished.");
		this.progressBar.setValue(100);
		try {
			fileInputStream.close();
			in.close();
			outToClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
