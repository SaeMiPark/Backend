package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import DAO.MusicDAO;
import DTO.MusicDTO;

public class Main {
	public static void main(String[] args) throws ParseException {
		Scanner sc=new Scanner(System.in);
		MusicDAO dao=new MusicDAO();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일");

		while(true) {
			System.out.println("====Melon 관리 시스템====");
			System.out.println("1. 신규 음악 등록");
			System.out.println("2. 음악 목록 출력");
			System.out.println("3. 음악 제목 검색");
			System.out.println("4. ID로 항목 삭제");
			System.out.println("5. ID로 항목 수정");
			System.out.println("0. 시스템 종료");
			System.out.print(">>");
			int menu=Integer.parseInt(sc.nextLine());

			if(menu==0) {
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			}else if(menu==1) {
				System.out.print("ID>> ");
				String id=sc.nextLine();
				System.out.print("제목>> ");
				String title=sc.nextLine();
				System.out.print("가수>> ");
				String singer=sc.nextLine();
				System.out.print("작곡날짜(yyyy년 MM월 dd일로 기입)>> ");
				String datestr=sc.nextLine();

				Date date = formatter.parse(datestr);
				MusicDTO dto=new MusicDTO(id,title,singer,date);

				dao.addMusic(dto);	
			}else if(menu==2) {
				ArrayList<MusicDTO> arr=dao.getmusiclist();
				System.out.println("ID\t제목\t가수\t날짜");
				for(MusicDTO m : arr){
					System.out.println(m.getId()+"\t"
							+m.getTitle()+"\t"
							+m.getSinger()+"\t"
							+formatter.format(m.getDate()));
				}
			}else if(menu==3) {
				System.out.print("검색할 제목을 입력해주세요>>");
				String title=sc.nextLine();

				ArrayList<MusicDTO> arr2=dao.getmusiclist();
				ArrayList<MusicDTO> findarr=dao.findMusic(title);

				//ArrayList끼리 비교할 수 없음.
				/*if(arr2.contains(findarr)) {}*/
				//findarr는 무조건 값을 가지고 있음. 무슨 값? 주소값
				if(findarr.size()==0) {
					System.out.println("노래 정보가 없습니다.");
				}else {
					for(MusicDTO music2: findarr) { 
						if(arr2.contains(music2)) { //처음에 여기에 else를 넣었는데 안 나옴.
							//그 이유는 찾을 게 없다면 findarr가 비어있어서 for문 자체가 돌지 않아 if가 실행될 수 없음.
							//비어있다는 것은 null이라는 의미가 아니다, 텅빈 어레이 리스트라도 어레이 리스트 주소가 들어있다!!!
							//null값을 반환하고 싶다면 함수 반환으로 null을 넣어. 그건 내 마음이다.
							//이럴 떄는 sysout(arr2.contains(music2)) 이 부분이 잘 나오는지 확인해볼 것.
							System.out.println(music2.getId()+"\t"
									+music2.getTitle()+"\t"
									+music2.getSinger()+"\t"
									+formatter.format(music2.getDate()));
						}
					}
				}

			}else if(menu==4) {
				System.out.print("삭제할 ID를 입력해주세요>>");
				String id=sc.nextLine();
				Boolean flag=dao.removeMusic(id);
				if(flag==true) {
					System.out.println("성공적으로 삭제되었습니다.");
				}else {
					System.out.println("삭제할 노래가 존재하지 않습니다.");
				}

			}else if(menu==5) {
				System.out.print("수정할 노래의 ID를 입력해주세요>>");
				String findid=sc.nextLine();
				System.out.print("수정할 제목을 입력해주세요>>");
				String changetitle=sc.nextLine();
				System.out.print("수정할 가수를 입력해주세요>>");
				String changesinger=sc.nextLine();
				System.out.print("수정할 날짜를 입력해주세요(yyyy년 MM월 dd일로 기입)>>");
				String changedatestr=sc.nextLine();
				Date changedate = formatter.parse(changedatestr);

				Boolean flag=dao.modifyMusic(findid,changetitle,changesinger,changedate);
				if(flag==true) {
					System.out.println("성공적으로 수정되었습니다.");
				}else {
					System.out.println("수정할 노래가 존재하지 않습니다.");
				}
			}else {
				System.out.println("메뉴를 다시 확인해주세요.");
			}
		}

	}

}
