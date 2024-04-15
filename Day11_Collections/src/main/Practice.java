package main;

import DTO.MusicDTO;

public class Practice {
	int a;//전역변수 객체변수
	
	public static void main(String[] args) {
		Practice prac=new Practice();
		prac.a+=10;
		System.out.println(prac.a);
		int b; //지역변수
		//b+=10;
		
		
		/* int[] intarr=new int[5];
		 String[] strarr=new String[5];
		 MusicDTO[] musics=new MusicDTO[5];
		 
		 
		 //1,2,3 for문 foreach문 출력 똑같음
		 //1
		 for(int intone: intarr) {
			 System.out.println(intone);
		 }
		 
		 //2-3번 연결
		 for(String strone: strarr) {
			 System.out.println(strone);
		 }
		 
		 for(String strone: strarr) {
			 System.out.println(strone.charAt(2)); //NullPointerException
		 }
		 
		 
		 //4-5번 연결
		 for(int i=0; i<musics.length; i++) {
			 System.out.println(musics[i]);
		 }
		 
		 //5
		 for(int i=0; i<musics.length; i++) {
			 System.out.println(musics[i].getId()); //NullPointerException
		 }
		 
		 //NullPointerException 정확히는 너 null에 접근해서 뭐하게? 거기 null이야
		 //런타임 에러
		 */
	}

}
