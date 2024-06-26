import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import commons.Statics;

public class Server {
	public static void main(String[] args)  {
		try {
			MembersDAO manager=new MembersDAO();
			ServerSocket  server=new ServerSocket(30000); 

			while(true) {
				Socket sock=server.accept();  //while문 안에 들어와야함

				//통로
				InputStream is=sock.getInputStream();
				DataInputStream dis=new DataInputStream(is);
				OutputStream os=sock.getOutputStream(); 
				DataOutputStream dos=new DataOutputStream(os);

				//메뉴받기
				String menu=dis.readUTF();

				//로그인
				if(menu.equals("1")) {
					String id=dis.readUTF();
					String pw=Statics.getSHA512(dis.readUTF());
					boolean result=manager.login(id, pw);

					if(result) {
						dos.writeUTF("로그인 성공");
						dos.flush();
					}else {
						dos.writeUTF("로그인 실패");
						dos.flush();
					}
					System.out.println(id+pw);
					System.out.println(result);

				//회원 가입
				}else if(menu.equals("2")) {
					String id=dis.readUTF();
					String pw=Statics.getSHA512(dis.readUTF());
					String name=dis.readUTF();
					int result=manager.insert(id, pw, name);
					if(result>0) {
						dos.writeUTF("회원가입 성공");
						dos.flush();
					}else {
						dos.writeUTF("회원가입 실패");
						dos.flush();
					}
					System.out.println(id+pw+name);
					System.out.println(result);
				}

			}

		}catch(Exception e) {
			e.printStackTrace();

		}

	}
}
