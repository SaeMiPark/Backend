package Controller;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.FileDAO;
import dto.FileDTO;


@WebServlet("*.file")
public class FileController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			FileDAO dao=FileDAO.getInstance();
			String cmd=request.getRequestURI();


			if(cmd.equals("/upload.file")) {
				//파일전송
				int maxSize=1024*1024*10; //10메가 사이즈 용량제한
				String realPath=request.getServletContext().getRealPath("files");	//파일 저장 위치
				File uploadPath=new File(realPath); //파일인스턴스로 생성해 단순 문자열이 아닌 컨트롤할 수 있도록 변경
				if(!uploadPath.exists()) {
					uploadPath.mkdir(); //파일 업로드 폴더가 존재하지 않을 경우 직접 생성하는 코드
				}
				System.out.println(realPath);
				MultipartRequest multi=new MultipartRequest(request, realPath, maxSize, "UTF8", new DefaultFileRenamePolicy());
				//multipartform안의 데이터는 multi.getParameter로 받아올 수 있다.
				//String message=multi.getParameter("message");
				//System.out.println("클라이언트 메세지:"+message);

				String oriName=multi.getOriginalFileName("file"); //업로드 당시 파일 이름
				String sysName=multi.getFilesystemName("file"); //저장된 파일 이름
				if(oriName!=null) {
					dao.insert(new FileDTO(0,oriName,sysName,0));
				}
				response.sendRedirect("/index.jsp");

			}else if(cmd.equals("/list.file")) {
				ArrayList<FileDTO> list=dao.selectAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}else if(cmd.equals("/download.file")) {
				String filepath=request.getServletContext().getRealPath("files"); //HDD위치 확보
				String sysname=request.getParameter("sysname");//파일 이름 확보
				String oriname=request.getParameter("oriname");
				
				oriname=new String(oriname.getBytes("UTF8"), "ISO-8859-1");
				response.reset();
				response.setHeader("Content-Disposition", "attachment;filename=\""+oriname+"\""); //내가 너한테 보내는건 attachment=첨부파일이야
				
				File target=new File(filepath+"/"+sysname); //완전 경로 만들기
				byte[] fileContents = new byte[(int)target.length()];//HDD에 저장할 배열 준비
				
				try(FileInputStream fis=new FileInputStream(target);//HDD 연결
					DataInputStream dis=new DataInputStream(fis);//타켓파일에 스트림 연결
					ServletOutputStream sos= response.getOutputStream(); //클라이언트에게 데이터를 보낼 수 있는 스트림 개발
					){
					dis.readFully(fileContents); //RAM으로 복사
					sos.write(fileContents);//파일 내용 전송
					sos.flush();
				}
			}


		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
