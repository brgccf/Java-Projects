package wro.Client;

import java.net.Socket;

import Streams.*;

public class MainCliente extends Thread {
	public static void main(String []args){
		try{
			Socket cliente = new Socket("G3C38",3555);	
			
			(new Thread(new Leitor(cliente))).start(); // cria a thread de leitura da entrada
			
			(new Thread(new Escritor(cliente))).start(); // cria a thread de envio
			
		}
		catch (Exception e){
			System.out.println("erro Main" + e );
		}	
		
	}
}
