import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.Socket;
import java.security.MessageDigest;
import java.util.Scanner;

public class Client {
	
	
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);

		while(true) {
			Socket sock=new Socket("192.168.1.19",30000); //접속, 연결 while문 안에 들어와야 함

			//통로
			InputStream is=sock.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			OutputStream os=sock.getOutputStream(); 
			DataOutputStream dos=new DataOutputStream(os);

			System.out.println("<<회원 인증 시스템>>");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.print(">>");
			String menu=sc.nextLine();
			dos.writeUTF(menu);
			dos.flush();

			if(menu.equals("1")) {
				System.out.print("id>>");
				String id=sc.nextLine();
				System.out.print("pw>>");
				String pw=sc.nextLine();

				dos.writeUTF(id);
				dos.writeUTF(pw);
				dos.flush();

				String result=dis.readUTF();
				System.out.println(result);

			}else if(menu.equals("2")) {
				System.out.print("id>>");
				String id=sc.nextLine();
				System.out.print("pw>>");
				String pw=sc.nextLine();
				System.out.print("name>>");
				String name=sc.nextLine();

				dos.writeUTF(id);
				dos.writeUTF(pw);
				dos.writeUTF(name);
				dos.flush();

				String result=dis.readUTF();
				System.out.println(result);	
			}
		}



	}

}
