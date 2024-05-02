package VIEW;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import DAO.BoardManager;
import DAO.LoginManager;
import DTO.BoardDTO;
import DTO.MembersDTO;

public class MiniBoardMain {

	public static String id="";
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		LoginManager loginmanager=new LoginManager();
		BoardManager boardmanager=new BoardManager();
		SimpleDateFormat sdf=new SimpleDateFormat("yy.MM.dd");

		try{
			while(true) {
				System.out.println("<<Mini Board 인증>>");
				System.out.println("1. 로그인");
				System.out.println("2. 회원가입");
				System.out.println("0. 시스템 종료");
				System.out.print(">>");
				String menu=sc.nextLine();
				if(menu.equals("1")) {
					System.out.print("id>>");
					//전역 변수 선언
					MiniBoardMain.id= sc.nextLine();
					System.out.print("pw>>");
					String pw=sc.nextLine();

					boolean result=loginmanager.loginmember(id, pw);
					if(result==true) {
						System.out.println("로그인 성공");
						break;
					}else {
						System.out.println("로그인 실패");	
					}


				}else if(menu.equals("2")) {
					System.out.print("id>>");
					String id2=sc.nextLine();
					System.out.print("pw>>");
					String pw=sc.nextLine();
					System.out.print("name>>");
					String name=sc.nextLine();
					Timestamp join_date=new Timestamp(System.currentTimeMillis());

					int result=loginmanager.addmember(new MembersDTO(id2,pw,name,join_date));
					if(result>0) {
						System.out.println(result+"회원가입 성공");
					}else {
						System.out.println("회원가입 실패");
					}


				}else if(menu.equals("0")) {
					System.exit(0);
					System.out.println("시스템을 종료합니다.");
				}else {
					System.out.println("메뉴를 다시 확인하세요.");
				}

				//로그인에 성공해야만 다음을 진행한다.
				//작성자는 static 변수를 사용해서 앞에 로그인 내용을 가지고 있을 것.

			}//미니보드인증 while문

			while(true) {
				System.out.println("<<Mini Board>>");
				System.out.println("1. 글 작성하기");
				System.out.println("2. 글 목록보기");
				System.out.println("3. 글 검색하기");
				System.out.println("4. 글 수정하기");
				System.out.println("5. 글 삭제하기");
				System.out.println("0. 시스템 종료");
				System.out.print(">>");
				String menu=sc.nextLine();

				if(menu.equals("1")) {
					System.out.print("작성할 내용을 입력하세요>>");
					String text=sc.nextLine();
					Timestamp write_date=new Timestamp(System.currentTimeMillis());

					boardmanager.addBoard(0, MiniBoardMain.id, text, write_date);

				}else if(menu.equals("2")) {
					ArrayList<BoardDTO> list=boardmanager.selectAll();
					System.out.println("글 번호\t작성자\t글 내용\t작성날짜");
					if(list.size()>0) {
						for(BoardDTO dto: list) {
							System.out.println(dto.getSeq()+"\t"+
									dto.getWriter()+"\t"+
									dto.getContents()+"\t"+
									sdf.format(dto.getWrite_date()));
						}
					}else {
						System.out.println("목록이 비어있습니다.");
					}


				}else if(menu.equals("3")) {
					System.out.print("검색하고 싶은 작성자 이름>>");
					String searchid=sc.nextLine();

					ArrayList<BoardDTO> list=boardmanager.searchById(searchid);
					System.out.println("글 번호\t작성자\t글 내용\t작성날짜");
					if(list.size()>0) {
						for(BoardDTO dto: list) {
							System.out.println(dto.getSeq()+"\t"+
									dto.getWriter()+"\t"+
									dto.getContents()+"\t"+
									sdf.format(dto.getWrite_date()));
						}
					}else {
						System.out.println("목록이 비어있습니다.");
					}

				}else if(menu.equals("4")) {
					System.out.print("수정할 글 번호를 입력>>");
					int modifyid=Integer.parseInt(sc.nextLine());
					//id체크
					boolean idcheck=boardmanager.isIdExist(modifyid);
					
					if(idcheck==false) {
						System.out.println("수정할 id가 존재하지 않습니다.");
						continue;
					}
					
					System.out.print("새로운 작성자 memberid>>");
					String id=sc.nextLine();
					System.out.print("새로운 내용 입력>>");
					String contents=sc.nextLine();
					
					//날짜
					Timestamp write_date=new Timestamp(System.currentTimeMillis());
					int result=boardmanager.updateById(modifyid, id, contents, write_date);
					if(result>0) {
						System.out.println(result+"수정 성공");
					}else {
						System.out.println("수정 실패");
					}

				}else if(menu.equals("5")) {
					System.out.print("삭제할 글 번호를 입력하세요>>");
					int deletesid=Integer.parseInt(sc.nextLine());
					int result=boardmanager.deleteById(deletesid);
					if(result>0) {
						System.out.println(result+"삭제 성공");
					}else {
						System.out.println("삭제 실패");
					}

				}else if(menu.equals("0")) {
					System.out.println("시스템을 종료합니다.");
					System.exit(0);

				}else {
					System.out.println("메뉴를 다시 확인하세요.");
				}

			}//미니보드 


		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("관리자에게 문의하세요.");
		}//try-catch

	}

}
