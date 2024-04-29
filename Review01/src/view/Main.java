package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.CafeDAO;
import DTO.CafeDTO;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		CafeDAO dao=new CafeDAO();

		while(true) {
			//따로 말고 전체로 try-catch문을 잡을 수도 있다.
			try {
				System.out.println("<<cafe>>");
				System.out.println("1. 신규 메뉴 등록");
				System.out.println("2. 메뉴 목록 출력");
				System.out.println("3. 메뉴 검색(name)");
				System.out.println("4. 메뉴 삭제(id)");
				System.out.println("5. 메뉴 수정(id)");
				System.out.println("0. 시스템 종료");
				System.out.print(">>");

				int menu=Integer.parseInt(sc.nextLine());

				if(menu==0) {
					System.out.println("시스템을 종료합니다.");
					System.exit(0);
				}else if(menu==1) {
					System.out.print("name 입력하세요>>");
					String name=sc.nextLine();
					System.out.print("price 입력하세요>>");
					int price=Integer.parseInt(sc.nextLine());
					int result=dao.adddto(new CafeDTO(0,name,price));

					if(result>0) {
						System.out.println(result+"입력 성공");
					}

				}
				else if(menu==2) {
					List<CafeDTO> list=dao.selectAll();
					if(list.size()==0) {
						System.out.println("찾는 메뉴가 존재하지 않습니다.");
						continue;
					}else {
						System.out.println("ID\tNAME\tPRICE");
						for(CafeDTO dto:list) {
							System.out.println(dto.getId()+"\t"
									+dto.getName()+"\t"
									+dto.getPrice());
						}
					}

				}
				else if(menu==3) {
					System.out.print("검색할 메뉴 이름을 입력하세요>>");
					String searchname=sc.nextLine();
					ArrayList<CafeDTO> findlist=dao.searchByName(searchname);
					if(findlist.size()==0) {
						System.out.println("찾는 메뉴가 존재하지 않습니다.");
						continue;
					}else {                                
						for(CafeDTO dto:findlist) {
							System.out.println(dto.getId()+"\t"
									+dto.getName()+"\t"
									+dto.getPrice());
						}
					}
				}else if(menu==4) {
					System.out.print("삭제할 id 입력하세요>>");
					int deleteid=Integer.parseInt(sc.nextLine());

					boolean idcheck=dao.isIdExist(deleteid);

					if(idcheck==false) {
						System.out.println("수정 할 대상이 없습니다.");
					}else {
						int result=dao.deleteById(deleteid);
						if(result>0) {
							System.out.println(result+"삭제 성공");
						}else {
							System.out.println("삭제할 대상이 존재하지 않습니다.");
						}
					}
				}else if(menu==5) {
					System.out.print("수정 할 대상의 id 입력하세요>>");
					int modifyid=Integer.parseInt(sc.nextLine());

					//대상이 존재하는지 검사 후, 존재하면 다음 입력을 진행한다.
					boolean idcheck=dao.isIdExist(modifyid);
					if(idcheck==false) {
						System.out.println("수정 할 대상이 없습니다.");

					}else {
						System.out.print("수정 할 name 입력하세요>>");
						String name=sc.nextLine();

						System.out.print("수정 할 price 입력하세요>>");
						int price=Integer.parseInt(sc.nextLine());

						int result=dao.updateById(modifyid,name,price);

						if(result>0) {
							System.out.println(result+" 입력 성공");
						}
					}
				}
			}catch(Exception e) {
				
				e.printStackTrace();
			}

		}//while
	}//main
}//class
