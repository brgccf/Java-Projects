package sockets;

import java.io.DataInputStream;
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
	private long totalLength;
	private JLabel label;
	private JProgressBar progress;
	private File dstFile = null; //arquivo que sera criado
	private String destinationPath;
	public TCPClient(String dest, JLabel label, JProgressBar progress, long total){
		this.label = label;
		this.destinationPath = dest;
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
				clientSocket = new Socket("localhost", 5050); //conectando com host na porta do servidor aberta
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
		this.progress.setMaximum(100);
		this.progress.setValue(0);
		long count = 0;
		while(temp)
		{
			try
			{
				//recebendo resposta do servidor:
				int len;
				byte[] readPacket = new byte[1024]; //criando pacote
				//calculo do RTT: come�a antes de escrever e verifica logo apos terminar
				
				//lendo o nome do arquivo
				DataInputStream clientData = new DataInputStream(inputStream);
				String fileName = clientData.readUTF();
				destinationPath += fileName; //agregando o nome do arquivo ao destino
				dstFile = new File(destinationPath);
				System.out.println("DESTINO: " + destinationPath);
				
				//stream de saida: para path de destino
				fileOutputStream = new FileOutputStream(dstFile);
				if(!dstFile.exists()) throw new Exception();
				dstFile.setWritable(true); //permitindo escrita
				
				while((len = inputStream.read(readPacket)) > 0)
				{
					long RTT = System.nanoTime();
					fileOutputStream.write(readPacket, 0, len); //escrevendo no diretorio destino
					RTT = System.nanoTime() - RTT;
					this.label.setText("RTT = " + RTT/1000 + " picosegundos");
					count += len;
					int value = (int)((count*100)/(totalLength));
					this.progress.setValue(value);
					
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
