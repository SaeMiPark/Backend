package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MessageDAO;
import dto.MessageDTO;


@WebServlet("*.messages")
public class MessagesController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MessageDAO dao=MessageDAO.getInstance();
		String cmd=request.getRequestURI();
		System.out.println(cmd);
		System.out.println("모든 요청 수량 확인");
		
		try {
			
			if(cmd.equals("/InputServlet.messages")) {
				String writer=request.getParameter("writer");
				String contents=request.getParameter("contents");
				Timestamp write_date=new Timestamp(System.currentTimeMillis());
				int result=dao.addMessage(new MessageDTO(0, writer, contents, write_date));
				response.sendRedirect("inputview.jsp");
				
			}else if(cmd.equals("/OutputServlet.messages")) {
				ArrayList<MessageDTO> list = dao.selectAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("outputview.jsp").forward(request, response);
				
			}else if(cmd.equals("/UpdateServlet.messages")) {
				String strid=request.getParameter("id");
				int intid=Integer.parseInt(strid);
				String writer=request.getParameter("writer");
				String contents=request.getParameter("contents");
				Timestamp write_date=new Timestamp(System.currentTimeMillis());
				int result=dao.updateById(intid, writer, contents, write_date);
				response.sendRedirect("/OutputServlet.messages");
				
			}else if(cmd.equals("/DeleteServlet.messages")) {
				String strid=request.getParameter("id");
				int intid=Integer.parseInt(strid);
				int result=dao.deleteById(intid);
				response.sendRedirect("/OutputServlet.messages");
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp"); //사용자가 보게 될 화면
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
