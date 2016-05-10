package p1;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) throws Exception {
		while(true){
			//lendo do teclado
			String inFromUser = new Scanner(System.in).nextLine();
			//criando um socket TCP
			Socket sock = new Socket("G3C24", 2002);
			//stream de saida
			DataOutputStream socketOut = new DataOutputStream(sock.getOutputStream());
			socketOut.writeBytes(inFromUser + '\n');
			
			//resposta do servidor
			BufferedReader socketIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			System.out.println(socketIn.readLine());
		}
	

	}

}
