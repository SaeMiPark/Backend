package quies;

import java.util.Scanner;

import classes.Contact;
import models.ContactManager;

//연락처 관리 프로그램
public class Quiz03 {
	public static Scanner sc=new Scanner(System.in);
	static ContactManager manager=new ContactManager();
	
	public static int printMenu() {
		System.out.println("\n====연락처 관리 프로그램====");
		System.out.println("1. 신규 연락처 등록");
		System.out.println("2. 연락처 목록 출력");
		System.out.println("3. 연락처 검색");
		System.out.print(">>");
		int menu=Integer.parseInt(sc.nextLine());
		return menu;
	}
	
	public static void createContact() {
		String id, name, phone;
		System.out.print("id를 입력하세요>>");
		id=sc.nextLine();
		System.out.print("name을 입력하세요>>");
		name=sc.nextLine();
		System.out.print("phone을 입력하세요>>");
		phone=sc.nextLine();
		
		manager.addContact(new Contact(id, name, phone));
	}
	
	public static void printContact() {
		Contact[] cts=manager.getContacts();
		if(manager.getIndex()==0) {
			System.out.println("검색할 목록이 없습니다.");
		}
		System.out.println("id\t이름\t핸드폰번호\t");
		for(int i=0; i<manager.getIndex(); i++) {
			System.out.println(cts[i].getId()+"\t"+cts[i].getName()+"\t"+cts[i].getPhone());
		}
	}
	
	public static void findContact() {
		Contact[] cts=manager.getContacts();
		String findname;
		System.out.print("연락처를 검색할 사람을 입력해주세요>>");
		findname=sc.nextLine();
		
		for(int i=0; i<manager.getIndex(); i++) {
			if(cts[i].getName().equals(findname)) {
				System.out.println(cts[i].getId()+"\t"+cts[i].getName()+"\t"+cts[i].getPhone());
			}
		}
	}
	
	
	public static void main(String[] args) {
		while(true) {
			int menu=printMenu();
			
			if(menu==1) {
				createContact();
				
			}else if(menu==2) {
				printContact();
				
			}else if(menu==3) {
				findContact();
				
			}else {
				System.out.println("잘못된 메뉴입니다. 다시 입력하세요.");
			}
			
		}
		
	}

}
