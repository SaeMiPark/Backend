package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReplyDAO;
import dto.ReplyDTO;

@WebServlet("*.reply")
public class ReplyController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd=request.getRequestURI();
		System.out.println(cmd);
		ReplyDAO dao=ReplyDAO.getInstance();
		try {
			if(cmd.equals("/add.reply")) {
				String writer=request.getParameter("writer");
				String contents=request.getParameter("contents");
				int parent_seq=Integer.parseInt(request.getParameter("parent_seq"));
				System.out.println(parent_seq);
				int result=dao.insert(new ReplyDTO(0,writer,contents,null,parent_seq));
				request.getRequestDispatcher("/detail.boards?seq="+parent_seq).forward(request, response);
			}else if(cmd.equals("/delete.reply")) {
				int replyseq=Integer.parseInt(request.getParameter("replyseq"));
				int boardseq=Integer.parseInt(request.getParameter("boardseq"));
				System.out.println(replyseq);
				int result=dao.deleteBySeq(replyseq);
				request.getRequestDispatcher("/detail.boards?seq="+boardseq).forward(request, response);
				
			}else if(cmd.equals("/update.reply")) {
				int replyseq=Integer.parseInt(request.getParameter("replyseq"));
				int boardseq=Integer.parseInt(request.getParameter("boardseq"));
				String replycontents=request.getParameter("replycontents");
				System.out.println(replycontents);
				int result=dao.updateBySeq(replyseq, replycontents);
				request.getRequestDispatcher("/detail.boards?seq="+boardseq).forward(request, response);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
