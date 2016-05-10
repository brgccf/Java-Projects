package sockets;
import java.net.*;
import java.util.Scanner;
class UDPserver {

	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner (System.in);
		DatagramSocket serverSocket = new DatagramSocket(2350);
		byte[] receiveData = new byte[1024] ; byte[] sendData = new byte[1024];
		String inFromClient, outToClient;
		InetAddress clientIP; int port;
		while(true) {
			//pacote a ser recebido
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
			serverSocket.receive(receivePacket); //recebendo o pacotes
			inFromClient = new String(receivePacket.getData()); //colocando na string os dados recebidos
			clientIP = receivePacket.getAddress(); //pegando o IP e porta do pacote que chegou
			port = receivePacket.getPort();
			//System.out.println(inFromClient);
			
			outToClient = inFromClient.toUpperCase();
			sendData = outToClient.getBytes();
			//enviando pacote de resposta
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIP, port);
			serverSocket.send(sendPacket);
			
		} 
	} 
}