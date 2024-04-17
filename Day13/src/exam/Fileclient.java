package exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Fileclient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket sock= new Socket("192.168.0.10",27000);
		
		InputStream is=sock.getInputStream();
		OutputStream os=sock.getOutputStream();
		DataInputStream dis=new DataInputStream(is);
		DataOutputStream dos=new DataOutputStream(os);
		
		//파일리스트의 길이 받아오기
		int lg=dis.readInt();
		System.out.println(lg);
		
		for(int i=0; i<lg; i++) {
			String str=dis.readUTF(); //파일명 받아오기
			System.out.println(str);
		}
		String filename="cat.txt";
		
		dos.writeUTF(filename); //검색할 파일명 보내기
		
		//하드디스트(SSD)의 파일을 ram으로 복사하는 작업이 필요하다==로딩은 복사!!
		//cpu는 오직 ram만 처리할 수 있다
		
		//Stream 하드디스크와 ram연결할 때도 사용할 수 있다.
		//stream은 크게 생각하면 서로 다른 장비간에 데이터를 주고받는 통로이다.
		
		//서버==ram, 파일==하드디스트
		//FileStream
		//주인공은 ram이다. 
		//stram의 방향성은 input이냐 output이냐는 ram이 결정
		
		//서버내용
		//FileInputStream fis=new FileInputStream(path+targetFileName);
		//FileInputStream fis=new FIleInputStream(??);
		//DataInputStream fileDis=new DataInputStream(fis);
		
		//readFully메소드 전체 읽어볼래 작은 파일 전송시에는 편함
		//ram에도 공간이 필요하기 때문에 readFully메소드의 리턴값인 바이트 배열을 미리 준해놔야 한다.
		//byte[] fileContents=new byte[int형만 올 수 있다]; 사이즈 어떻게 해?
		//파일인스턴스를 만들어서 파일 객체를 만들어서 사이즈를 가져올 수 있음
		//파일스트림은 닫아주는게 좋다. 소켓도 엄밀히 말하면 닫아주는게 좋다		
		
		long flength=dis.readLong(); //저장할 파일의 공간 확보를 위한 사이즈 받아오기
		byte[] b = new byte[(int)flength]; //공간 확보
		dis.readFully(b);//내용 저장
		
		//하드디스크로 내용 내보내기
		FileOutputStream fos= new FileOutputStream("C:/workspace/libs/"+"cat.txt");//저장할 곳, 저장할 이름 설정
		DataOutputStream fdos=new DataOutputStream(fos);
		fdos.write(b); //파일스트림을 사용해서 보내야한다. 하드디스트와 램의 연결이기 때문에
		fdos.flush();

		fdos.close();
		fos.close();	
		
		
	}

}
