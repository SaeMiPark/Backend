import java.io.File;
import java.util.ArrayList;

import it.sauronsoftware.ftp4j.FTPClient;

public class Quiz03 {
	public static void main(String[] args) {

		FTPClient client = new FTPClient();
		try {
			client.connect("192.168.0.186");

		}catch(Exception e) {
			e.printStackTrace();
			return;
		}


		while(true) {
			int num1=(int)(Math.random()*10);
			int num2=(int)(Math.random()*10);
			int num3=(int)(Math.random()*10);
			int num4=(int)(Math.random()*10);
			
			String snum1=num1+"";
			String snum2=num2+"";
			String snum3=num3+"";
			String snum4=num4+"";
			
			String result=snum1+snum2+snum3+snum4;
			
			
			try{
				client.login("java",result); //1 3 5
				System.out.println("로그인 성공");
				try {
					client.download("top_secret.txt", new File("C:/workspace/downloads/top_secret3.txt"));
					System.out.println("다운로드가 성공적으로 완료되었습니다.");
				}catch(Exception e) {
					System.out.println("다운로드 실패");
					e.printStackTrace();
					continue;
				}
				break;
			}catch(Exception e) {
				e.printStackTrace();
				continue;
			}
		}



	}

}
