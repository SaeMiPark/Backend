package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dao.ReplyDAO;
import dto.ReplyDTO;

@WebServlet("*.reply")
public class ReplyController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		Gson g=new Gson();
		
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
				ReplyDTO cdto=dao.insert(new ReplyDTO(0,writer,contents,null,parent_seq));
				PrintWriter pw=response.getWriter();
				pw.append(g.toJson(cdto));
			
			}else if(cmd.equals("/select.reply")) {
				//받은 정보
				int parent_seq=Integer.parseInt(request.getParameter("seq"));
				String loginID=(String)request.getSession().getAttribute("loginID"); //ajax에서 쓸 수 있나?
				
				//보낼 정보
				PrintWriter pw=response.getWriter();
				ArrayList<ReplyDTO> replylist=dao.selectAll();
				
				//직렬화
				JsonObject obj=new JsonObject();
				obj.addProperty("loginID", loginID);
				obj.add("replylist", g.toJsonTree(replylist)); //이게 뭘까?
				String result=g.toJson(obj);
				pw.append(result);
				
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
