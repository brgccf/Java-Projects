package sockets;

import java.io.DataInputStream;
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
	private JLabel info;
	private String ip;
	private int serverPort;
	public TCPClient(String dest, JLabel label, JProgressBar progress, JLabel info, String ip, int serverPort){
		this.label = label;
		this.destinationPath = dest;
		this.progress = progress;
		this.info = info;
		this.ip = ip;
		this.serverPort = serverPort;
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
				clientSocket = new Socket(this.ip, serverPort); //conectando com host na porta do servidor aberta
				isConnected = true;
				this.label.setText("Connected.");
				inputStream = clientSocket.getInputStream();
			}
			catch(Exception e)
			{
				this.info.setText("Erro de conexao em cliente: " + e.getMessage());
			}
		}
		this.progress.setMinimum(0);
		this.progress.setMaximum(100);
		this.progress.setValue(0);
		long count = 0;
		this.label.setText("Downloading File. Please Wait...");
		//variaveis para calculo do tempo estimado
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
				this.totalLength = clientData.readLong(); //tamanho total do arquivo em bytes
				//stream de saida: para path de destino
				fileOutputStream = new FileOutputStream(dstFile);
				if(!dstFile.exists()) throw new Exception();
				dstFile.setWritable(true); //permitindo escrita
				/*
				 * para o calculo do tempo estimado, devemos multiplicar a quantidade
				 * de bytes que ainda faltam ser transmitidas pelo RTT em segundos
				 * faremos isso no servidor
				 */
				while((len = inputStream.read(readPacket)) > 0 && temp)
				{
					long RTT = System.nanoTime();
					fileOutputStream.write(readPacket, 0, len); //escrevendo no diretorio destino
					RTT = System.nanoTime() - RTT;
					this.info.setText("RTT = " + RTT/1000 + " microsegundos");
					count += len;
					int value = (int)((count*100)/(totalLength));
					this.progress.setValue(value); //atualizando barra de progresso
					this.label.setText(value + "% "); /*+ seconds/3600 + "h" + seconds/60 + "min" + (seconds%3600) + "sec remaining.");*/
				}
				
				if(len <= 0) break;
			}
			catch(Exception e)
			{
				if(e.getMessage() == null)this.info.setText("Diretorio destino inexistente!");
				else this.info.setText("Erro em operacao de cliente: " + e.getMessage());
				System.out.println("Erro em cliente: " + e.getMessage());
				
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
