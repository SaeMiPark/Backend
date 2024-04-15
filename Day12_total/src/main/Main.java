package main;
//학생관리시스템

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import DAO.StudentDAO;
import DTO.StudentDTO;

public class Main {
	public static void main(String[] args) throws ParseException {
		Scanner sc=new Scanner(System.in);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
		StudentDAO dao=new StudentDAO();

		while(true) {
			System.out.println("학생 관리 시스템");
			System.out.println("1. 신규 학생 등록");
			System.out.println("2. 학생 목록 출력");
			System.out.println("3. 학생 정보 이름으로 검색");
			System.out.println("4. 학생 정보 ID로 삭제");
			System.out.println("5. 학생 정보 ID로 수정");
			System.out.println("6. 시스템 종료");
			System.out.print(">>");
			int menu=Integer.parseInt(sc.nextLine());

			if(menu==1) {
				System.out.print("id>>");
				String id=sc.nextLine();
				boolean IdDuplicateCheck=dao.duplicateIdCheck(id);
				if(IdDuplicateCheck==true) {
					System.out.println("중복하는 ID는 입력할 수 없습니다.");
					continue;
				}
				System.out.print("name>>");
				String name=sc.nextLine();
				System.out.print("kor>>");
				int kor=Integer.parseInt(sc.nextLine());
				System.out.print("eng>>");
				int eng=Integer.parseInt(sc.nextLine());
				System.out.print("math>>");
				int math=Integer.parseInt(sc.nextLine());
				System.out.print("date>>");
				String datestr=sc.nextLine();
				Date date=formatter.parse(datestr);
				StudentDTO dto=new StudentDTO(id,name,kor,eng,math,date);
				
				dao.addStd(dto);
				
			}else if(menu==2) {
				System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균\t날짜");
				ArrayList<StudentDTO> stds=dao.getStds();
				for(StudentDTO std:stds) {
					System.out.println(std.getId()+"\t"+std.getName()+"\t"
							+std.getKor()+"\t"+std.getEng()+"\t"+std.getMath()+"\t"
							+std.getSum()+"\t"+std.getAvg()+"\t"+formatter.format(std.getDate()));
				}

			}else if(menu==3) {
				System.out.print("검색할 이름을 입력하세요>>");
				String name=sc.nextLine();
				ArrayList<StudentDTO> findstds=dao.searchByName(name);
				if(findstds.size()==0) {
					System.out.println("찾는 학생이 존재하지 않습니다.");
				}else {
					for(StudentDTO std: findstds) {
						System.out.println(std.getId()+"\t"+std.getName()+"\t"
								+std.getKor()+"\t"+std.getEng()+"\t"+std.getMath()+"\t"
								+std.getSum()+"\t"+std.getAvg()+"\t"+formatter.format(std.getDate()));
					}
				}

			}else if(menu==4) {
				System.out.print("삭제할 ID를 입력하세요>>");
				String id=sc.nextLine();
				boolean check=dao.deleteById(id);
				if(check==true) {
					System.out.println("삭제되었습니다.");
				}else{
					System.out.println("삭제할 학생이 존재하지 않습니다.");
				}

			}else if(menu==5) {
				System.out.print("수정할 학생의 ID를 입력하세요>>");
				String id=sc.nextLine();
				System.out.print("수정하고 싶은 이름을 입력하세요>>");
				String name=sc.nextLine();
				System.out.print("수정하고 싶은 국어 성적을 입력하세요>>");
				int kor=Integer.parseInt(sc.nextLine());
				System.out.print("수정하고 싶은 영어 성적을 입력하세요>>");
				int eng=Integer.parseInt(sc.nextLine());
				System.out.print("수정하고 싶은 수학 성적을 입력하세요>>");
				int math=Integer.parseInt(sc.nextLine());
				System.out.print("수정하고 싶은 날짜를 입력하세요>>");
				String datestr=sc.nextLine();
				Date date=formatter.parse(datestr);
				
				boolean check=dao.modifyById(id, name, kor, eng, math, date);
				if(check==true) {
					System.out.println("수정되었습니다.");
				}else {
					System.out.println("수정할 대상이 존재하지 않습니다.");
				}
			}else if(menu==6) {
				System.out.println("시스템을 종료합니다.");
				System.exit(0);

			}else {
				System.out.println("메뉴를 다시 확인하세요.");
			}

		}
	}

}
