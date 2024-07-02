package Controller;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import commons.BoardConfig;
import dao.BoardDAO;
import dao.FileDAO;
import dao.ReplyDAO;
import dto.BoardDTO;
import dto.FileDTO;
import dto.ReplyDTO;

@WebServlet("*.boards")
public class BoardController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		Gson g=new Gson();
		
		request.setCharacterEncoding("UTF-8");
		String cmd=request.getRequestURI();
		System.out.println(cmd);
		BoardDAO dao=BoardDAO.getInstance();
		ReplyDAO replydao=ReplyDAO.getInstance();
		FileDAO filedao=FileDAO.getInstance();
		
		try {
			if(cmd.equals("/list.boards")){
				String pcpage=request.getParameter("cpage");
				if(pcpage==null) {pcpage="1";}
				
				int cpage=Integer.parseInt(pcpage);
				request.setAttribute("cpage", cpage);
				request.setAttribute("record_count_per_page", BoardConfig.RECOD_COUNT_PER_PAGE);
				request.setAttribute("navi_count_per_page", BoardConfig.NAVI_COUNT_PER_PAGE);
				request.setAttribute("record_total_count", dao.getRecordCount());
				
				//1페이지 안의 페이지 번호들: 1-29, 2페이지 안의 페이지 번호들:30-59, 3페이지 안의 페이지 번호들:60-89
				ArrayList<BoardDTO> list=
						dao.selectNtoM(
								cpage*BoardConfig.RECOD_COUNT_PER_PAGE-(BoardConfig.RECOD_COUNT_PER_PAGE-1),
								cpage*BoardConfig.RECOD_COUNT_PER_PAGE);//리스트의 시작, 리스트의 마지막
				request.setAttribute("list", list);
				request.getRequestDispatcher("/board/list.jsp").forward(request, response);
				
			}else if(cmd.equals("/insert.boards")) {
				String writer=(String)request.getSession().getAttribute("loginID");
				int maxSize=1024*1024*10; //10메가 사이즈 용량제한
				String realPath=request.getServletContext().getRealPath("files");	//파일 저장 위치
				File uploadPath=new File(realPath); //파일인스턴스로 생성해 단순 문자열이 아닌 컨트롤할 수 있도록 변경
				if(!uploadPath.exists()) {
					uploadPath.mkdir(); //파일 업로드 폴더가 존재하지 않을 경우 직접 생성하는 코드
				}
				System.out.println(realPath);
				
				MultipartRequest multi=new MultipartRequest(request, realPath, maxSize, "UTF8", new DefaultFileRenamePolicy());
				
				String title=multi.getParameter("title");
				System.out.println("제목"+title);
				String contents=multi.getParameter("contents");
				int parent_seq=dao.insert(new BoardDTO(0,writer, title, contents, null, 0));
				
				String oriName=multi.getOriginalFileName("file"); //업로드 당시 파일 이름
				String sysName=multi.getFilesystemName("file"); //저장된 파일 이름
				filedao.insert(new FileDTO(0, oriName, sysName, parent_seq));
				response.sendRedirect("/list.boards");
				
			}else if(cmd.equals("/detail.boards")) {
				int seq=Integer.parseInt(request.getParameter("seq"));
				BoardDTO dto=dao.selectcontent(seq);
				ArrayList<FileDTO> filelist=filedao.selectAll();
				request.setAttribute("dto", dto);
				request.setAttribute("filelist", filelist);
				dao.updateviewcout(seq);
				request.getRequestDispatcher("/board/contents.jsp").forward(request, response);
				
			}else if(cmd.equals("/delete.boards")) {
				int seq=Integer.parseInt(request.getParameter("seq"));
				int result=dao.deleteBySeq(seq);
				response.sendRedirect("/list.boards");
				
			}else if(cmd.equals("/update.boards")) {
				int seq=Integer.parseInt(request.getParameter("seq"));
				String title=request.getParameter("title");
				String contents=request.getParameter("contents");
				int result=dao.updateBySeq(seq,title,contents);
				response.sendRedirect("/list.boards");
				
			}else if(cmd.equals("/currentpage.boards")) {
				int seq=Integer.parseInt(request.getParameter("seq"));
				String title=request.getParameter("title");
				String contents=request.getParameter("contents");
				int result=dao.updateBySeq(seq,title,contents);
				response.sendRedirect("/list.boards");
				
			}


		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("/error.jsp");
		}



	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
