package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import commons.EncryptionUtils;
import dao.MembersDAO;
import dto.MembersDTO;


@WebServlet("*.members")
public class MembersController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String cmd=request.getRequestURI();
		System.out.println(cmd);
		MembersDAO dao=MembersDAO.getInstance();
		try {
			if(cmd.equals("/idcheck.members")) {
				String id=request.getParameter("id");
				System.out.println(id);
				boolean idcheck=dao.isIdExist(id);
				System.out.println(idcheck);
				request.setAttribute("result", idcheck);
				request.getRequestDispatcher("/members/idcheck.jsp").forward(request, response);
				
			}else if(cmd.equals("/signup.members")) {
				String id=request.getParameter("id");
				String pw=EncryptionUtils.getSHA512(request.getParameter("pw"));
				String name=request.getParameter("name");
				String phone=request.getParameter("phone");
				String email=request.getParameter("email");
				String zipcode=request.getParameter("zipcode");
				String address1=request.getParameter("address1");
				String address2=request.getParameter("address2");
			
				int insertresult=dao.insert(new MembersDTO(id,pw,name,phone,email,zipcode,address1,address2,null));
				response.sendRedirect("/index.jsp");
				
			}else if(cmd.equals("/login.members")) {
				String id=request.getParameter("id");
				String pw= EncryptionUtils.getSHA512(request.getParameter("pw"));
				boolean loginresult =dao.isLoginExist(id,pw);
				
				if(loginresult) {
					HttpSession session=request.getSession(); 
					session.setAttribute("loginID", id);
				}
				response.sendRedirect("/index.jsp");
				
			}else if(cmd.equals("/logout.members")) {
				HttpSession session=request.getSession();
				session.invalidate(); 
				response.sendRedirect("/index.jsp");
				
			}else if(cmd.equals("/memberout.members")) {
				HttpSession session=request.getSession();
				String id=(String)session.getAttribute("loginID");
				int result=dao.deleteById(id); //DB삭제
				session.invalidate(); //세션 초기화
				System.out.println(result+"삭제 완료");
				response.sendRedirect("/index.jsp"); 
				
			}else if(cmd.equals("/mypage.members")) { 
				HttpSession session=request.getSession();
				String id=(String)session.getAttribute("loginID");
				MembersDTO dto =dao.searchById(id);
				request.setAttribute("dto", dto);
				request.getRequestDispatcher("/members/mypage.jsp").forward(request, response);
			}else if(cmd.equals("/update.members")) {
				String name=request.getParameter("hiddenname");
				String id=request.getParameter("hiddenid");
				String phone=request.getParameter("hiddenphone");
				String email=request.getParameter("hiddenemail");
				String zipcode=request.getParameter("hiddenzipcode");
				String address1=request.getParameter("hiddenaddress1");
				String address2=request.getParameter("hiddenaddress2");
				System.out.println(name);
				
				
				int result=dao.updateById(id, name, phone, email, zipcode, address1, address2);
				response.sendRedirect("/index.jsp");
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
