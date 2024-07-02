package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dto.MovieDTO;


@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getRequestURI();
		Gson g=new Gson();
		
		if(cmd.equals("/exam01.ajax")) {
			System.out.println("단순요청확인");
		}else if(cmd.equals("/exam02.ajax")) {
			String param1=request.getParameter("key1");
			String param2=request.getParameter("key2");
			System.out.println(param1+param2);
		}else if(cmd.equals("/exam03.ajax")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter pw=response.getWriter();
			pw.append("ajax 응답 데이터입니다.");
		}else if(cmd.equals("/exam04.ajax")) {
			response.setContentType("text/html; charset=UTF-8");
			
			String[] fruits=new String[] {"Orange", "mango","apple"};
			PrintWriter pw=response.getWriter();
			
			//fruits.toString() 주소값
			//pw.append("[\""+fruits[0]+"\"]"); //직렬화 자기꺼->문자열로
			
			//gson 직렬화 라이브러리 사용
			String result=g.toJson(fruits);
			pw.append(result);
		}else if(cmd.equals("/exam05.ajax")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter pw=response.getWriter();
			
			MovieDTO dto=new MovieDTO(1001,"범죄도시3","액션");
			String result=g.toJson(dto);
			pw.append(result);
		}else if(cmd.equals("/exam06.ajax")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter pw=response.getWriter();
			
			List<MovieDTO> list=new ArrayList<>();
			list.add(new MovieDTO(1001,"범죄도시3","액션"));
			list.add(new MovieDTO(1002,"범죄도시4","액션"));
			list.add(new MovieDTO(1003,"범죄도시5","액션"));
			String result=g.toJson(list);
			pw.append(result);
		}else if(cmd.equals("/exam07.ajax")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter pw=response.getWriter();
			//dto타입이 없는 상황에서 객체를 반환할 때
			JsonObject obj=new JsonObject();
			obj.addProperty("fruits", "apple");
			obj.addProperty("title", "범죄도시");
			String result=g.toJson(obj);
			pw.append(result);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
