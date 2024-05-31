package servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieDAO;
import dto.MovieDTO;

@WebServlet("*.movies")
public class MoviesController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getRequestURI();
		System.out.println(cmd);
		System.out.println("모든 요청 수량 확인");
		MovieDAO dao=MovieDAO.getInstance();
		try {
			if(cmd.equals("/insertservlet.movies")) {
				String title=request.getParameter("title");
				String genre=request.getParameter("genre");
				Timestamp opendate=new Timestamp(System.currentTimeMillis());
				int result=dao.insert(new MovieDTO(0, title, genre, opendate));
				response.sendRedirect("inputview.jsp");
				
			}else if(cmd.equals("/etcservlet.movies")) {
				ArrayList<MovieDTO> list = dao.selectAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("outputview.jsp").forward(request, response);
				
			}else if(cmd.equals("/UpdateServlet.movies")) {
				String strid=request.getParameter("id");
				int intid=Integer.parseInt(strid);
				String title=request.getParameter("title");
				String genre=request.getParameter("genre");
				Timestamp opendate=new Timestamp(System.currentTimeMillis());
				int result=dao.updateById(intid, title, genre, opendate);
				response.sendRedirect("etcservlet.movies");
				
			}else if(cmd.equals("/DeleteServlet.movies")) {
				String strid=request.getParameter("id");
				int intid=Integer.parseInt(strid);
				int result=dao.deleteById(intid);
				response.sendRedirect("etcservlet.movies");
				
			}
		} catch (Exception e) {
			e.printStackTrace(); //개발자가 보게 될 화면
			response.sendRedirect("error.jsp"); //사용자가 보게 될 화면
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
