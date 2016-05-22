package sockets;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
public class TCPClient implements Runnable{
	private Socket clientSocket = null; //socket cliente
	private InputStream inputStream = null;
	private OutputStream fileOutputStream = null;
	private boolean isConnected = false;
	private boolean temp = true;
	private int totalLength;
	private JLabel label;
	private JProgressBar progress;
	private File dstFile = null; //arquivo que sera criado
	//private String destinationPath;
	public TCPClient(String dest, JLabel label, JProgressBar progress, int total){
		this.dstFile = new File(dest);
		this.label = label;
		this.progress = progress;
		this.totalLength = total;
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
				clientSocket = new Socket("192.168.1.107", 5050); //conectando com host na porta do servidor aberta
				isConnected = true;
				this.label.setText("Connected.");
				inputStream = clientSocket.getInputStream();
			}
			catch(Exception e)
			{
				System.out.println("Erro de conexao em cliente: " + e.getMessage());
			}
		}
		this.progress.setMinimum(0);
		this.progress.setMaximum(totalLength);
		this.progress.setValue(0);
		int count = 0;
		while(temp)
		{
			try
			{
				//recebendo resposta do servidor:
				int len;
				byte[] readPacket = new byte[1024]; //criando pacote
				//calculo do RTT: usaremos o LastModified do arquivo
				
				//stream de saida: para path de destino
				fileOutputStream = new FileOutputStream(dstFile);
				if(!dstFile.exists()) throw new Exception();
				dstFile.setWritable(true); //permitindo escrita
				while((len = inputStream.read(readPacket)) > 0)
				{
					long RTT = System.currentTimeMillis();
					fileOutputStream.write(readPacket, 0, len); //escrevendo no diretorio destino
					//assim que recebeu e leu o pacote, podemos calcular RTT:
					RTT = dstFile.lastModified() - RTT;
					this.label.setText("RTT = " + RTT + " ms");
					count += len;
					this.progress.setValue(count);
				}
				
				if(len <= 0) break;
			}
			catch(Exception e)
			{
				if(e.getMessage() == null)System.out.println("Diretorio destino inexistente!");
				else System.out.println("Erro em operacao de cliente: " + e.getMessage());
				
			}
		}
		this.progress.setValue(100);
		try {
			this.label.setText("Download Finished. Check the destiny Path.");
			clientSocket.close();
			fileOutputStream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
			
	}
}
