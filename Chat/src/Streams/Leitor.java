package Streams;
import java.util.*;
import java.net.*;
import java.io.*;
public class Leitor implements Runnable {

	private Socket servidor;

	public Leitor(Socket servidor) {
		this.servidor = servidor;
	}
	public void run() {
		try {
			// pega stream de entrada
			BufferedReader socketEntrada = new BufferedReader(new InputStreamReader(this.servidor.getInputStream()));
			String entrada;
			while(true){
				/* caso a Thread tenha recebido sinal de interrp��o, retorna
				 * note que isto n�o � obrigat�rio para este caso
				 */
			
			
				entrada = socketEntrada.readLine();
				if(entrada.equals("exit")) { // caso um comando de sair tenha sido recebido
					this.servidor.close(); // fecha o socket
					System.out.println("Interrompeu Leitor"); 
					Thread.currentThread().interrupt(); // interrompe Thread de leitura
				} else { // caso contr�rio reenvia o texto
					System.out.println(entrada);
				}
			
			}
		} catch(Exception e) {
			System.out.println("Interrompeu Leitor Exception com " + e.getMessage());
			Thread.currentThread().interrupt(); // interrompe Thread de leitura
		}
	}
}
