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
		/*
		 * InputStream is=sock.getInputStream(); OutputStream os=sock.getOutputStream();
		 * ObjectOutputStream oos = new ObjectOutputStream(os); ObjectInputStream ois =
		 * new ObjectInputStream(is);
		 */
		InputStream is=sock.getInputStream();
		OutputStream os=sock.getOutputStream();
		DataInputStream dis=new DataInputStream(is);
		DataOutputStream dos=new DataOutputStream(os);
		
		
		//File home=new File();
		int lg=dis.readInt();//길이
		System.out.println(lg);//길이 출력
		
		for(int i=0; i<lg; i++) {
			String str=dis.readUTF();
			System.out.println(str);
		}
		
		
	}

}
