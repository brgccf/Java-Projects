package Streams;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;
public class Escritor implements Runnable  {
	private Socket servidor;
	public Escritor(Socket socket) {
		this.servidor = socket;
	}
	public void run() {
		DataOutputStream socketOut;
		try {
			socketOut = new DataOutputStream(this.servidor.getOutputStream());
			String saida = "";
			Scanner scan = new Scanner(System.in);
			while (true) {
				if (Thread.currentThread().isInterrupted()) return;
				else {
					saida = scan.nextLine();
					
					if (saida.equals("exit")) { // caso o usuário tenha dado o comando de sair
						socketOut.writeBytes(saida+'\n'); // envia comando de saida
						socketOut.flush(); // força os bytes a serem enviados na stream
						this.servidor.close(); // fecha a conexão
						scan.close(); // fecha o scanner
						System.out.println("Interrompeu Escritor");
						Thread.currentThread().interrupt(); // interrompe a Thread de escrita
					} else {
						socketOut.writeBytes(saida+'\n'); // escrevendo no socket
					}
				}
			}
		} catch (IOException e1) {
			System.out.println("Interrompeu Escritor Exception com " + e1.getMessage());
			Thread.currentThread().interrupt(); // interrompe a Thread de escrita
		}
	}
}

