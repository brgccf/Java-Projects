package streams;

import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JTextArea;
//esta classe vai ler a entrada do teclado para enviar para o socket
public class Writer implements Runnable{
	private Socket server;
	private String msg;
	private JTextArea txt;
	public Writer(Socket server, String msg, JTextArea txt)
	{
		this.txt = txt;
		this.server = server;
		this.msg = msg;
	}
	
	public void run() {
		DataOutputStream socketOut; //criando caixa de areia para os dados de saida
		try{
			socketOut = new DataOutputStream(this.server.getOutputStream());
			
			System.out.println("Message = " + this.msg);
			if(this.msg.equalsIgnoreCase("exit")){
				socketOut.writeBytes(this.msg+'\n'); //envia o comando de saida
				socketOut.flush(); //força todos os bytes a serem enviados na stream
				this.server.close(); //fecha o servidor
				System.out.println("Writer interrupted!");
				Thread.currentThread().interrupt();
			}
			else{
				socketOut.writeBytes(this.msg+'\n'); //escrevendo no socket
				if(!this.msg.equalsIgnoreCase("rcv"))this.txt.append(this.msg + " ");
			}
			
	
		}
		catch(Exception e)
		{
			System.out.println("Interrupted Writer with Exception: " + e.getMessage());
			Thread.currentThread().interrupt();
		}
	
		
	}
	
	

}
