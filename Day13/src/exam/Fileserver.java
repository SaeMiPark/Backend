package exam;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Fileserver {
	public static void main(String[] args) throws IOException {
		//socket, dis, dos ==thread
		ServerSocket server=new ServerSocket(26000);
		System.out.println("접속 대기 중");
		
		
		while(true) {
			Socket  sock=server.accept(); //싱글 뜨레드로 해도 된다? 무한 접속 허용
			FileThread ft=new FileThread(sock); //접속자마다 thread만들어 준다.
			ft.start();//각 thread실행
			
		}
		
		//파일을 다운 받는 것은 개별로 이루어지는 일이기 때문에 thread에서 할 일이다.
		
	
		

	}

}
