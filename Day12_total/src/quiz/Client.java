package quiz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Scanner sc=new Scanner(System.in);
		Socket sock=null;

		try {
			sock=new Socket("192.168.0.186",26000); //연결 127.0.0.1 내 컴퓨터 뜻 함
		}catch(Exception e) {
			e.printStackTrace(); //에러 원인 알려주는
			System.exit(0);
		}	

		//통로
		InputStream is=sock.getInputStream();
		DataInputStream dis=new DataInputStream(is);
		OutputStream os=sock.getOutputStream(); 
		DataOutputStream dos=new DataOutputStream(os);

		while(true) {
			System.out.println("<<서비스 예제>>");
			System.out.println("1. 로또 번호 추천");
			System.out.println("2. 현재 시간 요청");
			System.out.println("3. 오늘의 명언");
			System.out.print(">>");
			String menu=sc.nextLine(); //int로 해도 상관 없다?
			dos.writeUTF(menu);  //int로 하면 writeInt로 보내야 한다.
			dos.flush();

			//내가 1이든, 2이든 결국 String 하나만 받지 않나?
			String msg=dis.readUTF();
			System.out.println(msg);

		}


	}

}
