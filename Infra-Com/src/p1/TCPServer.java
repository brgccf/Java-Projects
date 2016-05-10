package p1;

import java.util.Scanner;
import java.io.*;
import java.net.*;
public class TCPServer {
	public static void main(String argv[]) throws Exception {
		String inFromClient;
		String outToClient;
		//socket de "boas vindas"
		ServerSocket welcomeSocket = new ServerSocket(2000);
		
		Scanner in = new Scanner(System.in);
		while(true) {
			//socket de conexão TCP
			Socket sock = welcomeSocket.accept();
			//buffer de entrada, que recebe um stream
			BufferedReader socketIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			inFromClient = socketIn.readLine();
			outToClient = in.nextLine(); //resposta a ser enviada de volta
			//stream de saida
			DataOutputStream socketOut = new DataOutputStream(sock.getOutputStream());//stream de saida
			//escrevendo no socket
			socketOut.writeBytes(outToClient);
			sock.close();
		}
	}
}