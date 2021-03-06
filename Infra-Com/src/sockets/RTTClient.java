package sockets;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JLabel;

public class RTTClient implements Runnable {

	private JLabel label;
	boolean temp;
	public RTTClient(JLabel label)
	{
		this.label = label;
	}
	
	public void run() {
		temp = true;
		try{
			DatagramSocket clientSocket = new DatagramSocket(); //socket UDP
			while(temp){
				String inFromUser = System.nanoTime() +""; //entrada do usu�rio
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
				//String inFromServer = new String(receivePacket.getData());
				//System.out.println("FROM SERVER: " + inFromServer);
				//System.out.println("RTT: " + RTT/1000 + " micro segundos");
				this.label.setText("RTT = " + RTT/1000 + " micro segundos");
				//run();
			}
			clientSocket.close();
		}
		catch(Exception e)
		{
			System.out.println("erro: " + e.getMessage());
		}
	}
	
	public void finish()
	{
		temp = false;
	}

}
