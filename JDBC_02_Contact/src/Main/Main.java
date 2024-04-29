package Main;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import DAO.ContactDAO;
import DTO.ContactDTO;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		SimpleDateFormat formatter=new SimpleDateFormat("yy.MM.dd");
		ContactDAO manager=new ContactDAO();

		while(true) {
			try {
				System.out.println("==Contact System==");
				System.out.println("1. 신규 등록");
				System.out.println("2. 목록 출력");
				System.out.println("3. ID로 항목 삭제");
				System.out.println("4. ID로 항목 수정");
				System.out.println("5. name으로 항목 검색");
				System.out.println("0. 시스템 종료");
				System.out.print(">>");
				int menu=Integer.parseInt(sc.nextLine());
				if(menu==0) {
					System.exit(0);
				}else if(menu==1) {
					System.out.print("name>>");
					String name=sc.nextLine();
					System.out.print("phone>>");
					String phone=sc.nextLine();
					System.out.print("date(yy.mm.dd)>>");
					String datestr=sc.nextLine();
					Date date=formatter.parse(datestr);
					Timestamp ts = new Timestamp(date.getTime());

					int result=manager.addContact(new ContactDTO(0,name,phone,ts));

					if(result>0) {
						System.out.println(result+"입력 성공");
					}


				}else if(menu==2) {
					ArrayList<ContactDTO> list =manager.selectAll();
					if(list.size()==0) {
						System.out.println("연락처 목록이 비어있습니다.");
					}else {
						System.out.println("id\tname\tphone\t\tdate");
						for(ContactDTO dto:list) {
							System.out.println(dto.getId()
									+"\t"+dto.getName()
									+"\t"+dto.getPhone()
									+"\t"+formatter.format(dto.getDate()));
						}
					}

				}else if(menu==3) {
					System.out.print("삭제할 id를 입력하세요>>");
					int id=Integer.parseInt(sc.nextLine());
					int result=manager.deleteById(id);

					if(result>0) {
						System.out.println(result+"수정 성공");
					}
				}else if(menu==4) {
					System.out.print("수정할 id를 입력하세요>>");
					int id=Integer.parseInt(sc.nextLine());

					boolean check=manager.isContactExist(id);
					if(check==false) {
						System.out.println("수정할 id가 존재하지 않습니다.");
					}else {
						System.out.print("새로운 name 입력하세요>>");
						String name=sc.nextLine();

						System.out.print("새로운 phone 입력하세요>>");
						String phone=sc.nextLine();

						System.out.print("새로운 date 입력하세요>>");
						String datestr=sc.nextLine();
						Date date=formatter.parse(datestr);
						Timestamp ts = new Timestamp(date.getTime());

						int result=manager.updateById(id, name, phone, ts);

						if(result>0) {
							System.out.println(result+"수정 성공");
						}
					}

				}else if(menu==5) {
					System.out.print("검색할 name을 입력하세요>>");
					String name=sc.nextLine();
					ArrayList<ContactDTO> list =manager.searchByName(name);
					if(list.size()==0) {
						System.out.println("연락처 목록이 비어있습니다.");
					}else {
						System.out.println("id\tname\tphone\t\tdate");
						for(ContactDTO dto:list) {
							System.out.println(dto.getId()
									+"\t"+dto.getName()
									+"\t"+dto.getPhone()
									+"\t"+formatter.format(dto.getDate()));
						}
					}


				}else {
					System.out.println("메뉴를 다시 확인하세요.");
				}


			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("관리자에게 문의해주세요.");
			}
		}//while문

	}//main

}
