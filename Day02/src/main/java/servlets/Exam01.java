package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//annotation 
//클라이언트가 서블릿을 원한다면 이걸 사용해야함
@WebServlet("/Exam01")
public class Exam01 extends HttpServlet {  
	
//	protected 상속 관계에서 이 메서드를 오버라이딩 하는 것을 추천하는 의미로 많이 쓴다.
//  request 보내주는 애 톰캣
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath()); 결국 최종 처리
		String writer=request.getParameter("writer");
		String message=request.getParameter("message");
		System.out.print(writer+message);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 받은 거 처리
		System.out.println("post방식 요청 확인");
		String writer=request.getParameter("writer");
		String message=request.getParameter("message");
		System.out.print(writer+message);
		//2. 응답 보내기
		PrintWriter pw= response.getWriter();
		pw.append("<html>");
		pw.append("<body>");
		pw.append("process Complete");
		pw.append("<button id='ok'> OK");
		pw.append("</button>");
		pw.append("<script>document.getElementById('ok').onclick"
				+ "=function(){location.href='/index.html'}</script>");
		pw.append("</body>");
		pw.append("</html>");
	}

}
