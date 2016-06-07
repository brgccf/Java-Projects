package streams;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JTextField;
//esta classe vai ler a entrada do teclado para enviar para o socket
public class Writer implements Runnable{
	private JTextField textField;
	private Socket server;
	private boolean clicked;
	public Writer(Socket server, JTextField textField)
	{
		this.clicked = false;
		this.server = server;
		this.textField = textField;
	}
	
	public void setClicked(boolean bool)
	{
		this.clicked = bool;
	}
	
	public void run() {
		DataOutputStream socketOut; //criando caixa de areia para os dados de saida
		try{
			socketOut = new DataOutputStream(this.server.getOutputStream());
			String message = "";
			while(true)
			{
				if(Thread.currentThread().isInterrupted()) break; //se estiver interrompida sai do la�o
				else if(!this.clicked) continue; //repete o la�o se nao houve click
				else
				{
					message = this.textField.getText();
					
					if(message.equalsIgnoreCase("exit")){
						socketOut.writeBytes(message+'\n'); //envia o comando de saida
						socketOut.flush(); //for�a todos os bytes a serem enviados na stream
						this.server.close(); //fecha o servidor
						System.out.println("Writer interrupted!");
						Thread.currentThread().interrupt();
					}
					else{
						socketOut.writeBytes(message+'\n'); //escrevendo no socket
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Interrupted Writer with Exception: " + e.getMessage());
			Thread.currentThread().interrupt();
		}
	
		
	}
	
	

}
