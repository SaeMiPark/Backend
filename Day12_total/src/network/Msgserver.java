package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;



class Send extends Thread{
	private DataOutputStream dos;

	public Send(DataOutputStream dos) {
		this.dos=dos;
	}


	public void run() {
		while(true) {
			String mymsg=JOptionPane.showInputDialog("보낼 메세지를 입력하세요.");
			try {
				dos.writeUTF(mymsg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			System.out.println("나 : "+mymsg);
		}
	}
}

public class Msgserver {
	public static void main(String[] args) throws IOException {
		//접속, 연결
		ServerSocket server=new ServerSocket(26000);
		//lan카드 27000번으로 들어오는거 감시해
		Socket sock=server.accept();
		System.out.println(sock.getInetAddress()+"로부터 접속");

		//통로 만들기
		//기본 stream 생성
		OutputStream os=sock.getOutputStream(); //output내보내기
		InputStream is=sock.getInputStream();
		DataOutputStream dos=new DataOutputStream(os);
		DataInputStream dis=new DataInputStream(is);
		
		Send sd=new Send(dos);
		sd.start();

		while(true) {
			String msg=dis.readUTF();
			System.out.println("Client : "+msg);
		}

	}

}
