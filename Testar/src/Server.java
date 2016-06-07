
import java.net.*;
import java.io.*;

//O PROJETO � EXECUTADO PELA GUI! RODE A GUI!

public class Server{ //Servidor Thread pois ser� rodado em paralelo com o cliente e a GUI.

  public static void main(String[] args)
  {
	  try{
		  ServerSocket servsock = new ServerSocket(3500);
    
		  while (true) {
				  Socket sock = servsock.accept();
				  File arq = new File("C:\\enviado.txt");
				  FileOutputStream target_file = new FileOutputStream(arq);
					try{
						byte [] array_bytes  = new byte[1024]; //cria um array de 1024 bytes, pois ser� enviado KB por KB.
					      //cria um stream de entrada receber o arquivo e contabilizar RTT.
					      BufferedInputStream Buff = new BufferedInputStream(sock.getInputStream());
					      DataOutputStream out = new DataOutputStream(sock.getOutputStream()); // Stream para enviar resposta pra contar RTT.
					      int bytes_was_read = 0; //N�mero de bytes q foram lidos.
					      while(bytes_was_read > -1) //Quando termina de ler o arquivo, o m�todo retorna -1.
					      {
					    	  bytes_was_read = Buff.read(array_bytes, 0, array_bytes.length); //escreve o KB vindo da stream no array de bytes
					    	  if(bytes_was_read >= 0) target_file.write(array_bytes,0, bytes_was_read); //escreve o KB do array de bytes
					    	  																								//no arquivo.
					    	  out.writeBytes("\n"); //Manda resposta para contabilizar o RTT.
					      }
					}catch(Exception e)
					{
						e.printStackTrace();
					}
			       
			      sock.close(); //fecha soquete ap�s receber arquivo.
		      }		  
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
	  }
  }