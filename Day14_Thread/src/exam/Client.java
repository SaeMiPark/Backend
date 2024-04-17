package exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket sock= new Socket("192.168.0.161",30000);
		
		InputStream is=sock.getInputStream();
		OutputStream os=sock.getOutputStream();
		DataInputStream dis=new DataInputStream(is);
		DataOutputStream dos=new DataOutputStream(os);
		
		
		dos.writeUTF("와");
	}

}
