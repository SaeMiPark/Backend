package quiz;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Server {
	public static void main(String[] args) throws IOException, ParseException {
		//접속, 연결
		ServerSocket server=new ServerSocket(26000);
		System.out.println("접속 대기 중");
		Socket sock=server.accept();
		System.out.println("접속 성공");

		//통로
		//client는 ois 먼저 와야 한다 순서 중요★
		ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream()); 
		ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());	
		
		
		//DAO
		MovieDAO dao=new MovieDAO();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy.MM.dd");

		while(true) {
			String msg=ois.readUTF();
			//System.out.println("Client : " + msg);

			if(msg.equals("1")) {
				String id=ois.readUTF();
				String title=ois.readUTF();
				String genre=ois.readUTF();
				String strdate=ois.readUTF();
				Date date=sdf.parse(strdate);
				dao.addMovie(new MovieDTO(id, title, genre, date)); 

			}else if(msg.equals("2")) {
				ArrayList<MovieDTO> mvs=dao.getMovies();
				//System.out.println(mvs.size());
				oos.writeObject(mvs);
				oos.flush();
				oos.reset(); //이전에 기록된 객체의 참조를 잊고 상태를 재설정
				
			}else if(msg.equals("3")) {
				String title=ois.readUTF();
				ArrayList<MovieDTO> findmvs=dao.searchByTitle(title);
				oos.writeObject(findmvs);
				oos.flush();
				
			}else if(msg.equals("4")) {
				String id=ois.readUTF();
				boolean check=dao.deleteById(id);
				oos.writeBoolean(check);
				oos.flush();
				
			}else if(msg.equals("5")) {
				String id=ois.readUTF();
				String modifytitle=ois.readUTF();
				String modifygenre=ois.readUTF();
				String strdate=ois.readUTF();
				Date modifydate=sdf.parse(strdate);
				
				dao.modifyById(id, modifytitle, modifygenre, modifydate);
			}
		}



	}

}
