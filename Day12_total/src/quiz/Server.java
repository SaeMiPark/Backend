package quiz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Server {
	//서버==기능
	public static void main(String[] args) throws IOException {
		//접속, 연결
		ServerSocket server=new ServerSocket(26000);
		Socket sock=server.accept();
		//System.out.println(sock.getInetAddress()+"로부터 접속");

		//통로
		InputStream is=sock.getInputStream();
		DataInputStream dis=new DataInputStream(is);
		OutputStream os=sock.getOutputStream(); 
		DataOutputStream dos=new DataOutputStream(os);
		
		while(true) {
			String msg=dis.readUTF();

			if(msg.equals("1")) {
				int[] card=new int[45];
				int[] my=new int[6];

				//카드 번호 초기화
				for(int i=0; i<card.length; i++) {
					card[i]=i+1;
				}
				
				//카드 섞기
				for(int j=0; j<card.length*10; j++) {
					int x=(int)(Math.random()*45);//index값으로 돌리기
					int y=(int)(Math.random()*45);//0~44

					int tmp=card[x];
					card[x]=card[y];
					card[y]=tmp;
				}

				//내 로또 번호
				for(int i=0; i<6;i++) {//0~5, 6개
					my[i]=card[i];
				} 
				
				//로또 번호 내보내기
				dos.writeUTF(Arrays.toString(my));

			}else if(msg.equals("2")) {
				long time=System.currentTimeMillis();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
				String result=sdf.format(time);
				dos.writeUTF(result);
				
			}else if(msg.equals("3")) {
				//3가지 정도의 명언 중 랜덤 1개
				//String 배열 생성
				String[] strarr=new String[3];
				
				//배열 초기화
				strarr[0]="쉬울 때까지 어렵다.";
				strarr[1]="중요한 건 자신감이다.";
				strarr[2]="기다리면 보답이 오겠지요";
				
				//카드 섞기
				for(int j=0; j<strarr.length*10; j++) {
					int x=(int)(Math.random()*3);//index값으로 돌리기
					int y=(int)(Math.random()*3);//0~2

					String tmp=strarr[x];
					strarr[x]=strarr[y];
					strarr[y]=tmp;
				}
				
				//명언 내보내기
				dos.writeUTF(strarr[0]);
				
				
			}
		}


	}

}
