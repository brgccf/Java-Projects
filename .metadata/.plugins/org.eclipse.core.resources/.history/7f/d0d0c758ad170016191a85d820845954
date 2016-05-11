package wro.server;

import java.net.ServerSocket;
import java.net.Socket;
import Streams.*;


public class MainServer {
	public static void main(String[]args){


		try{
			ServerSocket aceita = new ServerSocket(3000);
			Socket servidor = aceita.accept(); // aceitacao de entrada para o socket do servidor		

			(new Thread(new Leitor(servidor))).start();//cria a thread de leitura da entrada

			(new Thread(new Escritor(servidor))).start(); //cria a thread de envio

		}
		catch (Exception e){
			System.out.println("erro Main" + e );
		}	
	}


}


