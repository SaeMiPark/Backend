package exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class FileThread extends Thread{

	private Socket client;


	public FileThread(Socket client) {
		this.client=client;

	}

	public void run(){
		try {
			DataInputStream dis=new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());


			//폴더 파일리스트 길이를 내보내주기
			File home=new File("C:/workspace/libs");
			File[] list=home.listFiles();
			dos.writeInt(list.length);

			for(File f : list) {
				dos.writeUTF(f.getName()); //파일명을 보내준다.
			}
			dos.flush();

			//파일명 받기
			String filename=dis.readUTF();

			//하드디스크에서 파일명으로 꺼내오기
			//1. 공간을 확보할 사이즈 받아오기(파일 객체 사용)
			File file=new File("C:/workspace/libs/"+filename);
			//2. 사이즈만큼 ram의 공간 확보+ cilent에도 사이즈 알려주기
			byte[] b=new byte[(int)file.length()];
			dos.writeLong(file.length());
			//3. ram에 내용을 저장해주기
			FileInputStream fis=new FileInputStream("C:/workspace/libs/"+filename);
			DataInputStream fileDis=new DataInputStream(fis);
			fileDis.readFully(b); //내용 저장 readFully 읽어서 채워라?
			//바로 위의 코드를 통해 내용이 byte[] b에 저장되었기 때문에 닫아줘도 된다.
			
			//dis.close(); 여기 위치 안 된다.
			dos.write(b);
			dos.flush();
			dos.close();
			fileDis.close(); 
			fis.close();
			dis.close();
		}catch(Exception e) {
			System.exit(0);
		}

	}


}
