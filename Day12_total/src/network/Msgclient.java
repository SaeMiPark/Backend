package network;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Msgclient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client=new Socket("192.168.0.186",26000);
		InputStream is= client.getInputStream();
		DataInputStream dis=new DataInputStream(is);
		
		while(true) {
			String msg=dis.readUTF();
			System.out.println(msg);
		}
	}

}
