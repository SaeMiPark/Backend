/*파일 전송 프로그램*/

import java.io.File;

import it.sauronsoftware.ftp4j.FTPClient;

public class Exam01 {
	//FTP: File Transfer Protocol
	//네트워크 규약, FTP서버
	//서버 서비스제공
	//클라이언트 제공 받는
	public static void main(String[] args) {
		FTPClient client = new FTPClient();
		try {
			client.connect("192.168.0.189");

		}catch(Exception e) {
			e.printStackTrace();
			return; //main메소드에서 return == 프로그램 끄겠다.
		}


		try {
			client.login("java", "1234");
		}catch(Exception e) {
			e.printStackTrace();
			return;
		}


		try {
			client.download("abc.txt", new File("C:/workspace/downloads/abc2.txt"));
		}catch(Exception e) {
			e.printStackTrace();
		}

		
		try {
			client.disconnect(false);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
