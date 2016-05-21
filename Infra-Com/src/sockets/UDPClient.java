package sockets;
import java.net.*;
import java.util.Scanner;
class UDPclient {
	//camada transporte sao processos interligados
	//camada de rede sao hosts interligados
	public static void main(String args[]) throws Exception {
		while(true){
			String inFromUser = System.nanoTime() +""; //entrada do usuário
			DatagramSocket clientSocket = new DatagramSocket(); //socket UDP
			InetAddress IPServer = InetAddress.getByName("localhost"); //IP do servidor
			byte[] sendData = new byte[1024]; //dados a serem enviados
			sendData = inFromUser.getBytes();
			//criando o pacote de envio
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPServer, 2350);
			long RTT = System.nanoTime();
			clientSocket.send(sendPacket);
			byte[] receiveData = new byte[1024]; //dados recebidos
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			clientSocket.receive(receivePacket); //recebendo o pacote
			RTT = System.nanoTime() - RTT;
			String inFromServer = new String(receivePacket.getData());
			System.out.println("FROM SERVER: " + inFromServer);
			System.out.println("RTT: " + RTT/1000 + " micro segundos");
			clientSocket.close();
		}
	} 
}