package sockets;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
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
	int serverPort;
	private ServerSocket serverSocket = null;
	private Socket connectSocket = null;
	private OutputStream outToClient;
	private InputStream in = null;
	private FileInputStream fileInputStream;
	private boolean temp = true;
	private File myFile = null;
	private JLabel label;
	private JLabel info;
	private JProgressBar progressBar;
	public TCPServer(String source, JLabel label, JLabel info, JProgressBar progressBar, int serverPort)
	{
		this.label = label;
		this.myFile = new File(source);
		this.progressBar = progressBar;
		this.serverPort = serverPort;
		this.info = info;
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
			System.out.println("name = " + myFile.getName());
			this.label.setText("Waiting for Client...");
			connectSocket = serverSocket.accept(); //socket conexao
				
		} 
		catch (IOException e) {
			this.label.setText("Erro no servidor: " + e.getMessage());;
		}
		this.progressBar.setMinimum(0);
		this.progressBar.setMaximum(100);
		this.progressBar.setValue(0);
		this.label.setText("Sending File...");
		long count = 0;
		long total = myFile.length();
		while(temp)
		{
			try
			{
				int len;
				byte[] arrayBytesFile = new byte[1024]; //array de bytes 
				fileInputStream = new FileInputStream(myFile); //tcp para leitura de arquivo
				in = new BufferedInputStream(fileInputStream);
				//stream de saida
				outToClient = connectSocket.getOutputStream();
				//escrevendo no socket
				DataOutputStream dos = new DataOutputStream(outToClient);
				//enviando nome do arquivo para cliente
				dos.writeUTF(myFile.getName());
				dos.writeLong(myFile.length()); //enviando tamanho do arquivo
				/*
				 * para o calculo do tempo estimado, devemos multiplicar a quantidade
				 * de bytes que ainda faltam ser transmitidas pelo RTT em segundos
				 * faremos isso aqui
				 */
				long fileLeft;
				while((len = in.read(arrayBytesFile)) > 0 && temp)
				{
					long time = (System.nanoTime()); //tempo em milisegundos
					outToClient.write(arrayBytesFile, 0, len);
					time = ((System.nanoTime()) - time)/1000; //intervalo de tempo em microsegundos
					count += len;
					fileLeft = myFile.length() - count; //quantidade de bytes restantes
					time = (time)*fileLeft; //tempo estimado em microsegundos
					time /= 1000000; //deixando o tempo em segundos
					if(time > 60)this.info.setText("Estimated Time: " + (long)time/3600 + "h" + (long)time/60 + "min");
					else this.info.setText("Estimated Time: " + time + " seconds");
					int value = (int)((count*100)/(total));
					this.progressBar.setValue(value);
				}
				if(len <= 0) break;
				
			}
			catch(FileNotFoundException e)
			{
				this.label.setText("Arquivo nao encontrado! --> " + e.getMessage());
			}
			catch(Exception e)
			{
				this.label.setText("erro de servidor: " + e.getMessage());
			}
		}
		this.label.setText("Transmission Finished.");
		//this.progressBar.setValue(100);
		try {
			serverSocket.close();
			connectSocket.close();
			fileInputStream.close();
			in.close();
			outToClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
