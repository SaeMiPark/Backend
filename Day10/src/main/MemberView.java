package main;
import java.util.ArrayList;
import java.util.Scanner;

import DAO.MemberDAO;
import classes.*;

public class MemberView {
	public static void main(String[] args) {
		MemberDAO manager=new MemberDAO();
		Scanner sc= new Scanner(System.in);
		
		while(true) {
			System.out.println("<<회원 관리 시스템>>");
			System.out.println("1. 신규 회원 등록");
			System.out.println("2. 회원 목록 출력");
			System.out.println("3. 포인트 더하기");
			System.out.println("0. 시스템 종료");
			System.out.print(">> ");
			int menu=Integer.parseInt(sc.nextLine());

			if(menu==0) {
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			}else if(menu==1) {
				manager.addMember(new Silver("1001","Tom",1000));
				manager.addMember(new Silver("1002","Susan",2000));
				manager.addMember(new Gold("1003","Mike",3000));
				//중간에 삭제한 null이 있어도, 뒤에 플러스가 된다.
			}else if(menu==2) {
				ArrayList<Member> arr=manager.getMembers();
				System.out.println("ID\tName\tPoint\tBonus");
				for(Member mem : arr) {
					System.out.println(mem.getId()+"\t"
							+mem.getName()+"\t"
							+mem.getPoint()+"\t"+
							mem.getBonus());
				}
			}else {
				System.out.println("메뉴를 다시 확인해주세요.");
			}
		}
	}

}
