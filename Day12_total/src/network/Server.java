package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Server {
	public static void main(String[] args) throws IOException {
		//접속, 연결
		ServerSocket server=new ServerSocket(26000);
		//lan카드 27000번으로 들어오는거 감시해
		Socket sock=server.accept();
		System.out.println(sock.getInetAddress()+"로부터 접속");

		//통로 만들기
		//기본 stream 생성
		OutputStream os=sock.getOutputStream(); //output내보내기
		//업그레이드 straeam으로 보강공사, 필터드스트림
		DataOutputStream dos=new DataOutputStream(os);
		
		InputStream is=sock.getInputStream();
		DataInputStream dis=new DataInputStream(is);
		
		while(true) {
			//데이터 트럭에 저장
			String mymsg=JOptionPane.showInputDialog("보낼 메세지를 입력하세요.");
			dos.writeUTF(mymsg);
			//트럭 출발 1. 데이터 꽉 차거나 2. 그냥 출발해
			dos.flush();
			System.out.println("나 : "+mymsg);
			
			String msg=dis.readUTF();
			System.out.println("언니 : "+msg);
			
		}

		//서버-클라이언트 규칙
		//write와 read 수가 일치해야한다==프로토콜

	}

}
