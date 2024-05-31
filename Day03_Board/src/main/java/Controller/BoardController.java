package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.BoardConfig;
import dao.BoardDAO;
import dao.ReplyDAO;
import dto.BoardDTO;
import dto.ReplyDTO;

@WebServlet("*.boards")
public class BoardController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd=request.getRequestURI();
		System.out.println(cmd);
		BoardDAO dao=BoardDAO.getInstance();
		ReplyDAO replydao=ReplyDAO.getInstance();
		try {
			if(cmd.equals("/list.boards")){
				String pcpage=request.getParameter("cpage");
				if(pcpage==null) {pcpage="1";}
				
				int cpage=Integer.parseInt(pcpage);
				String pageNavi=dao.getPageNavi(cpage);
				request.setAttribute("pageNavi", pageNavi);
				
				//1페이지 안의 페이지 번호들: 1-29, 2페이지 안의 페이지 번호들:30-59, 3페이지 안의 페이지 번호들:60-89
				//페이지를 선택했을 때 보여주는 DB행의 수...
				ArrayList<BoardDTO> list=
						dao.selectNtoM(
								cpage*BoardConfig.RECOD_COUNT_PER_PAGE-(BoardConfig.RECOD_COUNT_PER_PAGE-1),
								cpage*BoardConfig.RECOD_COUNT_PER_PAGE);//리스트의 시작, 리스트의 마지막
				request.setAttribute("list", list);
				
				request.getRequestDispatcher("/board/list.jsp").forward(request, response);
			}else if(cmd.equals("/insert.boards")) {
				String writer=(String)request.getSession().getAttribute("loginID");
				String title=request.getParameter("title");
				System.out.println(title);
				String contents=request.getParameter("contents");
				System.out.println(contents);
				int result=dao.insert(new BoardDTO(0,writer, title, contents, null, 0));
				response.sendRedirect("/list.boards");
				
			}else if(cmd.equals("/detail.boards")) {
				int seq=Integer.parseInt(request.getParameter("seq"));
				BoardDTO dto=dao.selectcontent(seq);
				request.setAttribute("dto", dto);
				dao.updateviewcout(seq);
				
				ArrayList<ReplyDTO> replylist=replydao.selectAll();
				request.setAttribute("replylist", replylist);
				
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
			}
			
			
			else if(cmd.equals("/currentpage.boards")) {
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
