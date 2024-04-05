//Quiz02==view
package quies;
import java.util.Scanner;

import classes.Student;
import models.StudentManager;

public class Quiz02 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		StudentManager manager=new StudentManager();

		while(true) {
			System.out.println("\n<<학생 관리 시스템>>");
			System.out.println("1. 신규 정보 입력");
			System.out.println("2. 학생 목록 출력");
			System.out.println("3. 학생 정보 검색");
			System.out.println("0. 시스템 종료");
			System.out.print(">>");
			int menu=Integer.parseInt(sc.nextLine());

			if(menu==1) {
				String name="";
				int id=0, kor=0, eng=0, mat=0;
				
				System.out.print("학생 이름 : ");
				name=sc.nextLine();
				System.out.print("학번 : ");
				id=Integer.parseInt(sc.nextLine());
				System.out.print(name+"학생 국어 : ");
				kor=Integer.parseInt(sc.nextLine());
				System.out.print(name+"학생 영어 : ");
				eng=Integer.parseInt(sc.nextLine());
				System.out.print(name+"학생 수학 : ");
				mat=Integer.parseInt(sc.nextLine());

				manager.addStudent(new Student(id, name, kor, eng, mat));

			}else if(menu==2) {
				Student[] stds=manager.getStds();
				System.out.println("번호\t이름\t국어\t영어\t수학\t합계\t평균");
				//System.out.print("count입니다 "+Student.count);
				//System.out.println(stds[0]);
				//System.out.println(stds[1]);
				for(int i=1; i<manager.getIndex(); i++) {
					System.out.println(stds[i].getId()+"\t"+stds[i].getName()+"\t"
							+stds[i].getKor()+"\t"+stds[i].getEng()+"\t"+stds[i].getMat()+"\t"
							+stds[i].getSum()+"\t"+stds[i].getAvg());
				}
			}else if(menu==3) {
				System.out.println("검색하고 싶은 학생의 이름을 입력해주세요.");
				System.out.print(">>");
				String findname=sc.nextLine();

				Student[] stds=manager.getStds();
				System.out.println("번호\t이름\t국어\t영어\\t수학\t합계\t평균");
				for(int i=0; i<manager.getIndex();i++) {
					if(stds[i].getName().contains(findname)) {
						System.out.println(stds[i].getId()+"\t"+stds[i].getName()
								+"\t"+stds[i].getKor()+"\t"+stds[i].getEng()+"\t"+stds[i].getMat()
								+"\t"+stds[i].getSum()+"\t"+stds[i].getAvg());
					}
				}

			}else if(menu==0) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);

			}else {
				System.out.println("잘못된 메뉴 선택입니다.");
			}

		}


	}
}
