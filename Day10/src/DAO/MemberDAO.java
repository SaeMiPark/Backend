package DAO;

import java.util.ArrayList;

import classes.Member;

public class MemberDAO {
	private ArrayList<Member> Members=new ArrayList<>(); //배열은 동일한 타입의 변수를 담는 곳
	//private int index=0;
	
	public void addMember(Member member) {
		this.Members.add(member);
	}


	public ArrayList<Member> getMembers() { 
		return Members;
	}


	/*public int getIndex() {
		return Members.size();
	}*/


}

//silver, 어떤 멤버에 얼마 포인트를 더할 건지
/*public void addPoint(Silver member, int point) {
		member.setPoint(member.getPoint()+point);
	}*/
